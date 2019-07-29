package pages;

import objects.Customer;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;

import utilities.AssertCollection;
import utilities.Log;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    public static String BASE_URL = "my-account";
    public static String PERSONAL_INFORMATION_URL = "controller=identity";
    public static String ORDER_HISTORY_URL = "controller=history";
    public static String MY_WISHLIST_URL = "controller=mywishlist";
    public static String MY_ADDRESSES_URL = "controller=addresses";
    public static String ADD_ADDRESS_URL = "controller=address";
    public static String MY_PERSONAL_INFORMATION_URL = "controller=identity";
    WebElement order = null;
    boolean isSortedASC = false;
    String orderReference  = "";
    String orderStatus = "";
    String orderDate = "";
    BigDecimal orderTotalPrice = new BigDecimal(0);

    List<LocalDate> arrayDateBefore = new ArrayList<>();
    List<LocalDate> arrayDateAfter = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormat.forPattern( "MM/dd/yyyy" );
    List<BigDecimal> listTotalPriceBefore = new ArrayList<>();
    List<BigDecimal> listTotalPriceAfter = new ArrayList<>();
    List<String> listStatusBefore = new ArrayList<>();
    List<String> listStatusAfter = new ArrayList<>();

    //*********Web Elements*********
    private static By BTN_USER_NAME = By.cssSelector("");
    private static By BTN_ORDER_HISTORY = By.cssSelector("a[title='Orders']");
    private static By BTN_CREDIT_SLIP = By.cssSelector("a[title='Credit slips']");
    private static By BTN_MY_ADDRESSES = By.cssSelector("a[title='Addresses']");
    private static By BTN_PERSONAL_INFORMATION = By.cssSelector("a[title='Information']");
    private static By BTN_WISHLISTS = By.cssSelector("a[title*='wishlists']");
    private static By BTN_HOME_BOTTOM = By.cssSelector("a[title='Home']");
    private static By LBL_PAGE_HEADING = By.cssSelector(".page-heading");

    //Personal Information page
    private static By INFORMATION_FORM = By.cssSelector("form.std");
    private static By SELECTED_RAD_GENDER = By.cssSelector("input[name='id_gender'][checked]");
    private static By RAD_GENDER = By.cssSelector("input[name='id_gender']:not([checked])");
    private static By TXT_FIRST_NAME = By.cssSelector("#firstname");
    private static By TXT_LAST_NAME = By.cssSelector("#lastname");
    private static By TXT_EMAIL = By.cssSelector("#email");
    private static By SELECT_DAY_OF_BIRTH = By.cssSelector("#days");
    private static By SELECT_MONTH_OF_BIRTH = By.cssSelector("#months");
    private static By SELECT_YEAR_OF_BIRTH = By.cssSelector("#years");
    private static By TXT_OLD_PASSWORD = By.cssSelector("#old_passwd");
    private static By TXT_NEW_PASSWORD = By.cssSelector("#passwd");
    private static By TXT_CONFIRM_PASSWORD = By.cssSelector("#confirmation");
    private static By CHK_NEWSLETTER = By.cssSelector("#newsletter");
    private static By CHK_SPECIAL_OFFERS = By.cssSelector("#optin");
    private static By BTN_SAVE = By.cssSelector("button[name='submitIdentity']");

    //Order History page
    private static By BLOCK_HISTORY = By.cssSelector("#block-history");
    private static By ORDER_LIST = By.cssSelector("#order-list");
    private static By LBL_ORDER_NAME = By.cssSelector("#order-list th:nth-of-type(1)");
    private static By DATE_COLUMN_HEADER = By.cssSelector("#order-list th:nth-of-type(2)");
    private static By LBL_ORDER_DATE = By.cssSelector("");
    private static By PRICE_COLUMN_HEADER = By.cssSelector("");
    private static By LBL_ORDER_PRICE = By.cssSelector("");
    private static By LBL_ORDER_PAYMENT_METHOD = By.cssSelector("");
    private static By STATUS_COLUMN_HEADER = By.cssSelector("");
    private static By LBL_ORDER_STATUS = By.cssSelector("");
    private static By LBL_ORDER_INVOICE = By.cssSelector("");
    private static By BTN_ORDER_DETAILS = By.cssSelector("");
    private static By BTN_ORDER_REORDER = By.cssSelector("");
    private static By BTN_REORDER_DETAILS = By.cssSelector("");
    private static By BTN_BACK_TO_ACCOUNT = By.cssSelector("");
    private static By BTN_HISTORY_HOME = By.cssSelector("");
    private static By BLOCK_ORDER_DETAILS = By.cssSelector("");
    private static By STATUS_TABLE_DETAILS = By.cssSelector("");
    private static By BTN_SEND = By.cssSelector("");

    //My Wishlist page
    private static By LEFT_BLOCK = By.cssSelector("#left_column");
    private static By BEST_SELLER_BLOCK = By.cssSelector("#best-sellers_block_right");
    private static By CATEGORIES_BLOCK = By.cssSelector("#categories_block_left");
    private static By INFORMATION_BLOCK = By.cssSelector("#informations_block_left_1");
    private static By MANUFACTURES_BLOCK = By.cssSelector("#manufacturers_block_left");
    private static By MY_ACCOUNT_BLOCK = By.cssSelector(".myaccount-column");
    private static By SPECIALS_BLOCK = By.cssSelector("#special_block_right");
    private static By STORES_BLOCK = By.cssSelector("#stores_block_left");
    private static By SUPPLIERS_BLOCK = By.cssSelector("#suppliers_block_left");
    private static By VIEWED_PRODUCTS_BLOCK = By.cssSelector("#viewed-products_block_left");
    private static By WISHLIST_BLOCK = By.cssSelector("#mywishlist");
    private static By TXT_WISHLIST_NAME = By.cssSelector("#name");
    private static By BTN_SAVE_WISHLIST = By.cssSelector("#submitWishlist");
    private static By HISTORY_BLOCK = By.cssSelector("#block-history");

    //My Addresses page
    private static By HEADING_ADDRESS = By.cssSelector(".page-heading");
    private static By ADDRESS_BLOCK = By.cssSelector(".bloc_adresses");
    private static By FORM_ADD_ADDRESS = By.cssSelector("form#add_address");
    private static By BTN_YOUR_ADDRESS = By.cssSelector("ul.footer_links.clearfix a");
    private static By TXT_COMPANY = By.cssSelector("input#company");
    private static By BTN_SUBMIT_ADDRESS = By.cssSelector("button#submitAddress");
    private static By BTN_UPDATE_ADDRESS = By.cssSelector("a[title='Update']");
    private static By BTN_DELETE_ADDRESS = By.cssSelector("a[title='Delete']");
    private static By BTN_ADD_NEW_ADDRESS = By.cssSelector("a[title='Add an address']");
    private static By TXT_ADDRESS_ADDRESS1 = By.cssSelector("input#address1");
    private static By TXT_ADDRESS_ADDRESS2 = By.cssSelector("input#address2");
    private static By TXT_ADDRESS_CITY = By.cssSelector("input#city");
    private static By TXT_ADDRESS_STATE = By.cssSelector("select#id_state");
    private static By TXT_ADDRESS_ZIP_CODE = By.cssSelector("input#postcode");
    private static By SELECT_ADDRESS_COUNTRY = By.cssSelector("select#id_country");
    private static By TXT_ADDRESS_ADD_INFO = By.cssSelector("textarea#other");
    private static By TXT_ADDRESS_HOME_PHONE = By.cssSelector("input#phone");
    private static By TXT_ADDRESS_MOBILE_PHONE = By.cssSelector("input#phone_mobile");
    private static By TXT_ADDRESS_ALIAS = By.cssSelector("input#alias");

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getPersonalInformationUrl() {
        return PERSONAL_INFORMATION_URL;
    }

    public static String getOrderHistoryUrl() {
        return ORDER_HISTORY_URL;
    }

    public static String getMyWishlistUrl() {
        return MY_WISHLIST_URL;
    }

    public static String getMyAddressesUrl() {
        return MY_ADDRESSES_URL;
    }

    public static String getMyPersonalInformationUrl() {
        return MY_PERSONAL_INFORMATION_URL;
    }

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static void setPersonalInformationUrl(String personalInformationUrl) {
        PERSONAL_INFORMATION_URL = personalInformationUrl;
    }

    public static void setOrderHistoryUrl(String orderHistoryUrl) {
        ORDER_HISTORY_URL = orderHistoryUrl;
    }

    public static void setMyWishlistUrl(String myWishlistUrl) {
        MY_WISHLIST_URL = myWishlistUrl;
    }

    public static void setMyAddressesUrl(String myAddressesUrl) {
        MY_ADDRESSES_URL = myAddressesUrl;
    }

    public static void setMyPersonalInformationUrl(String myPersonalInformationUrl) {
        MY_PERSONAL_INFORMATION_URL = myPersonalInformationUrl;
    }

    public void isOnMyAccountPage(){
        waiter.waitForPageLoaded();
        Log.debug("Verify if user is on My Account Page.");

        //TO DO

    }

    public void clickPersonalInformationButton(){
        click(BTN_PERSONAL_INFORMATION);
    }

    public void isOnPersonalInformationPage(){
        Log.debug("MyAccountPage - Verify if user is on Personal Information page");

        //TO DO

    }

    public void isInformationDisplayedCorrectly(Customer customer){
        Log.debug("MyAccountPage - Verify the personal information display correctly");
        try {

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void clickHomeButtonAtBottom(){
        click(BTN_HOME_BOTTOM);
    }

    public void clickHomeButtonAtBottomOfOrderHistoryPage(){
        click(BTN_HISTORY_HOME);
    }

    public void clickOrderHistoryButton(){
        click(BTN_ORDER_HISTORY);
    }

    public void isOnOrderHistoryPage(){
        waiter.waitForPageLoaded();
        Log.debug("Verify if user is on Order History Page.");

        //TO DO

    }

    public boolean isOrderListEmpty(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {

            //TO DO
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(serverTimeout, TimeUnit.SECONDS);
        }
    }

    public WebElement getRandomOrderReference(){
        try{

            //TO DO
            return null;
        }catch (Exception ex){
            throw ex;
        }
    }

    public void verifyOrderReferenceIsDisplayed(){
        Log.debug("TestContactUsPage - Verify the expected order reference is displayed");
        boolean isOrderExist = false;
        try {


            //TO DO

        }
        catch (Exception ex){
            System.out.print(ex);
        }
    }

    public void clickToViewOrderReferenceDetails(){
        try {

            //TO DO

        }catch (Exception ex){
            System.out.print(ex);
        }
    }

    public void isOrderDetailsBlockDisplayed(){
        try{

            //TO DO

        }catch (Exception ex){
            driver.manage().timeouts().implicitlyWait(serverTimeout, TimeUnit.SECONDS);
            Assert.fail("The Order Details block is not displayed");
            //throw ex;
        }
    }

    public void clickReorderButtonAtDetailsSection(){

        //TO DO

    }

    public void verifyOrderStatusInDetailsSectionDisplayedCorrectly(){
        Log.debug("TestOrderHistory - Verify the Order status in details section displayed correctly");

        //TO DO

    }

    public void verifyDeliveryAndInvoiceAddressInformation(){
        Log.debug("TestOrderHistory - Verify the Order status in details section displayed correctly");

        //TO DO

    }

    public void verifyTotalPriceInOrderDetailsSection(){
        Log.debug("TestOrderHistory - Verify the total price of order display correctly in details section.");

        //TO DO

    }

    public void addCommentAndClickSendButtonInDetailsSection(){
        try {
            Log.debug("TestOrderHistory - Add comments and click send button in details section");

            //TO DO

        }catch (Exception ex){
            System.out.print(ex);
        }

    }

    public void verifyMessageIsSentSuccessfully(){
        Log.debug("TestOrderDetails - Verify that the message in order details section is sent successfully.");

        //TO DO

    }

    public void clickSortByDate(){

        //TO DO

    }

    public void isSortByDateWorkCorrectly(){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.print(ex);
        }
    }

    public void clickSortByTotalPrice(){

        //TO DO

    }

    public void isSortByTotalPriceWorkCorrectly(){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.print(ex);
        }
    }

    public void clickSortByStatus(){

        //TO DO

    }

    public void isSortByStatusWorkCorrectly(){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.print(ex);
        }
    }

    public void clickReorderButtonAtTheLastColumn(){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void verifyTheNavigatedPage(){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.print(ex);
        }
    }

    public void isInvoiceButtonFunctionWorkCorrectly(){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.print(ex);
        }
    }

    public void waitUntilFileDownloaded(String downloadPath, String fileName){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.print(ex);
        }
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        try{

            //TO DO
            return false;

        }catch (Exception ex){
            throw ex;
        }
    }

    public void clickBackToAccountPage(){
        click(BTN_BACK_TO_ACCOUNT);
    }

    public void clickMyWishlistButton(){
        click(BTN_WISHLISTS);
    }

    public void isOnMyWishlistsPage(){

        //TO DO

    }

    public void writeWishlistName(){

        //TO DO

    }

    public void clickSaveWishlistNameButton(){
        click(BTN_SAVE_WISHLIST);
    }

    public void isTheWishlistCreatedSuccessfully(){
        Log.debug("TestMyWishlist - Verify if the new wishlist is created successfully");

        //TO DO

    }

    public void verifyTheProductAddedInWishlistIsDisplayed(){
        Log.debug("TestMyWishlist - Verify the added products is displayed in My wishlist");

        //TO DO

    }

    public void clickMyAddressesButton(){
        click(BTN_MY_ADDRESSES);
    }

    public void isOnMyAddressesPage(){
        Log.debug("TestMyAddressesPage - Verify if user is on My Addressses page");

        //TO DO

    }

    public void clickUpdateAddress(){

        //TO DO

    }

    public void updateCompanyNameInMyAddress(){

        //TO DO

    }

    public void clickSubmitAddress(){
        click(BTN_SUBMIT_ADDRESS);
    }

    public void isCompanyNameInAddressUpdated(){
        Log.debug("TestMyAddress - Verify if the address is updated successfully.");

        //TO DO

    }

    public void clickDeleteAddress() {
        click(BTN_DELETE_ADDRESS);
    }

    public void clickAcceptDeletingAddress(){

        //TO DO

    }

    public void verifyTheAddressIsDeletedSuccessfully(){
        Log.debug("TestMyAddress - Verify if the address is deleted successfully.");

        //TO DO

    }

    public void clickAddNewAddress(){
        click(BTN_ADD_NEW_ADDRESS);
    }

    public void isOnAddNewAddressPage(){
        Log.debug("TestMyAddressesPage - Verify if user is on Add new address page");

        //TO DO

    }

    public void writeCreateAddressFormFromExistingCustomer(Customer customer){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.print(ex);
        }

    }

    public void VerifyTheAddressIsCreatedSuccessfully(){
        Log.debug("TestMyAddress - Verify if the address is created successfully.");

        //TO DO

    }
    public void updateThePersonalInformationAndChangePassword(String oldPassword) {
        try{

            //TO DO

        }catch (Exception ex){
            System.out.print(ex);
        }
    }

    public void clickSavePersonalInformation(){

        //TO DO

    }

    public void verifyThePersonalInformationIsUpdated(){
        Log.debug("TestPersonalInformation - Verify if the personal information is updated successfully");

        //TO DO

    }


}
