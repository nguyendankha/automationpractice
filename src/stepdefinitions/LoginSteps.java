package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.Customer;
import pages.BasePage;
import pages.LoginPage;
import utilities.Log;

public class LoginSteps extends BaseSteps {

    private static String email;
    private static  String password;

    public LoginSteps() {
    };

    @And("^I am on the Login Page$")
    public void iAmOnTheLoginPage() throws Throwable{
        try
        {
            loginPage.isOnLoginPage();
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @And("^I set new e-mail in the create form on the Login Page$")
    public void iSetNewEmailInTheCreateFormOnTheLoginPage() throws Throwable{
        try
        {
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @And("^I click the Create Account button on the Login Page$")
    public void iClickTheCreateAccountButtonOnTheLoginPage() throws Throwable{
        try
        {
            Log.debug("I click the Create Account button on the Login Page");
            loginPage.clickCreateAnAccountButton();
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @And("^I input a registered email and password on the Login Page$")
    public void iInputEmailAndPasswordOnTheLoginPage() throws Throwable {
        try{
            loginPage.inputEmailPasswordForLogin(email, password);
        }
        catch(Exception e){
            throw e;
        }
    }

    @And("^I click the Sign In button on the Login page$")
    public void iClickTheSignInButtonOnTheLoginPage() throws Throwable {
        try{
            loginPage.clickSignInButton();
        }
        catch(Exception e){
            throw e;
        }
    }

    @When("^I input an invalid email and password on the Login Page$")
    public void iInputAnInvalidEmailAndPasswordOnTheLoginPage() throws Throwable {
        try{
            customer = new Customer();
            customer.createCustomerWithRandomizedInformation();
            email = customer.getEmail();
            password = customer.getPassword();
            loginPage.inputEmailPasswordForLogin(email, password);
        }
        catch(Exception e){
            throw e;
        }
    }

    @Then("^I receive a Login error message on the Login page$")
    public void iReceiveALoginErrorMessageOnTheLoginPage() throws Throwable {
        try{
        }
        catch(Exception e){
            throw e;
        }
    }

    @When("^I leave blank e-mail in the Login form on the Login Page$")
    public void iLeaveBlankEMailInTheLoginFormOnTheLoginPage() throws Throwable {
        try{
        }
        catch(Exception e){
            throw e;
        }
    }

    @Then("^I receive a Login error icon on the Login page$")
    public void iReceiveALoginErrorIconOnTheLoginPage() throws Throwable {
        try{
        }
        catch(Exception e){
            throw e;
        }
    }

    @And("^I leave blank e-mail in the create form on the Login Page$")
    public void iLeaveBlankEMailInTheCreateFormOnTheLoginPage() throws Throwable {
        try{
            loginPage.outOfFocusCreateAccEmailField();
        }
        catch(Exception e){
            throw e;
        }
    }

    @Then("^I receive a Create Account error message on the Login Page$")
    public void iReceiveACreateAccountErrorMessageOnTheLoginPage() throws Throwable {
        try {
            Log.debug("I receive a Create Account error message on the Login Page");
            loginPage.isSignUpInvalidEmailErrorMessagesDisplayed();
        } catch (Exception e) {
            throw e;
        }
    }

    @Then("^I receive a Create Account error icon on the Login page$")
    public void iReceiveACreateAccountErrorIconOnTheLoginPage() throws Throwable {
        try {
        } catch (Exception e) {
            throw e;
        }
    }

    @And("^I input a valid email and password on the Login Page$")
    public void iInputAValidEmailAndPasswordOnTheLoginPage() throws Throwable {
        try{
            loginPage.inputEmailPasswordForLogin(email, password);
        }
        catch(Exception e){
            throw e;
        }
    }

    @And("^I input the new email in the create account form on the Login page$")
    public void iInputTheNewEmailInTheCreateAccountFormOnTheLoginPage() throws Exception {
        try{
            Log.debug("I set new e-mail in the create form on the Login Page");
            customer = new Customer();
            customer.createCustomerWithRandomizedInformation();
            email = customer.getEmail();
            password = customer.getPassword();
            loginPage.inputAEmailToCreateForm(email);
        }
        catch(Exception e){
            throw e;
        }
    }

    @When("^I input the registered email in the create account form on the Login page$")
    public void iInputTheRegisteredEmailInTheCreateAccountFormOnTheLoginPage() throws Throwable {
        try{
            Log.debug("I input the registered email in the create account form on the Login page");
            email = customer.getEmail();
            password = customer.getPassword();
            loginPage.inputAEmailToCreateForm(email);
        }
        catch(Exception e){
            throw e;
        }
    }

    @Then("^I can see the Message for email already registered appeared$")
    public void iCanSeeTheMessageForEmailAlreadyRegisteredAppeared() throws Throwable {
        try{
            Log.debug("I can see the Message for email already registered appeared");
            loginPage.isSignUpInvalidEmailErrorMessagesDisplayed();
        }
        catch(Exception e){
            throw e;
        }
    }
}
