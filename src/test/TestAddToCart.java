package test;

import objects.Customer;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.JSWaiter;
import utilities.Log;
import org.testng.annotations.Test;
import utilities.TestData;

import java.math.BigDecimal;

public class TestAddToCart extends TestBase {


    public void accessToDetailsViewMode(){
        //Access to the Home page
        webApp.getHomePage().navigateToHomePage();
        webApp.getHomePage().isOnHomePage();

        //Select a product and click More button
        webApp.getProductDetailsView().clickViewDetailsProduct();
        webApp.getProductDetailsView().isOnProductDetailsPage();
    }

    public void addMoreItemsToCart(){
        //Close Add to cart popup if it display
        if(webApp.getAddToCart().isAddToCartPopupDisplay()){
            webApp.getAddToCart().clickContinueShopping();
        }
        JSWaiter.sleep(2000);
        //Click add to cart the same item
        webApp.getAddToCart().clickAddToCartFromProductDetails();
        webApp.getAddToCart().isOnAddToCart();
    }

    @BeforeTest
    public void accessToAddToCartPopup(){
        accessToDetailsViewMode();
        //Input the quantity, size and color
        webApp.getProductDetailsView().inputQuantity();
        webApp.getProductDetailsView().selectColor();
        webApp.getProductDetailsView().selectSize();
        //Click Add To Cart button
        webApp.getAddToCart().clickAddToCartFromProductDetails();
        webApp.getAddToCart().isOnAddToCart();
    }

    @Test(priority = 1)
    //Assignment 4: Add To Cart - Test case 1 and 2: Checking by amount of items which clicked on Add to cart
    public void verifyAmountAndPriceOfProductInAddToCartPopup() {
        String testCaseName = "TEST CASE  1, 2: Checking by amount and price of items which clicked on Add to cart";
        Log.info("TestAddToCart - " + testCaseName);

        //TO DO
    }

    @Test(priority = 2)
    //Assignment 4: Add To Cart - Test case 3, 4 and 5: Checking by confirmation message and total amount and price of items which clicked on Add to cart then click to close the popup
    public void verifyTotalAmountAndTotalPriceOfProductInAddToCartPopup() {
        String testCaseName = "TEST CASE 3, 4 and 5: Checking by confirmation message and total amount and price of items which clicked on Add to cart then click to close the popup";
        Log.info("TestAddToCart - " + testCaseName);

        //TO DO
    }

    @Test(priority = 3)
    //Assignment 4: Add To Cart - Test case 6 and 7: Verify the item count in the shopping cart should get incremented then click the Proceed to checkout button
    public void verifyTheItemCountInTheShoppingCartGetIncrementedIfAddSameProduct() {
        String testCaseName = "TEST CASE 6 and 7: Verify the item count in the shopping cart should get incremented";
        Log.info("TestAddToCart - " + testCaseName);

        //TO DO
    }

    @Test(priority = 4)
    //Assignment 4: Add To Cart - Test case 8 and 9: Verify the item count in the shopping cart dropdown list should get updated
    public void verifyTheItemCountInTheShoppingCartDropdownListShouldGetUpdated() {
        String testCaseName = "TEST CASE  8, 9: Verify the item count in the shopping cart dropdown list should get updated";
        Log.info("TestAddToCart - " + testCaseName);

        //TO DO

    }

    @Test(priority = 5)
    //Assignment 4: Add To Cart - Test case study 1 and 2: Removing any shopping items in View my shopping cart dropdown list at Home page then close and reopen the website
    public void verifyTheItemInCartDropdownUpdatedAndKeepChangesAfterCloseTheSite() {
        String testCaseName = "TEST CASE STUDY  1, 2: Verify The Item In Cart Dropdown Updated And Keep Changes After Reopen The Site";
        Log.info("TestAddToCart - " + testCaseName);

        //TO DO

    }
}