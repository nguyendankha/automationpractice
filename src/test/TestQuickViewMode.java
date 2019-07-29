package test;

import cucumber.api.java.Before;
import objects.Customer;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.JSWaiter;
import utilities.Log;

public class TestQuickViewMode extends TestBase {
    Customer customer;

    public void registerAccount(Customer user){
        try {
            //Create a new customer object
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
    public void accessToQuickViewMode(){
        //Access to Home page
        webApp.getHomePage().navigateToHomePage();
        webApp.getHomePage().isOnHomePage();

        webApp.getProductQuickView().clickQuickViewButton();
        webApp.getProductQuickView().switchToCurrentFrame();
        webApp.getProductQuickView().isOnProductQuickViewPopup();
    }

    @Test(priority = 1)
    //Assignment 3: Quick View Mode - Test case I.1: Checking by Product image
    public void verifyProductImagesDisplayed() {
        String testCaseName = "TEST CASE  I.1: Checking by Product image";
        Log.info("TestProductImage - " + testCaseName);

        //TO DO

    }

    @Test(priority = 2)
    //Assignment 3: Quick View Mode - Test case I.2: Checking by prices of Product
    public void verifyProductPrices() {
        String testCaseName = "TEST CASE  I.2: Checking by Product price";
        Log.info("TestProductPrice - " + testCaseName);

        //TO DO

    }

    @Test(priority = 3)
    //Assignment 3: Quick View Mode - Test case I.3: Inputting amount of Quantity
    public void verifyProductQuantity() {
        String testCaseName = "TEST CASE  I.3: Inputting amount of Quantity";
        Log.info("TestProductQuantity - " + testCaseName);

        //TO DO

    }

    @Test(priority = 4)
    //Assignment 3: Quick View Mode - Test case I.5: Verify Color filter
    public void verifyProductColorFilter() {
        String testCaseName = "TEST CASE  I.5: Verify Color filter";
        Log.info("TestProductColorFilter - " + testCaseName);

        //TO DO

    }

    @Test(priority = 5)
    //Assignment 3: Quick View Mode - Test case I.4: Inputting amount of Quantity
    public void verifyProductSize() {
        String testCaseName = "TEST CASE  I.4: Selecting a specific Size (S, M, L)";
        Log.info("TestProductSize - " + testCaseName);

        //TO DO

    }

    @Test(priority = 6)
    //Assignment 3: Quick View Mode - Test case I.6: Verify Add to WishList function
    public void verifyAddToWishListFunction() throws Exception {
        String testCaseName = "TEST CASE  I.6: Verify Add to WishList function";
        Log.info("TestAddToWishList - " + testCaseName);

        //TO DO

    }

}
