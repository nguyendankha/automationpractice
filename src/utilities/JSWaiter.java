package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;

/**
 * Created by KYZU
 * Date: 9/1/2018
 * Time: 1:09 PM
 **/
public class JSWaiter {
    private static WebDriver jsWaitDriver;
    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;
    private static int serverTimeout = 15;

    //Get the driver from relevant test
    public JSWaiter(WebDriver driver) {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, serverTimeout);
        jsExec = (JavascriptExecutor) jsWaitDriver;
    }

    //Wait for JQuery Load
    public void waitForJQueryLoad() {
        final String jQueryActiveScript = "return jQuery.active==0";

        //Get JQuery is Ready
        boolean jqueryReady = (Boolean) jsExec.executeScript(jQueryActiveScript);

        //Wait JQuery until it is Ready!
        if(!jqueryReady) {
            System.out.println("JQuery is NOT Ready!");
            //Wait for jQuery to load
            jsWait.until(jsWaitDriver ->
            {
                boolean isJQueryFinished = (boolean) ((JavascriptExecutor) jsWaitDriver).executeScript(jQueryActiveScript);
                return isJQueryFinished;
            });
        } else {
            System.out.println("JQuery is Ready!");
        }
    }

    //Wait for Angular Load
    public void waitForAngularLoad() {
        WebDriverWait wait = new WebDriverWait(jsWaitDriver, serverTimeout);
        JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

        final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

        //Get Angular is Ready
        boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

        //Wait ANGULAR until it is Ready!
        if(!angularReady) {
            System.out.println("ANGULAR is NOT Ready!");
            //Wait for Angular to load
            wait.until(jsWaitDriver ->
            {
                boolean isAngularFinished = (boolean) ((JavascriptExecutor) jsWaitDriver).executeScript(angularReadyScript);
                return isAngularFinished;
            });
        } else {
            System.out.println("ANGULAR is Ready!");
        }
    }

    //Wait Until JS Ready
    public void waitUntilJSReady() {
        WebDriverWait wait = new WebDriverWait(jsWaitDriver, serverTimeout);
        JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

        final String strReadyState = "return document.readyState";

        //Get JS is Ready
        boolean jsReady =  jsExec.executeScript(strReadyState).toString().equals("complete");

        //Wait Javascript until it is Ready!
        if(!jsReady) {
            System.out.println("JS in NOT Ready!");
            //Wait for Javascript to load
            wait.until(jsWaitDriver ->
            {
                boolean isAngularFinished = ((JavascriptExecutor) jsWaitDriver).executeScript(strReadyState).toString().equals("complete");
                return isAngularFinished;
            });
        } else {
            System.out.println("JS is Ready!");
        }
    }

    //Wait Until JQuery and JS Ready
    public void waitUntilJQueryReady() {
        JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

        //First check that JQuery is defined on the page. If it is, then wait AJAX
        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined == true) {
            //Pre Wait for stability (Optional)
//            sleep(page.serverTimeout/2);

            //Wait JQuery Load
            waitForJQueryLoad();

            //Wait JS Load
            waitUntilJSReady();

            //Post Wait for stability (Optional)
//            sleep(page.serverTimeout/2);
        }  else {
            System.out.println("jQuery is not defined on this site!");
        }
    }

    //Wait Until Angular and JS Ready
    public void waitUntilAngularReady() {
        JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

        //First check that ANGULAR is defined on the page. If it is, then wait ANGULAR
        Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
        if (!angularUnDefined) {
            Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
            if(!angularInjectorUnDefined) {
                //Pre Wait for stability (Optional)
                sleep(20);

                //Wait Angular Load
                waitForAngularLoad();

                //Wait JS Load
                waitUntilJSReady();

                //Post Wait for stability (Optional)
                sleep(20);
            } else {
                System.out.println("Angular injector is not defined on this site!");
            }
        }  else {
            System.out.println("Angular is not defined on this site!");
        }
    }

    //Wait Until JQuery Angular and JS is ready
    public void waitJQueryAngular() {
        waitUntilJQueryReady();
        waitUntilAngularReady();
    }

    public static void sleep (long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(jsWaitDriver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}
