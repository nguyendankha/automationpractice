package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.AssertCollection;
import utilities.JSWaiter;
import utilities.Log;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ProductDetailsView extends BasePage {

    public ProductDetailsView(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    private static String linkTitle = null;
    private String productPrice = "";
    private String productOldPrice = "";
    private String productPercentReduce = "";

    //*********Web Elements*********
    private static By IMAGE_BLOCK = By.cssSelector("#image-block");
    private static By VIEWS_BLOCK = By.cssSelector("#views_block");
    private static By VIEWS_IMAGES = By.cssSelector("#thumbs_list li:nth-of-type(1)");
    private static By BTN_SCROLL_LEFT = By.cssSelector("a#view_scroll_left");
    private static By BTN_SCROLL_RIGHT = By.cssSelector("");
    private static By BUY_BLOCK = By.cssSelector("");
    private static By PRODUCT_DESC_BLOCK = By.cssSelector("");
    private static By PRODUCT_PRICE = By.cssSelector("#our_price_display");
    private static By PRODUCT_PRICE_PERCENT_REDUCTION = By.cssSelector("#reduction_percent_display");
    private static By PRODUCT_OLD_PRICE = By.cssSelector("#old_price_display");
    private static By TXT_QUANTITY = By.cssSelector("a#view_scroll_right");
    private static By BTN_QUANTITY_DOWN = By.cssSelector("a.product_quantity_down");
    private static By BTN_QUANTITY_UP = By.cssSelector("a.product_quantity_up");
    private static By SELECT_SIZE = By.cssSelector("select#group_1");
    private static By SIZE_OPTIONS = By.cssSelector("#group_1 > option:nth-child(1)");
    private static By COLOR_OPTIONS = By.cssSelector("#color_to_pick_list > li:nth-child(1) a");
    private static By BTN_ADD_TO_CART = By.cssSelector("#add_to_cart > button");
    private static By BTN_WISHLIST = By.cssSelector("#wishlist_button");

    private static By SOCIAL_BLOCK = By.cssSelector(".socialsharing_product");
    private static By BTN_TWITTER = By.cssSelector(".btn-twitter");
    private static By BTN_FACEBOOK = By.cssSelector(".btn-facebook");
    private static By BTN_GOOGLEPLUS = By.cssSelector(".btn-google-plus");
    private static By BTN_PINTEREST = By.cssSelector(".btn-pinterest");

    private static By BTN_SEND_TO_FRIEND = By.cssSelector("#send_friend_button");
    private static By SEND_TO_FRIEND_POPUP = By.cssSelector("div#send_friend_form");
    private static By TXT_FRIEND_NAME = By.cssSelector("#friend_name");
    private static By TXT_FRIEND_EMAIL = By.cssSelector("#friend_email");
    private static By BTN_SEND_MAIL = By.cssSelector("#sendEmail");
    private static By BTN_CANCEL = By.cssSelector(".submit a.closefb");
    private static By BTN_CLOSE_SEND_MAIL_POPUP = By.cssSelector("a[title='Close']");
    private static By POPUP_SUCCESSFUL_MESSAGE = By.cssSelector(".fancybox-skin");
    private static By BTN_OK = By.cssSelector("input[value='OK']");

    private static By BTN_ICON_PRINT = By.cssSelector("");
    private static By BTN_PRINT = By.cssSelector(".print > a");
    private static By IFRAME_PRINT_VIEWER = By.cssSelector("#content");
    private static By BTN_CANCEL_PRINT = By.cssSelector("");

    private static By DATA_SHEET = By.cssSelector("table.table-data-sheet");
    private static By MORE_INFO = By.cssSelector(".page-product-box div.rte");
    private static By REVIEWS = By.cssSelector("div#product_comments_block_tab");
    private static By BTN_WRITE_A_REVIEW = By.cssSelector("");
    private static By BTN_BE_THE_FIRST_TO_WRITE_REVIEW = By.cssSelector("a#new_comment_tab_btn");
    private static By WRITE_REVIEWS_POPUP = By.cssSelector("#new_comment_form");
    private static By TXT_COMMENT_TITLE = By.cssSelector("#comment_title");
    private static By TXT_COMMENT_CONTENT = By.cssSelector("#content");
    private static By BTN_SEND_NEW_MESSAGE = By.cssSelector("#submitNewMessage");
    private static By BTN_VIEW_LARGER = By.cssSelector("span.span_link");
    private static By LARGE_IMG_POPUP = By.cssSelector(".fancybox-skin");
    private static By BTN_CLOSE_LARGE_IMG_POPUP = By.cssSelector("a[title='Close']");
    private static By BTN_NEXT_LARGE_IMG_POPUP = By.cssSelector("a[title='Next']");
    private static By BTN_PREVIOUS_LARGE_IMG_POPUP = By.cssSelector("a[title='Previous']");
    private static By BTN_CLOSE_REQUEST_LOGIN = By.cssSelector("");
    private static By BTN_RESET_IMAGE = By.cssSelector("");

    //****** Page Methods ******
    public void isOnProductDetailsPage(){
        Log.debug("ProductDetailsViewLog - Verify if user is on product details page.");

        //TO DO

    }

    public void clickViewDetailsProduct(){
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void isProductDetailsSelectedCorrectly(){
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
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void selectColor(){
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void isColorFilterWorkCorrectly(){
        Log.debug("Product Details View popup - Verify if the color filter work correctly.");

        //TO DO

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

    public void isProductAddedToWishList(){
        Log.debug("Product Quick View popup - Verify if user adds a product to Wishlist successfully");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void isProductAttributesSelected(){
        Log.debug("Product Details View page - Verify if user select product attributes (size, color) successfully");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
        Log.debug("Product Details View page - Product attributes (size, color) are selected correctly");
    }

    public void clickPrint(){

        //TO DO

    }

    public void clickSendToFriend() {
        click(BTN_SEND_TO_FRIEND);
    }

    public void isPrintViewerDisplayed(){
        Log.debug("Product Details View page - Verify if user can click on the Print function to open Print viewer");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
        Log.debug("Product Details View page - Print viewer is displayed correctly");
    }

    public void isSendToFriendPopupDisplayed(){
        Log.debug("Product Details View page - Verify if Send to friend popup is displayed");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void inputFriendNameAndEmail(){

        //TO DO

    }

    public void clickSubmitSendToFriend(){

        //TO DO

    }

    public void isSendToFriendSuccessfulMessageDisplayed(){
        Log.debug("Product Details View page - Verify if Send to friend successful message is displayed");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }

    }

    public void closeSendFriendSuccessfulMessage(){

        //TO DO

    }

    public void closeAddWishListSuccessfulMessage(){

        //TO DO

    }

    public void clickAddToCart(){
        click(BTN_ADD_TO_CART);
    }

    public void clickCancelPrint(){
        click(BTN_CANCEL_PRINT);
    }

    public void isDataSheetDisplayed() {
        Log.debug("Verify if Data sheet section is displayed on Product Details View page");

        //TO DO

    }

    public void isMoreInfoDisplayed() {
        Log.debug("Verify if Data sheet section is displayed on Product Details View page");

        //TO DO

    }

    public void isReviewsDisplayed() {
        Log.debug("Verify if Data sheet section is displayed on Product Details View page");

        //TO DO

    }

    public void clickReview(){
        click(BTN_WRITE_A_REVIEW);
    }

    public void isReviewPopupDisplayed(){
        Log.debug("Product Details View page - Verify if Write a Review popup is displayed");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
        Log.debug("Product Details View page - Write a Review popup is displayed");
    }

    public void inputTitleAndComment(){

    }

    public void clickSubmitReview(){

    }

    public void clickNavigationLinkOnBreadcrumb(){
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void isPageNavigatedCorrectly(){
        Log.debug("Product Details View page - Verify if correct category page is displayed when navigate from breadcrumb");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
        Log.debug("Product Details View page - Correct category page is displayed when navigate from breadcrumb");
    }

    public void isProductImagesDisplayed(){
        Log.debug("Product Details View popup - Verify if the product images display correctly");

        //TO DO

    }

    public void isPriceDisplayCorrectly(){
        Log.debug("Product Details View popup - Verify if the product price display correctly");

        //TO DO

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

    public BigDecimal getTotalPrice(){
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

    public void clickCloseRequestLoginMessage(){
        click(BTN_CLOSE_REQUEST_LOGIN);
        waiter.waitUntilJQueryReady();
        waitUntilDialogClosed();
    }

    public void waitUntilDialogClosed(){
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            By dialogLocator = By.cssSelector("div.fancybox-opened");
            List<WebElement> dialog;
            do{
                dialog = driver.findElements(dialogLocator);
            }while (dialog.size() != 0);

        } catch (NoSuchElementException ex) {
            System.out.print(ex);
            return;
        }finally {
            driver.manage().timeouts().implicitlyWait(serverTimeout, TimeUnit.SECONDS);
        }
    }

    }

