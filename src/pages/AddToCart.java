package pages;

import objects.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.xml.sax.Locator;
import utilities.AssertCollection;
import utilities.JSWaiter;
import utilities.Log;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddToCart extends BasePage{

    public AddToCart(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    private BigDecimal singlePrice = new BigDecimal(0);
    private BigDecimal singleQuantity = new BigDecimal(0);
    private BigDecimal totalPrice = new BigDecimal(0);
    public static BigDecimal totalQuantity = new BigDecimal(0);

    public static ArrayList<Product> inCartProducts = new ArrayList<>();

    //*********Web Elements*********
    private static By BTN_ADD_TO_CART = By.cssSelector("button.added");
    private static By BTN_ADD_TO_CART_HOMEPAGE = By.cssSelector("");
    private static By ADD_TO_CART_POPUP = By.cssSelector("div#layer_cart");
    private static By PRODUCT_BLOCK = By.cssSelector(".layer_cart_product_info");
    private static By CART_INFO_BLOCK = By.cssSelector(".layer_cart_cart");
    private static By BTN_CONTINUE_SHOPPING = By.cssSelector("span.continue span");
    private static By BTN_CHECKOUT = By.cssSelector("a[title='Proceed to checkout']");
    private static By BTN_CLOSE = By.cssSelector("span.cross");
    private static By LBL_ITEMS_COUNT = By.cssSelector("span span.ajax_cart_quantity");

    //******Page Methods******
    public void isOnAddToCart(){
        Log.debug("Verify if user is on Add to Cart popup");

        //TO DO

    }

    public void clickContinueShopping(){

        //TO DO

    }

    public void clickProceedToCheckout(){
        click(BTN_CHECKOUT);
    }

    public void clickAddToCartFromProductDetails(){
        try {

            //TO DO
        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void clickAddToCartFromHomePage(WebElement product){
        try {

            //TO DO
        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void addRandomProductsToCartFromHomePage(){
        By productLocator = By.cssSelector("ul#homefeatured li.ajax_block_product");
        try {

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void isTotalPriceDisplayedCorrectly(){
        Log.debug("Add to Cart popup - Verify if Total Price is displayed correctly");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
        Log.debug("Add to Cart popup - Total Price is displayed correctly");
    }

    public void isSinglePriceDisplayedCorrectly(){

        //TO DO

    }

    public void isTotalQuantityDisplayedCorrectly(){
        Log.debug("Add to Cart popup - Verify if Total Quantity of items is displayed correctly");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
        Log.debug("Add to Cart popup - Total Quantity of items is displayed correctly");
    }

    public void isSingleQuantityDisplayedCorrectly(){

        //TO DO

    }

    public void isSuccessfulMessageDisplayed(){

        //TO DO

    }

    public boolean isAddToCartPopupDisplay(){

        //TO DO
        return true;
    }

    public void isTheItemCountOnHeaderUpdated(){

        //TO DO

    }

}
