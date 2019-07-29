package pages;

import net.bytebuddy.implementation.bytecode.Throw;
import objects.Product;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.AssertCollection;
import utilities.JSWaiter;
import utilities.Log;


import java.math.BigDecimal;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ProductQuickView extends BasePage {

    public ProductQuickView (WebDriver driver) {
        super(driver);
    }
    private String productPrice = "";
    private String productOldPrice = "";
    private String productPercentReduce = "";
    private String productImage = "";
    int quantity = 0;
    String size = "";
    String color = "";

    //*********Page Variables*********
    public static String BASE_URL = "http://automationpractice.com/index.php";
    private String[] sizeOptions = new String[]{"S", "M", "L"};
    //*********Web Elements*********
    private static By QUICK_VIEW_IFRAME = By.cssSelector("#product");
    private static By IMAGE_BLOCK = By.cssSelector("#image-block");
    private static By VIEWS_BLOCK = By.cssSelector("#views_block");
    private static By VIEWS_IMAGES= By.cssSelector("#thumbs_list ul > li:nth-of-type(1)");
    private static By BTN_RESET_IMAGES = By.cssSelector("");
    private static By BTN_SCROLL_LEFT = By.cssSelector("#view_scroll_left");
    private static By BTN_SCROLL_RIGHT = By.cssSelector("#view_scroll_right");
    private static By ADD_TO_WISHLIST_MESSAGE = By.cssSelector(".fancybox-error");
    private static By CENTER_INFORMATION = By.cssSelector(".pb-center-column");
    private static By PRODUCT_INFORMATION = By.cssSelector("#product_reference");
    private static By PRODUCT_PRICE = By.cssSelector("#our_price_display");
    private static By PRODUCT_PRICE_PERCENT_REDUCTION = By.cssSelector("#reduction_percent_display");
    private static By PRODUCT_OLD_PRICE = By.cssSelector("#old_price_display");
    private static By TXT_QUANTITY = By.cssSelector("#quantity_wanted");
    private static By BTN_QUANTITY_DOWN = By.cssSelector("a.product_quantity_down");
    private static By BTN_QUANTITY_UP = By.cssSelector("a.product_quantity_up");
    private static By SELECT_SIZE = By.cssSelector("#group_1");
    private static By SIZE_OPTIONS = By.cssSelector("#group_1 > option");
    private static By COLOR_OPTIONS = By.cssSelector("#color_to_pick_list > li:nth-child(1)");
    private static By BTN_ADD_TO_CART = By.cssSelector("#add_to_cart button");
    private static By BTN_WISHLIST = By.cssSelector("#wishlist_button");
    private static By BTN_CLOSE_QUICK_VIEW = By.cssSelector("a[title='Close']");
    private static By REQUEST_TO_LOGIN_MESSAGE = By.cssSelector("");
    private static By BTN_CLOSE_REQUEST_LOGIN = By.cssSelector("");
    private static By BTN_RESET_IMAGE = By.cssSelector("");
    //****** Page Methods ******
    public void isOnProductQuickViewPopup(){
        Log.debug("QuickViewMode - Verify if Quick View popup display.");

        //TO DO

    }

    public void switchToCurrentFrame(){

        //TO DO

    }

    public void clickQuickViewButton(){
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void isProductQuickViewSelectedCorrectly(){
        Log.debug("Product Details View page - Verify if user views the correct product");

        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
        Log.debug("Product Details View page - User views the correct product");
    }

    public void inputQuantity(){

        //TO DO

    }

    public int getValueInQuantityField(){

        //TO DO
        return 0;
    }

    public void increaseQuantity(){

        //TO DO

    }

    public void isQuantityUpWorkCorrectly(){
        Log.debug("Verify if the plus quantity button work correctly.");

        //TO DO

    }

    public void decreaseQuantity(){

        //TO DO

    }

    public void isQuantityDownWorkCorrectly(){
        Log.debug("Verify if the minus quantity button work correctly.");

        //TO DO

    }

    public void selectSize(){

        //TO DO

    }

    public void selectColor(){

        //TO DO

    }

    public void isColorFilterWorkCorrectly(){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public int getAmountOfProductImagesDisplayed(){

        //TO DO
        return 0;
    }

    public void clickAddToWishlist() {

        //TO DO

    }

    public boolean isUserRequestedToLogin(){
        try {

            //TO DO
            return true;
        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void clickCloseRequestLoginMessage(){

        //TO DO

    }

    public void clickCloseQuickViewPopup(){

        //TO DO

    }

    public void isProductAddedToWishList(){
        Log.debug("Product Quick View popup - Verify if user adds a product to Wishlist successfully");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void isProductImagesDisplayedCorrectly(){
        Log.debug("Product Quick View popup - Verify if the product images display correctly");

        //TO DO

    }

    public void isPriceDisplayCorrectly(){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public String getProductPrice(){

        //TO DO
        return null;
    }

    public String getOldPriceProduct(){

        //TO DO
        return null;
    }

    public String getPercentReduceProduct(){

        //TO DO
        return null;
    }

    public boolean isPriceReductionExisting(WebElement product) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            //TO DO
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }

    }

    public void waitUntilDialogClosed() {
        try {

            //TO DO

        } catch (NoSuchElementException ex) {
            System.out.print(ex);
            return;
        } finally {
            driver.manage().timeouts().implicitlyWait(serverTimeout, TimeUnit.SECONDS);
        }
    }
}
