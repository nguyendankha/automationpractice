package test;

import objects.Customer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Log;


import static org.testng.Assert.*;

public class TestLoginPage extends TestBase {
    Customer customer;

    @BeforeTest
    public void navigateToLoginPage(){

        //Open Home Page
        webApp.navigateToURL(HomePage.BASE_URL);

        //Check Header Info is displayed
        webApp.getHeaderContainer().isHeaderContainerDisplayed();

        //Click Sign in button to navigate to Log In page
        webApp.getHeaderContainer().clickSignInButton();

        //Check Log In page is displayed
        webApp.getLoginPage().isOnLoginPage();
    }

    public void registerAccount(Customer customer) throws Exception {
        //Fill the random email to Sign up form and submit
        customer.createCustomerWithRandomizedInformation();
        webApp.getLoginPage().inputAEmailToCreateForm(customer.getEmail());
        webApp.getLoginPage().clickCreateAnAccountButton();

        //Checkpoint: Check if user is on Create account page
        webApp.getCreateAccountPage().isOnCreateAccountPage();

        //Fill in Create Account form with customer data & submit
        webApp.getCreateAccountPage().writeCreateAccountFormFromExistingCustomer(customer);
        webApp.getCreateAccountPage().clickRegisterButton();

        //Checkpoint: Check if user registered an account successfully and is on My account page
        webApp.getMyAccountPage().isOnMyAccountPage();
    }

    @Test(priority = 1)
    //I.3. Create an account with valid user’s data.
    public void asAUserIWantToCreateAnAccountWithValidData() throws Exception {
        //Define test case name
        String testCaseName = "Step#3 As A User I Want To Create An Account with valid data";
        Log.debug("LoginPageTest - " + testCaseName);

        customer = new Customer();
        customer.createCustomerWithRandomizedInformation();
        //email = customer.getEmail();
        //Set the above email in the email address field in Create An Account form
        webApp.getLoginPage().inputAEmailToCreateForm(customer.getEmail());

        //Click Create an account button to navigate to CREATE AN ACCOUNT page
        webApp.getLoginPage().clickCreateAnAccountButton();

        //Check CREATE AN ACCOUNT page is displayed
        webApp.getCreateAccountPage().isOnCreateAccountPage();
        webApp.getCreateAccountPage().isCreateAccountFormDisplayCorrectly();

        //Input valid information to create account
        webApp.getCreateAccountPage().writeCreateAccountFormFromExistingCustomer(customer);
        webApp.getCreateAccountPage().isDisplayedEmailSameTheInputedEmailFromLoginPage(customer.getEmail());
        webApp.getCreateAccountPage().isFirstNameOnBillingFormDisplayCorrectly(customer.getCustomerFirstName());
        webApp.getCreateAccountPage().isLastNameOnBillingFormDisplayCorrectly(customer.getCustomerSurname());
        webApp.getCreateAccountPage().isCountryDisplayCorrectly(customer.getCountry());

        //Click Register Button to go to My Account page
        webApp.getCreateAccountPage().clickRegisterButton();

        //Checkpoint: Check My Account page content displayed after user registered successfully
        webApp.getMyAccountPage().isOnMyAccountPage();

        //Click Sign Out button on My Account Page
        webApp.getHeaderContainer().clickSignOutButton();
    }

    @Test(priority = 2)
    //I.2. Create an account with has already been registered.
    public void asAUserIWantToCreateAnAccountWhichHasAlreadyBeenRegistered() throws Exception {
        String testCaseName = "TEST CASE I.2: User creates an account which has already been registered";
        Log.info("TestLoginPage - " + testCaseName);

        //TO DO

    }

    @Test(priority = 3)
    //I.1.Try to create an account without entered email.
    public void asAUserIWantToCreateAnAccountWithoutEnteredEmail() {
        String testCaseName = "TEST CASE I.1 - As A User I Want To Create An Account Without Entered Email in Login Page";
        Log.debug("LoginPageTest - " + testCaseName);

        //TO DO

    }

    @Test(priority = 4)
    //I.4. Login with invalid account which is not registered yet
    public void asAUserIWantToLoginWithNonRegisterAccount() throws Exception {
        String testCaseName = "TEST CASE I.4 - As A User I Want To Login with invalid account which is not registered yet";
        Log.debug("LoginPageTest - " + testCaseName);

        //TO DO

    }

    @Test(priority = 5)
    //I.5 and I.6. Login with registered account then logout
    public void asAUserIWantToLoginWithRegisteredAccountThenLogOut() throws Exception {
        String testCaseName = "TEST CASE I.5 and I.6 - As A User I Want To Login with registered account then logout";
        Log.debug("LoginPageTest - " + testCaseName);

        //TO DO

    }
}