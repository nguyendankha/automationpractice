package test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.PageController;
import utilities.DesiredCapsManager;
import utilities.DriverManager;
import utilities.JSWaiter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;

/**
 * Created by KYZU
 * Date: 9/4/2018
 * Time: 1:14 PM
 **/
public class TestBase {
    protected  WebDriver driver;
    private  DesiredCapsManager desiredCapsManager = new DesiredCapsManager();
    public  PageController webApp;
    protected  JSWaiter waiter;

    //Do the test setup
    @BeforeTest
    @Parameters(value={"browser","platform", "driverPath"})
    public void setupTest (String browser, String platform, String driverPath) throws MalformedURLException {
        System.out.println("Browser: " + browser);
        System.out.println("Platform: " + platform);
        System.out.println("driverPath: " + driverPath);

        //Get DesiredCapabilities
        DesiredCapabilities capabilities = desiredCapsManager.getDesiredCapabilities(browser,platform);
        //Create Driver with capabilities
        driver = new DriverManager(capabilities, browser, driverPath).createDriver();
        //Send driver object to JSWaiter Class
        waiter = new JSWaiter(driver);
        //Maximize Window
        driver.manage().window().maximize();
        webApp = new PageController(driver);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    public PageController getWebApp() {
        return webApp;
    }

    public void setWebApp(PageController webApp) {
        this.webApp = webApp;
    }
}
