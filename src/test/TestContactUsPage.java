package test;

import objects.Customer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Log;

public class TestContactUsPage extends TestBase{
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

    public void accessToDetailsViewMode(){
        //Access to the Home page
        webApp.getHomePage().navigateToHomePage();
        webApp.getHomePage().isOnHomePage();

        //Select a product and click More button
        webApp.getProductDetailsView().clickViewDetailsProduct();
        webApp.getProductDetailsView().isOnProductDetailsPage();
    }

    public void addProductToCartAndCompleteTheOrder() {
        accessToDetailsViewMode();
        //Input the quantity, size and color
        webApp.getProductDetailsView().inputQuantity();
        webApp.getProductDetailsView().selectColor();
        webApp.getProductDetailsView().selectSize();
        //Click Add To Cart button and proceed to checkout
        webApp.getAddToCart().clickAddToCartFromProductDetails();
        webApp.getAddToCart().isOnAddToCart();
        webApp.getAddToCart().clickProceedToCheckout();
        webApp.getsShoppingCart().isOnShoppingCart();
        //Go to step 3 - Address
        webApp.getsShoppingCart().clickCheckoutButtonSummaryStep();
        webApp.getsShoppingCart().isOnAddressStep();
        //Go to step 4 - Shipping
        webApp.getsShoppingCart().clickCheckoutButtonAddressStep();
        webApp.getsShoppingCart().isOnShippingStep();
        webApp.getsShoppingCart().checkOptionAgreeTerm();
        //Go to step 5 - Confirm order
        webApp.getsShoppingCart().clickCheckoutButtonShippingStep();
        webApp.getsShoppingCart().isOnPaymentStep();
        //Select a payment method
        webApp.getsShoppingCart().selectPaymentMethod();
        webApp.getsShoppingCart().isOnConfirmOrderStep();
        //Click confirm order button
        webApp.getsShoppingCart().clickConfirmOrderButton();
        webApp.getsShoppingCart().isOnOrderCompleteStep();

    }

    @BeforeTest
    public void LoginAndCreateOrderThenGoToContactUsPage() throws Exception {
        //Create new account
        webApp.navigateToURL(HomePage.BASE_URL);

        //Check Header Info is displayed
        webApp.getHeaderContainer().isHeaderContainerDisplayed();

        //Click Sign in button to navigate to Log In page
        webApp.getHeaderContainer().clickSignInButton();

        //Check Log In page is displayed
        webApp.getLoginPage().isOnLoginPage();

        customer = new Customer();
        registerAccount(customer);

        //Add product to cart and go to checkout page
        addProductToCartAndCompleteTheOrder();

        //Go to Contact Us page
        webApp.getHeaderContainer().clickContactUsButton();
        webApp.getContactUsPage().isOnContactUsPage();
    }

    @Test(priority = 3)
    //Assignment 5: Details View Mode - Test case 1, 2, 6, 7: Selecting a Subject Heading value: Customer service/Webmaster, input email and message then click Send button
    public void selectASubjectHeadingAndEnterEmailAddressAndInputTheMessageThenClickSend() {
        String testCaseName = "Test case 1, 2, 6: Selecting a Subject Heading value: Customer service/Webmaster, input email and message then click Send button";
        Log.info("TestContactUsPage - " + testCaseName);

        //TO DO
    }

    @Test(priority = 1)
    //Assignment 5: Details View Mode - Test case 3, 4: Verify Order reference dropdown list is displayed expected items and select any order reference and its product
    public void VerifyOrderReferenceDropdownListIsDisplayed() {
        String testCaseName = "Test case 3, 4: Verify Order reference dropdown list is displayed expected items and select any order reference and its product";
        Log.info("TestContactUsPage - " + testCaseName);

        //TO DO
    }

    @Test(priority = 2)
    //Assignment 5: Details View Mode - Test case 5: Attaching a sample file (e.g. Production information pdf file)
    public void attachSampleFile() {
        String testCaseName = "Test case 5: Attaching a sample file (e.g. Production information pdf file)";
        Log.info("TestContactUsPage - " + testCaseName);

        //TO DO

    }

    @Test(priority = 4, dependsOnMethods = "selectASubjectHeadingAndEnterEmailAddressAndInputTheMessageThenClickSend")
    //Assignment 5: Details View Mode - Test case 8: Clicking on Home button to re-directing Home page of testing site
    public void verifyHomeButtonFunction() {
        String testCaseName = "Test case 8: Clicking on Home button to re-directing Home page of testing site";
        Log.info("TestContactUsPage - " + testCaseName);

        //TO DO

    }
}
