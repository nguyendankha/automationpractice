package pages;

import utilities.AssertCollection;
import utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    public static String BASE_URL = "my-account";

    //*********Web Elements*********
    private static By TAB_CONTENT = By.cssSelector("div.columns-container");
    private static By CREATE_ACC_FORM = By.cssSelector("form#create-account_form");
    private static By CREATE_ACC_EMAIL = By.cssSelector("form#create-account_form input#email_create");
    private static By BTN_CREATE_ACC = By.cssSelector("form#create-account_form button#SubmitCreate");
    private static By VALID_EMAIL_CHECKING_FROM_CREATE_FORM = By.cssSelector("form#create-account_form div.form-ok input");
    private static By INVALID_EMAIL_CHECKING_FROM_CREATE_FORM = By.cssSelector("form#create-account_form div.form-error input");

    private static By LOGIN_FORM = By.cssSelector("form#login_form");
    private static By LOGIN_EMAIL = By.cssSelector("form#login_form input#email");
    private static By LOGIN_PASSWORD = By.cssSelector("form#login_form input#passwd");
    private static By LOGIN_FORGOT_PASSWORD_LINK = By.cssSelector("form#login_form p.lost_password a");
    private static By BTN_SUBMIT_LOGIN = By.cssSelector("form#login_form button#SubmitLogin");
    private static By INVALID_EMAIL_LOGIN_ALERT = By.cssSelector("div.col-xs-12 div.alert.alert-danger p");
    private static By CREATE_ACCOUNT_ERROR = By.cssSelector ("form#create-account_form div#create_account_error");

    private static By SIGNUP_FORM_OK_ICON = By.cssSelector("form#create-account_form .form-ok");
    private static By SIGNUP_FORM_ERROR_ICON = By.cssSelector("form#create-account_form .form-error");
    private static By LOGIN_FORM_OK_ICON = By.cssSelector("form#login_form .form-ok");
    private static By LOGIN_FORM_ERROR_ICON = By.cssSelector("form#login_form .form-error");

    public void isOnLoginPage()
    {
        waiter.waitForPageLoaded();
        Log.debug("LoginPageLog - Verify if user is on login page.");
        AssertCollection results = new AssertCollection();
        String currentURL = driver.getCurrentUrl();
        results.addItem("Verify if user is on Login page", true, currentURL.contains(BASE_URL));
        results.addItem("Content Login page not display correctly.", true, isElementExist(TAB_CONTENT));
        results.addItem("Create Account Form not display correctly.", true, isElementExist(CREATE_ACC_FORM));
        results.addItem("Login Form not displayed correctly.", true, isElementExist(LOGIN_FORM));
        results.addItem("Login Forgot Password Link not displayed correctly.", true, isElementExist(LOGIN_FORGOT_PASSWORD_LINK));
        Assert.assertTrue(results.getAssertResult(), results.getAssertMessage());
    }

    //Input a email to create form
    public void inputAEmailToCreateForm(String email)
    {
        Log.debug("Input e-mail in Create form: " + email);
        deleteText(CREATE_ACC_EMAIL);
        writeText(CREATE_ACC_EMAIL,email);
    }
    //Input a email to login form
    public void inputEmailPasswordForLogin(String user,String pass) {
        deleteText(LOGIN_EMAIL);
        deleteText(LOGIN_PASSWORD);
        Log.debug("Input e-mail in Login form: " + user);
        writeText(LOGIN_EMAIL,user);
        Log.debug("Input password in Login form: " + pass);
        writeText(LOGIN_PASSWORD, pass);
    }

    public void isSignUpInvalidEmailErrorMessagesDisplayed(){
        waitAnElementDisplay(CREATE_ACCOUNT_ERROR);
        Assert.assertTrue(isElementExist(CREATE_ACCOUNT_ERROR),"Sign up - Warning messages for missing/ invalid email address is not displayed");
    }

    public void isSignUpInvalidEmailErrorIconDisplayed(){
        waitAnElementDisplay(SIGNUP_FORM_ERROR_ICON);
        Assert.assertTrue(isElementExist(SIGNUP_FORM_ERROR_ICON),"Sign up - Error icon for invalid email address is not displayed");
    }

    public void isSignUpValidEmailOKIconDisplayed(){
        waitAnElementDisplay(SIGNUP_FORM_OK_ICON);
        Assert.assertTrue(isElementExist(SIGNUP_FORM_OK_ICON),"Sign up - OK icon for valid email address is not displayed");
    }

    public void isLoginInvalidEmailErrorMessagesDisplayed(){
        waitAnElementDisplay(INVALID_EMAIL_LOGIN_ALERT);
        Assert.assertTrue(isElementExist(INVALID_EMAIL_LOGIN_ALERT),"Login - Warning messages for missing/ invalid email address is not displayed");
    }

    public void isLoginInvalidEmailErrorIconDisplayed(){
        waitAnElementDisplay(LOGIN_FORM_ERROR_ICON);
        Assert.assertTrue(isElementExist(LOGIN_FORM_ERROR_ICON),"Login - Error icon for invalid email address is not displayed");
    }

    public void isLoginValidEmailOKIconDisplayed(){
        waitAnElementDisplay(LOGIN_FORM_OK_ICON);
        Assert.assertTrue(isElementExist(LOGIN_FORM_OK_ICON),"Login - OK icon for valid email address is not displayed");
    }

    public void clickCreateAnAccountButton(){
        click(BTN_CREATE_ACC);
        waiter.waitJQueryAngular();
    }

    public void clickSignInButton(){
        click(BTN_SUBMIT_LOGIN);
    }

    public String generateRandomEmail(int count){
        String getEmail = randomEmailAddress(count);
        return getEmail.toString();
    }

    public void clickForgotPassLink(){
        click(LOGIN_FORGOT_PASSWORD_LINK);
    }

    public void validateEmailInInputEmailField(){
        String invalidEmail = randomAlphaNumeric(7);
        writeText(CREATE_ACC_EMAIL, invalidEmail);
        click(By.cssSelector("form#create-account_form p"));
        if(isElementExist(INVALID_EMAIL_CHECKING_FROM_CREATE_FORM)){
            Log.info("Email field change to red when the input email invalid");
        }
    }

    public String generateRandomPassword (int count){
        String getPassword = randomAlphaNumeric(count);
        return getPassword.toString();
    }

    public void outOfFocusCreateAccEmailField() {
        outOfFocus(CREATE_ACC_EMAIL);
    }

    public void outOfFocusLoginEmailField() {
        outOfFocus(LOGIN_EMAIL);
    }


}
