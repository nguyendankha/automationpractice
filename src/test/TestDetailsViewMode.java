package test;

import cucumber.api.java.Before;
import objects.Customer;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.JSWaiter;
import utilities.Log;

public class TestDetailsViewMode extends TestBase {

    Customer customer;

    public void registerAccount(Customer user){
        try {
            user.createCustomerWithRandomizedInformation();

            //Fill the random email to Sign up form and submit
            webApp.getLoginPage().inputAEmailToCreateForm(user.getEmail());
            webApp.getLoginPage().clickCreateAnAccountButton();

            //Checkpoint: Check if user is on Create account page
            webApp.getCreateAccountPage().isOnCreateAccountPage();

            //Fill in Create Account form with customer data & submit
            webApp.getCreateAccountPage().writeCreateAccountFormFromExistingCustomer(user);
            webApp.getCreateAccountPage().clickRegisterButton();

            //Checkpoint: Check if user registered an account successfully and is on My account page
            webApp.getMyAccountPage().isOnMyAccountPage();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    @BeforeTest
    public void accessToDetailsViewMode(){
        //Access to Home page
        webApp.getHomePage().navigateToHomePage();
        webApp.getHomePage().isOnHomePage();

        //Select a product and click More button
        webApp.getProductDetailsView().clickViewDetailsProduct();
        webApp.getProductDetailsView().isOnProductDetailsPage();
    }

    @Test(priority = 1)
    //Assignment 3: Details View Mode - Test case II.1: Performing the same steps as above Quick View mode (All of 6 steps)
    public void verifyDetailsViewModeFunctions() throws Exception {
        String testCaseName = "TEST CASE  II.1: Performing the same steps as above Quick View mode (All of 6 steps)";
        Log.info("TestProductDetailsView - " + testCaseName);

        //TO DO

    }

    @Test(priority = 2)
    //Assignment 3: Details View Mode - Test case II.3: Checking by Send to a friend function
    public void verifySendToAFriendFunctions() {
        String testCaseName = "TEST CASE  II.3 Checking by Send to a friend function";
        Log.info("TestProductColorFilter - " + testCaseName);

        //TO DO

    }

    @Test(priority = 3)
    //Assignment 3: Details View Mode - Test case II.5: Checking by Data Sheet, More Info and Reviews information
    public void verifyDataSheetAndMoreInfoAndReviewsInformation() {
        String testCaseName = "TEST CASE  II.5 Checking by Data Sheet, More Info and Reviews information";
        Log.info("TestProductDetailsView - " + testCaseName);

        //TO DO

    }

    @Test(priority = 4)
    //Assignment 3: Details View Mode - Test case II.4: Checking Breadcrumb navigation for the categories
    public void verifyBreadcrumbFunctions() {
        String testCaseName = "TEST CASE  II.4 Checking Breadcrumb navigation for the categories";
        Log.info("TestBreadcrumb - " + testCaseName);

        //TO DO

    }

}
