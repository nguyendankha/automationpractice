package test;

import objects.Customer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Log;

public class TestShoppingCartPage extends TestBase {
    Customer customer;

    public void registerAccount(Customer customer) throws Exception {

        //Checkpoint: Check if user is on Create account page
        webApp.getCreateAccountPage().isOnCreateAccountPage();

        //Fill in Create Account form with customer data & submit
        webApp.getCreateAccountPage().writeCreateAccountFormFromExistingCustomer(customer);
        webApp.getCreateAccountPage().clickRegisterButton();
    }

    public void checkUserAccountLoginStatus() throws Exception {

        //Check if user is logged in
        if(webApp.getsShoppingCart().isSummaryStepDisplayed()) {
            webApp.getsShoppingCart().clickCheckoutButtonSummaryStep();
        }
            if (!webApp.getHeaderContainer().isUserLoggedIn()) {
                //Checkpoint: Click Proceed to checkout button at Summary step and verify the Login step is displayed
                webApp.getsShoppingCart().isOnSignInStep();
                //Fill the random email to Sign up form and submit
                customer = new Customer();
                customer.createCustomerWithRandomizedInformation();
                webApp.getsShoppingCart().inputAEmailToCreateForm(customer.getEmail());
                webApp.getsShoppingCart().clickCreateAnAccountButton();
                registerAccount(customer);
            }
            waiter.waitForPageLoaded();
    }

    @BeforeTest
    public void addProductsToCartAndAccessToShoppingCartPage(){
        //Navigate to Homepage if not in Homepage
        webApp.getHomePage().navigateToHomePage();
        webApp.getHomePage().isOnHomePage();
        //Add many products to cart
        webApp.getAddToCart().addRandomProductsToCartFromHomePage();
        //Navigate to Shopping cart page
        webApp.getHeaderContainer().clickShoppingCartDropDownList();
        webApp.getsShoppingCart().isOnShoppingCart();
    }

    @Test(priority = 1)
    //Assignment 6: Test Case 2, 4, 5
    public void verifyTheQuantityAndPriceInShoppingCart() {
        String testCaseName = "TEST CASE  2, 4, 5: Add many products to cart and count the total quantity in shopping cart, Verify the total quantity and total price updated when removing a/many shopping items, Verify total prices per shopping item, total products and total all these ones when increasing/decreasing quantity value.";
        Log.info("TestShoppingCartPage - " + testCaseName);

        //TO DO

    }

    @Test(priority = 2)
    //Assignment 6: Test Case 6, 7, 8, 9: Verify the function of Continue Shopping and Proceed to checkout button
    public void verifyTheFunctionOfContinueShoppingAndProceedToCheckoutButton() throws Exception {
        String testCaseName = "TEST CASE  6, 7, 8, 9: Verify the function of Continue Shopping and Proceed to checkout button, create new account, login and check by account information";
        Log.info("TestShoppingCartPage - " + testCaseName);

        //TO DO

    }

    @Test(priority = 3)
    //Assignment 6: Test Case 10, 11, 12, 13: verify Add New Address Button Is Displayed, update address, add comment and go to Shipping process
    public void verifyAddressProcessFunctions() throws Exception {
        String testCaseName = "TEST CASE  10, 11, 12, 13: verify Add New Address Button Is Displayed, update address, add comment and go to Shipping process";
        Log.info("TestShoppingCartPage - " + testCaseName);

        checkUserAccountLoginStatus();

        //TO DO

    }

    @Test(priority = 4)
    //Assignment 6: Test Case 14, 15, 16, 17: Verifying shipping prices which stored above case study, Checking by You must agree to the terms of service before continuing popup, Verifying billing address which stored above case study then clicking on Proceed to checkout button
    public void verifyShippingProcessFunctions() throws Exception {
        String testCaseName = "TEST CASE  14, 15, 16, 17: Verifying shipping prices which stored above case study, Checking by You must agree to the terms of service before continuing popup, Verifying billing address which stored above case study then clicking on Proceed to checkout button";
        Log.info("TestShoppingCartPage - " + testCaseName);

        checkUserAccountLoginStatus();

        //TO DO

    }

    @Test(priority = 5)
    //Assignment 6: Test Case 18, 19, 20, 21: Verify two payment methods is displayed, select any method any go back to payment selection, check function of order confirmation button, check order successful message at Order Confirmation page
    public void verifyPaymentProcessFunctions() throws Exception {
        String testCaseName = "TEST CASE 18, 19, 20, 21: Verify two payment methods is displayed, select any method any go back to payment selection page, verify function of order confirmation button, verify order successful message at Order Confirmation page";
        Log.info("TestShoppingCartPage - " + testCaseName);

        checkUserAccountLoginStatus();

        //TO DO

    }

    @Test(priority = 6)
    //Assignment 6: Test Case 1: Verify if text 'Your Shopping cart is empty' is displayed when clicking on empty Shopping cart button
    public void verifyMessageIsDisplayedWhenClickingEmptyShoppingCartButton() {
        String testCaseName = "TEST CASE  1: Verify if text 'Your Shopping cart is empty' is displayed when clicking on empty Shopping cart button";
        Log.info("TestShoppingCartPage - " + testCaseName);

        //TO DO

    }
}
