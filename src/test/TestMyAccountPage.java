package test;

import objects.Customer;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.MyAccountPage;
import utilities.Log;

import org.testng.annotations.Test;

public class TestMyAccountPage extends TestBase {
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

    public void addProductToCartAndCompleteTheOrder() {

        //Navigate to homepage
        webApp.getHeaderContainer().clickHomeIcon();
        webApp.getHomePage().isOnHomePage();
        //Add many products to cart
        webApp.getAddToCart().addRandomProductsToCartFromHomePage();
        //Navigate to Shopping cart page
        webApp.getHeaderContainer().clickShoppingCartDropDownList();
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

    public void checkAndNavigateToOrderHistoryPage(){
        //Navigate to Order History page
        if(!webApp.getCurrentURL().contains(MyAccountPage.getOrderHistoryUrl())){
            webApp.getMyAccountPage().clickOrderHistoryButton();
            webApp.getMyAccountPage().isOnOrderHistoryPage();
        }
    }

    public void checkAndNavigateToMyWishlistPage(){
        //Navigate to Order History page
        if(!webApp.getCurrentURL().contains(MyAccountPage.getMyWishlistUrl())){
            webApp.getMyAccountPage().clickMyWishlistButton();
            webApp.getMyAccountPage().isOnMyWishlistsPage();
        }
    }

    public void checkAndNavigateToMyAddressesPage(){
        //Navigate to My Addresses page
        if(!webApp.getCurrentURL().contains(MyAccountPage.getMyAddressesUrl())){
            webApp.getMyAccountPage().clickMyAddressesButton();
            webApp.getMyAccountPage().isOnMyAddressesPage();
        }
    }

    public void checkAndNavigateToMyPersonalInformationPage(){
        //Navigate to My Addresses page
        if(!webApp.getCurrentURL().contains(MyAccountPage.getMyPersonalInformationUrl())){
            webApp.getMyAccountPage().clickPersonalInformationButton();
            webApp.getMyAccountPage().isOnPersonalInformationPage();
        }
    }

    public void checkAndCreateOrderIfNotExist(){
        checkAndNavigateToOrderHistoryPage();
        if(webApp.getMyAccountPage().isOrderListEmpty()) {
            //Add product to cart and go to checkout page
            addProductToCartAndCompleteTheOrder();

            //Go to My Account page
            webApp.getHeaderContainer().clickUserAccountButton();
            webApp.getMyAccountPage().isOnMyAccountPage();
        }
    }

    @BeforeTest
    public void createAccountAndLogin() throws Exception {
        //Navigate to Homepage if not in Homepage
        webApp.getHomePage().navigateToHomePage();
        webApp.getHomePage().isOnHomePage();

        //Click Sign in button to navigate to Log In page
        webApp.getHeaderContainer().clickSignInButton();

        //Check Log In page is displayed
        webApp.getLoginPage().isOnLoginPage();

        customer = new Customer();
        registerAccount(customer);

    }

    @Test(priority = 1)
    public void verifyTotalOfOrderReferenceInOrderHistory(){
        String testCaseName = "TEST CASE  1: Verify total of order reference items into Order History page";
        Log.info("TestMyAccountPage - " + testCaseName);
        checkAndCreateOrderIfNotExist();
        checkAndNavigateToOrderHistoryPage();

        //TO DO

    }

    @Test(priority = 2)
    public void verifyOrderReferenceDetailsFunctions(){
        String testCaseName = "TEST CASE  2: Checking by order reference details when clicking on any this one or Details button";
        Log.info("TestMyAccountPage - " + testCaseName);
        checkAndCreateOrderIfNotExist();
        checkAndNavigateToOrderHistoryPage();

        //TO DO

    }

    @Test(priority = 3)
    public void verifySortFunctionsOfDateAndTotalPriceAndStatus(){
        String testCaseName = "TEST CASE  3: Verify Sort functions of Date, Total price, Status";
        Log.info("TestMyAccountPage - " + testCaseName);
        checkAndCreateOrderIfNotExist();
        //Create more order and go to Order History page
        addProductToCartAndCompleteTheOrder();

        //TO DO

    }

    @Test(priority = 4)
    public void verifyFunctionOfReorderButtonAtTheLastColumn(){
        String testCaseName = "TEST CASE  4: Verify function of Reorder button at the last column at order reference sequentially";
        Log.info("TestMyAccountPage - " + testCaseName);
        checkAndCreateOrderIfNotExist();
        checkAndNavigateToOrderHistoryPage();

        //TO DO

    }

    @Test(priority = 5)
    public void verifyFunctionOfDownloadPDFInvoiceAndBackToMyAccountAndHomeButton(){
        String testCaseName = "TEST CASE  5, 6, 7: Verify function of Download PDF Invoice button, clicking on Back to your account to re-direct to My account page then click on Home to re-direct to Home page";
        Log.info("TestMyAccountPage - " + testCaseName);
        //checkAndCreateOrderIfNotExist();
        checkAndNavigateToOrderHistoryPage();

        //TO DO

    }

    @Test(priority = 6)
    public void creatingANewWishlistAndAddProductsToWishlist(){
        String testCaseName = "TEST CASE II:  1, 2: Creating a new Wishlist into My wishlists page, add products to this wishlist";
        Log.info("TestMyAccountPage - " + testCaseName);

        checkAndNavigateToMyWishlistPage();

        //TO DO

    }

    @Test(priority = 7)
    public void verifyFunctionsOfAddAndUpdateAndDeleteAddress(){
        String testCaseName = "TEST CASE III:  1, 2, 3: Update address, delete this address, then creating a new address";
        Log.info("TestMyAccountPage - " + testCaseName);

        checkAndNavigateToMyAddressesPage();

        //TO DO

    }

    @Test(priority = 8)
    public void verifyFunctionsOfUpdatingPersonalInformation() throws Exception {
        String testCaseName = "TEST CASE IV:  1, 2: Update personal information and change password";
        Log.info("TestMyAccountPage - " + testCaseName);

        checkAndNavigateToMyPersonalInformationPage();

        //TO DO

    }
}
