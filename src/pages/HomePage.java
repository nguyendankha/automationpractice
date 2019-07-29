package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utilities.AssertCollection;
import utilities.JSWaiter;
import utilities.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by KYZU
 * Date: 9/4/2018
 * Time: 12:46 PM
 **/
public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    //public static String BASE_URL = "http://qa-practice.hn.smartosc.com";
    public static String BASE_URL = "http://automationpractice.com/index.php";
    String itemLink1 = "";
    String itemLink2 = "";
    //*********Web Elements*********

    private static By HOME_SLIDER = By.cssSelector("div#homepage-slider");
    private static By HOME_SLIDER_LIST = By.cssSelector("div#homepage-slider ul >li:nth-of-type(1)");
    private static By HOME_SLIDER_LINK = By.cssSelector("div#homepage-slider ul >li:nth-of-type(1) a");
    private static By BTN_PREVIOUS = By.cssSelector("a.bx-prev");
    private static By BTN_NEXT = By.cssSelector("a.bx-next");
    private static By TOP_BANNER_BLOCK = By.cssSelector("div.banner");
    private static By TOP_BANNERS = By.cssSelector("");

    private static By HOME_PAGE_TABS = By.cssSelector("ul#home-page-tabs");
    private static By TAB_NEW_ARRIVALS = By.cssSelector("");
    private static By TAB_POPULAR = By.cssSelector("ul#home-page-tabs a.homefeatured");
    private static By TAB_SPECIALS = By.cssSelector("");
    private static By TAB_BEST_SELLER = By.cssSelector("ul#home-page-tabs a.blockbestsellers");

    private static By NEW_ARRIVALS_BLOCK = By.cssSelector("");
    private static By POPULAR_BLOCK = By.cssSelector("div.tab-content > ul#homefeatured");
    private static By SPECIALS_BLOCK = By.cssSelector("");
    private static By BEST_SELLER_BLOCK = By.cssSelector("div.tab-content > ul#blockbestsellers");

    private static By NEW_ARRIVALS_PRODUCT = By.cssSelector("");
    private static By POPULAR_PRODUCT = By.cssSelector(".tab-content ul.product_list.homefeatured > li:nth-of-type(1)");
    private static By SPECIALS_PRODUCT = By.cssSelector("");
    private static By BEST_SELLER_PRODUCT = By.cssSelector(".tab-content ul.product_list.blockbestsellers > li:nth-of-type(1)");

    private static By BTN_QUICK_VIEW = By.cssSelector(".tab-content ul.product_list.active > li:nth-of-type(1) a.quick-view span");
    private static By QUICK_VIEW_IFRAME = By.cssSelector("#product");
    private static By PRODUCT_IMG = By.cssSelector(".tab-content ul.product_list.homefeatured > li:nth-of-type(1) img");
    private static By PRODUCT_NAME = By.cssSelector(".tab-content ul.product_list.homefeatured > li:nth-of-type(1) a.product-name");
    private static By PRODUCT_PRICE = By.cssSelector(".tab-content ul.product_list.homefeatured > li:nth-of-type(1) .right-block .price");
    private static By PRODUCT_PRICE_PERCENT_REDUCTION = By.cssSelector(".tab-content ul.product_list.homefeatured > li:nth-of-type(7) .right-block .price-percent-reduction");
    private static By PRODUCT_OLD_PRICE = By.cssSelector(".tab-content ul.product_list.homefeatured > li:nth-of-type(7) .right-block .old-price");
    private static By MOUSE_OVER_PRICE  = By.cssSelector("");
    private static By MOUSE_OVER_PRICE_PERCENT_REDUCTION = By.cssSelector("");
    private static By MOUSE_OVER_OLD_PRICE = By.cssSelector("");
    private static By BTN_ADD_TO_CART = By.cssSelector(".tab-content ul.product_list.homefeatured > li:nth-of-type(7) a[title='Add to cart']");
    private static By BTN_MORE = By.cssSelector(".tab-content ul.product_list.homefeatured > li:nth-of-type(7) a[title='View']");

    private static By CONTENT_HOME_BLOCK = By.cssSelector("#htmlcontent_home");
    private static By CONTENT_HOME_ITEM = By.cssSelector("#htmlcontent_home ul > li:nth-of-type(1)");
    private static By FACEBOOK_BLOCK = By.cssSelector("#facebook_block");
    private static By CMSINFO_BLOCK = By.cssSelector("#cmsinfo_block");
    private static By EDITORIAL_BLOCK = By.cssSelector("#editorial_block_center");

    public void navigateToHomePage(){
        navigateToURL(HomePage.BASE_URL);
    }

    public void isOnHomePage() {
        waiter.waitForPageLoaded();
        Log.debug("HomePageLog - Verify if user is on home page.");
        
        //TO DO

    }

    public int countNumberOfProductDisplay(){
        return countElementDisplayed(POPULAR_PRODUCT);
    }

    //find locator of a product
    public String findLocatorOfProduct(int num) {
        String s = null;
        return s;
    }

    //find locator for a subButton
    public String findLocatorOfSubButton(int num){
        String s = null;
        return s;
    }


    public void moveMouseOverProduct(String locator){

        //TO DO

    }

    public void ClickOnMoreButton(String locator){

    }

    public void selectMoreButtonOnEachProduct(){
    }

    public void clickHomeIcon(){
    }

    public void clickHomePageSlider(){
    }

    public void clickMoreButton(WebElement product) {

        //TO DO

    }

    public void clickOnQuickView(WebElement product){
    }

    public void checkInformationInQuickViewMode(WebElement product){
    }

    public String getProductName(WebElement product){
        WebElement productName = product.findElement(PRODUCT_NAME);
        String name = productName.getText();
        return name;
    }

    public String getProductPrice(WebElement product){
        WebElement productPrice = product.findElement(PRODUCT_PRICE);
        String price = productPrice.getText();
        return price;
    }

    public String getOldPriceProduct(WebElement product){
        WebElement oldPriceProduct = product.findElement(PRODUCT_OLD_PRICE);
        String oldPrice = oldPriceProduct.getText();
        return oldPrice;
    }

    public String getPercentReduceProduct(WebElement product){
        WebElement percentReduceProduct = product.findElement(PRODUCT_PRICE_PERCENT_REDUCTION);
        String percent = percentReduceProduct.getText();
        return percent;
    }

    public String getMouseOverPrice(WebElement product){
        WebElement productPrice = product.findElement(MOUSE_OVER_PRICE);
        String price = productPrice.getText();
        return price;
    }


    public List getWebElementList(){
        List list = null;
        return list;
    }

    public void switchToFrame(){
        driver.switchTo().defaultContent();
    }

    public boolean isPriceCorrectWhenHaveRedution(String price, String percentReduce, String oldPrice){
        boolean b = true;
        return b;
    }

    public void isCarouselImageDisplayed(){

        //TO DO

    }

    public void isCarouselAutoSlided(){
        Log.debug("Verify if Home page carousel is auto slided");
        try {

            //TO DO

        }
        catch (Exception ex){
            System.out.println(ex);
        }
        Log.debug("Home page carousel is auto slided");
    }

    public void clickNextSlideButton(){

        //TO DO

    }

    public void clickPrevSlideButton(){

        //TO DO

    }

    public String getCurrentDisplayedSlide(){
        String itemLink = "";
        try {
            List<WebElement> listSlide = driver.findElements(HOME_SLIDER_LINK);
            //Hover to stop the auto slider
            moveMouseOverProduct(HOME_SLIDER);
            for (WebElement i1 : listSlide) {
                if (i1.isDisplayed()) {
                    itemLink = i1.getAttribute("title");
                    break;
                }
            }
            return itemLink;
        }catch (Exception e){
            throw e;
        }
    }

    public void isNextSlideDisplayed(){
        Log.debug("HomePageLog - Verify if clicking on 'Next slide' works correctly");

        //TO DO

    }

    public void isPreviousSlideDisplayed(){
        Log.debug("HomePageLog - Verify if clicking on 'Previous slide' works correctly");

        List<WebElement> listSlide = driver.findElements(HOME_SLIDER_LINK);
        String item1 = "";
        String item2 = "";
        List<String> listSliderBefore = new ArrayList<String>();
        List<String> listSliderAfter = new ArrayList<String>();
        try {

            //TO DO

        }
        catch (Exception ex){
            System.out.println(ex);
        }
        Log.debug("HomePageLog - Clicking on 'Previous slide' works correctly");
    }

    public WebElement selectRandomProduct(){
        Random random = new Random();
        List<WebElement> products = driver.findElements(POPULAR_PRODUCT);
        int index = random.nextInt(products.size());
        return products.get(index);
    }

}
