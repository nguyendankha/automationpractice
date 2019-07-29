package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.AssertCollection;
import utilities.JSWaiter;
import utilities.Log;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ContactUsPage extends BasePage{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    public static String BASE_URL = "contact";
    //*********Web Elements*********
    private static By SELECT_SUBJECT_HEADING = By.cssSelector("#id_contact");
    private static By PAGE_HEADING = By.cssSelector(".page-heading");
    private static By CONTACT_US_FORM = By.cssSelector(".contact-form-box");
    private static By TXT_EMAIL = By.cssSelector("#email");
    private static By SELECT_ORDER_REFERENCE = By.cssSelector("#id_order");
    private static By ORDER_REFERENCE_OPTION = By.cssSelector("");
    private static By SELECT_PRODUCT = By.cssSelector("");
    private static By PRODUCT_OPTION = By.cssSelector("");

    private static By TXT_UPLOADER = By.cssSelector("#fileUpload");
    private static By TXT_MESSAGE = By.cssSelector("#message");
    private static By BTN_SEND = By.cssSelector("#submitMessage");
    private static By ERROR_MESSAGE = By.cssSelector(".alert-danger");
    private static By ALERT_MESSAGE = By.cssSelector(".alert-success");
    private static By BTN_HOME = By.cssSelector(".footer_links a");

    //******Page Methods******

    public void isOnContactUsPage(){

        //TO DO

    }

    public void selectSubject(){
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void inputEmailAddress(){

        //TO DO

    }

    public void inputMessage(){

        //TO DO

    }

    public void clickSubmitButton(){

        //TO DO

    }

    public void selectOrderReference(){
        Log.debug("TestContactUsPage - Verify the expected order reference is displayed then select it");
        String orderOption;
        String orderValue;
        boolean isOrderExist = false;
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void selectProduct(){
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void setClipboardContents(String string){

        //TO DO

    }

    public void attachFile() {
        String filePath = "D:\\test.pdf";
        try {

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void isOnContactUsSentPage(){
        Log.debug("Verify if user is on Contact Us - Submit form successfully page");

        //TO DO

    }

    public void isSuccessfulMessageDisplayed(){

        //TO DO

    }

    public void clickHomeButton(){
        click(BTN_HOME);
    }
}
