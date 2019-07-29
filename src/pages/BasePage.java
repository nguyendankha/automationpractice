package pages;

import org.omg.IOP.ExceptionDetailMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;
import utilities.JSWaiter;
import utilities.AssertCollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 * Created by KYZU
 * Date: 9/1/2018
 * Time: 12:54 PM
 **/
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public int serverTimeout = 20;
    public JSWaiter waiter;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, serverTimeout);
        waiter = new JSWaiter(driver);
    }

    public void navigateToURL(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    //Click Method by locator
    public void click(By elementLocation) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
        driver.findElement(elementLocation).click();
    }

    //Click Method by Web Element
    public void click(WebElement element) {
        element.click();
    }

    //select Method by locator
    public void select(By elementLocation, String string) {
        Select drpDay = new Select(driver.findElement(elementLocation));
        drpDay.selectByVisibleText(string);
    }

    //Write Text by locator
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Write Text by Web Element
    public void writeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    //Clean Write Test by locator
    public void deleteText(By elementLocation) {
        driver.findElement(elementLocation).clear();
    }

    //Clean Write Test by Web Element
    public void deleteText(WebElement element) {
        element.clear();
    }

    //Read Text
    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    //Read Text
    public String readText(WebElement element) {
        return element.getText();
    }

    //Is Web Element exist by locator?
    public boolean isElementExist(By elementLocation) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return driver.findElement(elementLocation).isDisplayed();
        } catch (Exception ex) {
            driver.manage().timeouts().implicitlyWait(serverTimeout, TimeUnit.SECONDS);
            return false;
        }
    }

    //Is Web Element exist by element?
    public boolean isElementExist(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (Exception ex) {
            driver.manage().timeouts().implicitlyWait(serverTimeout, TimeUnit.SECONDS);
            return false;
        }
    }

    public String getCurrentURL() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    //Generate a random string
    public String randomAlphaNumeric(int count) {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ._0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    //Get Current Time of System
    public long getCurrentTime() {
        Date date = new Date();
        long time = date.getTime();
        return time;
    }

    //Generate a random email base on the random string and current time
    public String randomEmailAddress(int count) {
        String newEmail = randomAlphaNumeric(count);
        long currentTime = getCurrentTime();
        newEmail = newEmail + currentTime + "@gmail.com";
        return newEmail.toString();
    }


    public void selectValueOnDropBox(By elementLocation, int num) {
        Select optionSelect = new Select(driver.findElement(elementLocation));
        optionSelect.selectByIndex(num);
    }

    public void selectValueOnDropBox(By elementLocation, String text) {
        Select optionSelect = new Select(driver.findElement(elementLocation));
        optionSelect.selectByValue(text);
    }

    public void selectVisibleTextOnDropBox(By elementLocation, String text) {
        Select optionSelect = new Select(driver.findElement(elementLocation));
        optionSelect.selectByVisibleText(text);
    }

    public void waitAnElementDisplay(By elementLocation){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public void waitAnElementPresent(By elementLocation){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public int countElementDisplayed(By elementLocation){
        List products = driver.findElements(elementLocation);
        //display product count
        return products.size();
    }

    //Get number of items
    public int getNumberOfItems (By elementLocation){
        List<WebElement> items = null;
        try {
            items = driver.findElements(elementLocation);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return items.size();
    }

    //Get item
    public WebElement getItems (By elementLocation, int index){
        List<WebElement> items = null;
        try {
            items = driver.findElements(elementLocation);
        }
        catch (Exception ex){
            System.out.print(ex);
        }
        return items.get(index);
    }

    //Get list of items
    public List<WebElement> getListItems (By elementLocation){
        List<WebElement> items = null;
        try {
            items = driver.findElements(elementLocation);
        }
        catch (Exception ex){
            System.out.print(ex);
        }
        return items;
    }

    public void outOfFocus (By elementLocation){
        driver.findElement(elementLocation).sendKeys(Keys.TAB);
    }

    public void moveMouseOverProduct(By elementLocation){
        Actions act = new Actions(driver);
        waitAnElementDisplay(elementLocation);
        WebElement ele = driver.findElement(elementLocation);
        act.moveToElement(ele).build().perform();
    }

    public String getDisplayedValueElement(By elementLocation){
        String valueElement = driver.findElement(elementLocation).getAttribute("value");
        return valueElement;
    }

    public double parsePriceStringToDouble(String price){
        //Delete the $ sign from the string
        StringBuilder tempString = new StringBuilder(price);
        tempString.deleteCharAt(0);
        double doublePrice = Double.parseDouble(tempString.toString());
        return doublePrice;
    }

    public double parsePercentStringToDouble(String percent){
        //Delete % sign from the string
        int index = percent.indexOf("%");
        StringBuilder tempString = new StringBuilder(percent);
        tempString.deleteCharAt(index);
        double doublePercent = Double.parseDouble(tempString.toString());
        return doublePercent;
    }

}