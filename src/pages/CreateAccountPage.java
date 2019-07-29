package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.AssertCollection;
import utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import objects.Customer;
import org.testng.Assert;

import java.util.List;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver)
    {
        super(driver);
    }

    //*********Page Variables*********
    public static String BASE_URL = "account-creation";

    //*********Web Elements*********

    private static By FORM_CREATE_ACCOUNT  = By.cssSelector("#create-account_form");
    // YOUR PERSONAL INFORMATION
    private static By RAD_GENDER = By.cssSelector("#account-creation_form .clearfix > label");
    private static By RAD_GENDER_MALE = By.cssSelector("#id_gender1");
    private static By RAD_GENDER_FEMALE = By.cssSelector("#id_gender2");
    private static By TXT_FIRST_NAME = By.cssSelector("#customer_firstname");
    private static By TXT_LAST_NAME = By.cssSelector("#customer_lastname");
    private static By TXT_EMAIL = By.cssSelector("#email");
    private static By TXT_PASSWORD = By.cssSelector("#passwd");
    private static By SELECT_DAY_OF_BIRTH = By.cssSelector("#days");
    private static By SELECT_MONTH_OF_BIRTH = By.cssSelector("#months");
    private static By SELECT_YEAR_OF_BIRTH = By.cssSelector("#years");
    private static By CHK_NEWSLETTER = By.cssSelector("#newsletter");
    private static By CHK_SPECIAL_OFFERS = By.cssSelector("#optin");
    private static By BTN_REGISTER = By.cssSelector("#submitAccount");

    //YOUR ADDRESS
    private static By TXT_ADDRESS_FRIST_NAME = By.cssSelector("input#firstname");
    private static By TXT_ADDRESS_LAST_NAME = By.cssSelector("input#lastname");
    private static By TXT_ADDRESS_COMPANY = By.cssSelector("input#company");
    private static By TXT_ADDRESS_ADDRESS1 = By.cssSelector("input#address1");
    private static By TXT_ADDRESS_ADDRESS2 = By.cssSelector("input#address2");
    private static By TXT_ADDRESS_CITY = By.cssSelector("input#city");
    private static By TXT_ADDRESS_STATE = By.cssSelector("#id_state");
    private static By TXT_ADDRESS_ZIP_CODE = By.cssSelector("#postcode");
    private static By SELECT_ADDRESS_COUNTRY = By.cssSelector("#id_country");
    private static By TXT_ADDRESS_ADD_INFO = By.cssSelector("#other");
    private static By TXT_ADDRESS_HOME_PHONE = By.cssSelector("#phone");
    private static By TXT_ADDRESS_MOBILE_PHONE = By.cssSelector("#phone_mobile");
    private static By TXT_ADDRESS_ALIAS = By.cssSelector("#alias");
    private static By PASSWORD_TEXT_LABEL = By.cssSelector("label[for='passwd']");
    private static By REQUIRE_FIELD_LABEL = By.cssSelector(".submit .required span");
    private static By ADDRESS1_EXAMPLE_LABEL = By.cssSelector("label[for='address1'] ~ span");
    private static By ADDRESS2_LABEL = By.cssSelector("label[for='address2']");
    private static By PHONE_TEXT_LABEL = By.cssSelector("label[for='phone']");

    public void isOnCreateAccountPage()
    {

        //TO DO

    }

    public void writeCreateAccountFormFromExistingCustomer(Customer customer){

        //TO DO

    }

    public void clickRegisterButton(){

        //TO DO

    }

    public void isDisplayedEmailSameTheInputedEmailFromLoginPage(String inputEmail){

        //TO DO

    }

    public void isFirstNameOnBillingFormDisplayCorrectly(String inputFirstName){

        //TO DO

    }

    public void isLastNameOnBillingFormDisplayCorrectly(String inputLastName){

        //TO DO

    }

    public void isCountryDisplayCorrectly(String selectCountry){

        //TO DO

    }

    public void isCreateAccountFormDisplayCorrectly(){

        //TO DO

    }

}
