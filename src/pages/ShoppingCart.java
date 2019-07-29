package pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.AssertCollection;
import utilities.JSWaiter;
import utilities.Log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ShoppingCart extends BasePage{

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    public static String SUMMARY_STEP_URL = "http://automationpractice.com/index.php?controller=order";
    public static String ADDRESS_STEP_URL = "controller=order&step=1";
    public static String LOGIN_STEP_URL = "controller=authentication";
    public static String orderReference = "";
    private boolean isPayByBank = false;
    private String rowLocator = "tr:nth-of-type";
    private String deliveryAddress = "";
    BigDecimal unitPrice = new BigDecimal(0);
    BigDecimal singlePrice = new BigDecimal(0);
    BigDecimal singleQuantityBefore = new BigDecimal(0);
    BigDecimal singleQuantityAfter = new BigDecimal(0);
    BigDecimal totalPriceBefore = new BigDecimal(0);
    BigDecimal totalPriceAfter = new BigDecimal(0);
    BigDecimal totalQuantityBefore = new BigDecimal(0);
    BigDecimal totalQuantityAfter = new BigDecimal(0);

    BigDecimal totalProductsPrice = new BigDecimal(0);
    BigDecimal totalShippingPrice = new BigDecimal(0);
    BigDecimal totalTax = new BigDecimal(0.00);
    List<Integer> listIndex = new ArrayList<>();
    //*********Web Elements*********

    //Step 01 - Summary
    private static By CURRENT_STEP_1 = By.cssSelector(".step_current.first");
    private static By LBL_PRODUCT_COUNT = By.cssSelector(".heading-counter");
    private static By PRODUCT_COUNT = By.cssSelector("#summary_products_quantity");
    private static By STEPS_NAVIGATION = By.cssSelector("ul.step");
    private static By TBL_ORDER_DETAIL = By.cssSelector("#cart_summary");
    private static By TXT_CART_QUANTITY = By.cssSelector("#cart_summary tbody >tr:nth-child(1) .cart_quantity input.cart_quantity_input");
    private static By BTN_QUANTITY_UP = By.cssSelector("#cart_summary tbody >tr:nth-child(1) .cart_quantity .cart_quantity_up");
    private static By BTN_QUANTITY_DOWN = By.cssSelector("#cart_summary tbody >tr:nth-child(1) .cart_quantity .cart_quantity_down");
    private static By LBL_TOTAL_PRICE = By.cssSelector("#cart_summary tbody >tr:nth-child(1) .cart_total span");
    private static By BTN_DELETE_PRODUCT = By.cssSelector("#cart_summary tbody >tr:nth-child(1) .cart_delete a");
    private static By LBL_PRODUCT_PRICE = By.cssSelector("#cart_summary tbody >tr:nth-child(1) .cart_unit span span");
    private static By LBL_PRICE_PERCENT_REDUCTION = By.cssSelector("#cart_summary tbody >tr:nth-child(1) .price-percent-reduction");
    private static By LBL_OLD_PRICE = By.cssSelector("#cart_summary tbody >tr:nth-child(1) .old-price");
    private static By LBL_TOTAL_PRODUCT = By.cssSelector("#total_product");
    private static By LBL_TOTAL_SHIPPING = By.cssSelector("#total_shipping");
    private static By LBL_TAX= By.cssSelector("#total_tax");
    private static By LBL_TOTAL = By.cssSelector("#total_price");
    private static By BTN_CHECKOUT_SUMMARY_STEP = By.cssSelector(".cart_navigation a[title='Proceed to checkout']");

    //Step 02 - Sign In
    //private static By CURRENT_STEP_2 = By.cssSelector("ul#order_step li.step_current.second");
    private static By TAB_CONTENT = By.cssSelector("");
    private static By CREATE_ACC_FORM = By.cssSelector("#create-account_form");
    private static By CREATE_ACC_EMAIL = By.cssSelector("input#email_create");
    private static By BTN_CREATE_ACC = By.cssSelector("#SubmitCreate");
    private static By VALID_EMAIL_CHECKING_FROM_CREATE_FORM = By.cssSelector("");
    private static By INVALID_EMAIL_CHECKING_FROM_CREATE_FORM = By.cssSelector("");

    private static By LOGIN_FORM = By.cssSelector("#login_form");
    private static By LOGIN_EMAIL = By.cssSelector("#email");
    private static By LOGIN_PASSWORD = By.cssSelector("#passwd");
    private static By LOGIN_FORGOT_PASSWORD_LINK = By.cssSelector(".lost_password a");
    private static By BTN_SUBMIT_LOGIN = By.cssSelector("#SubmitLogin");
    private static By INVALID_EMAIL_LOGIN_ALERT = By.cssSelector(".alert.alert-danger");
    private static By CREATE_ACCOUNT_ERROR = By.cssSelector("#create_account_error");

    private static By SIGNUP_FORM_OK_ICON = By.cssSelector("");
    private static By SIGNUP_FORM_ERROR_ICON = By.cssSelector("");
    private static By LOGIN_FORM_OK_ICON = By.cssSelector("");
    private static By LOGIN_FORM_ERROR_ICON = By.cssSelector("");

    private static By ACCOUNT_CREATION_FORM = By.cssSelector("#account-creation_form");

    //private static By BTN_CHECKOUT_STEP_2 = By.cssSelector("");

    //Step 03 - Address
    private static By CURRENT_STEP_3 = By.cssSelector("li.step_current.third");
    private static By SELECT_DELIVERY_ADDRESS = By.cssSelector("#id_address_delivery");
    private static By CHK_ADDRESSES_ARE_EQUAL = By.cssSelector("#uniform-addressesAreEquals");
    private static By DELIVERY_ADDRESS_BLOCK = By.cssSelector("ul#address_delivery");
    private static By BTN_UPDATE_DELIVERY_ADDRESS = By.cssSelector("#address_delivery a");
    private static By INVOICE_ADDRESS_BLOCK = By.cssSelector("#address_invoice");
    private static By BTN_UPDATE_INVOICE_ADDRESS = By.cssSelector("#address_invoice a");
    private static By BTN_ADD_NEW_ADDRESS = By.cssSelector(".address_add a[title='Add']");
    private static By TXT_MESSAGE = By.cssSelector("textarea[name='message']");
    private static By BTN_CHECKOUT_ADDRESS_STEP = By.cssSelector("button[name='processAddress']");
    
    //Update My Address page
    private static By BREADCRUMB = By.cssSelector(".breadcrumb");
    private static By FORM_ADD_ADDRESS = By.cssSelector("#add_address");
    private static By BTN_YOUR_ADDRESS = By.cssSelector("");
    private static By TXT_COMPANY = By.cssSelector("input#company");
    private static By BTN_SUBMIT_ADDRESS = By.cssSelector("#submitAddress");


    //Step 04 - Shipping
    private static By CURRENT_STEP_4 = By.cssSelector("li.step_current.four");
    private static By SHIPPING_OPTION = By.cssSelector("input.delivery_option_radio");
    private static By CHK_TERMS_OF_SERVICE = By.cssSelector("input#cgv");
    private static By LINK_TERMS_OF_SERVICE = By.cssSelector(".checkbox a");
    private static By TERMS_OF_SERVICE_POPUP = By.cssSelector(".fancybox-iframe");
    private static By BTN_CLOSE_POPUP = By.cssSelector("a[title='Close']");
    private static By ERROR_MESSAGE_SHIPPING = By.cssSelector("");
    private static By BTN_CLOSE_ERROR_MESSAGE_POPUP = By.cssSelector("");
    private static By BTN_CHECKOUT_CARRIER_STEP = By.cssSelector(".cart_navigation button");
    //Step 05 - Payment
    private static By CURRENT_STEP_5 = By.cssSelector("#step_end");
    private static By CART_SUMMARY = By.cssSelector("#cart_summary");
    private static By BTN_PAY_BY_BANK = By.cssSelector("a.bankwire");
    private static By BTN_PAY_BY_CHECK = By.cssSelector("a.cheque");
    private static By PAYMENT_CONFIRMATION = By.cssSelector(".cart_navigation button");


    //private static By BTN_CHECKOUT_SUMMARY_STEP = By.cssSelector("");
    private static By BTN_CONTINUE_SHOPPING = By.cssSelector("a[title='Continue shopping']");

    //ORDER CONFIRMATION
    private static By ORDER_CONFIRMATION_BLOCK = By.cssSelector(".box");
    private static By BTN_BACK_TO_ORDERS = By.cssSelector("a[title='Back to orders']");
    private static By BTN_OTHER_PAYMENT_METHODS = By.cssSelector(".cart_navigation a");
    private static By BTN_CONFIRM_ORDER = By.cssSelector(".cart_navigation button");

    private static By LBL_EMPTY = By.cssSelector("p.alert.alert-warning");
    private static By CART_DROPDOWN = By.cssSelector(".shopping_cart .cart_block");
    private static By LBL_ITEMS_COUNT = By.cssSelector(".shopping_cart .ajax_cart_quantity");


    //******Page Methods******
    public void isOnShoppingCart(){
        Log.debug("Verify if user is on Shopping Cart - Summary Step");

        //TO DO

    }

    public boolean isSummaryStepDisplayed(){
        return isElementExisting(CURRENT_STEP_1);
    }

    public BigDecimal getTotalQuantity(){
        try{
            waiter.waitUntilJQueryReady();
            String strTotalQuantity = driver.findElement(PRODUCT_COUNT).getAttribute("innerText").replace("Products", "").replace("Product", "").trim();
            Log.debug("strTotalQuantity: "+strTotalQuantity);
            return new BigDecimal(strTotalQuantity);
        }catch (Exception ex){
            throw ex;
        }
    }

    public BigDecimal getTotalPrice(){
        try{
            String strTotalPrice = driver.findElement(LBL_TOTAL_PRODUCT).getAttribute("innerText").replace("$", "");
            return new BigDecimal(strTotalPrice);
        }catch (Exception ex){
            throw ex;
        }
    }

    public BigDecimal getUnitPrice(WebElement product){
        try{
            String strTotalPrice = product.findElement(LBL_PRODUCT_PRICE).getAttribute("innerText").replace("$", "");
            return new BigDecimal(strTotalPrice);
        }catch (Exception ex){
            throw ex;
        }
    }

    public BigDecimal getSinglePrice(WebElement product){
        try {
            String price = product.findElement(LBL_TOTAL_PRICE).getAttribute("innerText").replace("$", "");
            return new BigDecimal(price);
        }catch (Exception ex){
            throw ex;
        }
    }

    public BigDecimal getSingleQuantity(WebElement product){
        try{
            String quantity = product.findElement(TXT_CART_QUANTITY).getAttribute("value");
            return new BigDecimal(quantity);
        }catch (Exception ex){
            throw ex;
        }
    }

    public BigDecimal getTotalProductsPrice(){
        try{
            String strTotalPrice = driver.findElement(LBL_TOTAL).getAttribute("innerText").replace("$", "");
            return new BigDecimal(strTotalPrice);
        }catch (Exception ex){
            throw ex;
        }
    }

    public BigDecimal getTotalShippingPrice(){
        try{
            String strTotalPrice = driver.findElement(LBL_TOTAL_SHIPPING).getAttribute("innerText").replace("$", "");
            return new BigDecimal(strTotalPrice);
        }catch (Exception ex){
            throw ex;
        }
    }

    public BigDecimal getTotalTax(){
        try{
            String strTotalPrice = driver.findElement(LBL_TAX).getAttribute("innerText").replace("$", "");
            return new BigDecimal(strTotalPrice);
        }catch (Exception ex){
            throw ex;
        }
    }


    public WebElement getRandomProduct(){
        try{

            //TO DO
            return null;
        }catch (Exception ex){
            throw ex;
        }
    }

    public void removeProduct() {
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void isTotalQuantityDisplayCorrectly() {
        Log.debug("Shopping Cart - Verify if total product is displayed correctly after add products to cart");
        try{

            //TO DO

        }
        catch(Exception ex) {
            throw ex;
        }
        Log.debug("Shopping Cart - Total product is displayed correctly after add products to cart");
    }

    public void isTotalPriceDisplayedCorrectly(){
        Log.debug("Shopping Cart - Verify if Total Price is displayed correctly");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
        Log.debug("Shopping Cart - Total Price is displayed correctly");
    }

    public void isTotalQuantityUpdatedAfterRemovingProduct() {
        Log.debug("Shopping Cart - Verify if total product is updated correctly after removing product from cart");
        try{

            //TO DO

        }
        catch(Exception ex) {
            throw ex;
        }
        Log.debug("Shopping Cart - Total product is updated correctly after removing product from cart");
    }

    public void isTotalPriceUpdatedAfterRemovingProduct() {
        Log.debug("Shopping Cart - Verify if total price is updated correctly after removing product from cart");
        try{

            //TO DO

        }
        catch(Exception ex) {
            throw ex;
        }
        Log.debug("Shopping Cart - Total price is updated correctly after removing product from cart");
    }

    public void isTotalPricePerProductUpdated() {
        Log.debug("Shopping Cart - Verify if total price per product is updated correctly after removing product from cart");
        try{

            //TO DO

        }
        catch(Exception ex) {
            throw ex;
        }
        Log.debug("Shopping Cart - Total price is updated correctly after removing product from cart");
    }

    public void clickCheckoutButton(){

        //TO DO

    }

    public void clickShoppingCartEmptyButton(){

        //TO DO

    }

    public void isEmptyTextDisplayed(){
        waiter.waitForPageLoaded();
        Log.debug("Shopping Cart - Verify if text 'Your Shopping cart is empty' is displayed when clicking on empty Shopping cart button");
        try{

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
        Log.debug("Shopping Cart - Text 'Your Shopping cart is empty' is displayed");
    }

    public void clickRemoveProductButton(){
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void clickIncreaseQuantityButton(){
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void isIncreaseButtonWorkCorrectly(){

        //TO DO

    }

    public void clickDecreaseQuantityButton(){
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void isDecreaseButtonWorkCorrectly(){

        //TO DO

    }

    public void isProductPriceUpdatedCorrectly(){
        Log.debug("Shopping Cart - Verify if Product Price is updated correctly");
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
        Log.debug("Shopping Cart - Product Price is updated correctly");
    }

    public void clickContinueShoppingButton(){
        click(BTN_CONTINUE_SHOPPING);
    }

    public void clickCheckoutButtonSummaryStep(){
        click(BTN_CHECKOUT_SUMMARY_STEP);
    }

    public void isOnAddressStep(){
        Log.debug("Verify if user is on Shopping Cart - Address Step");

        //TO DO

    }

    public boolean isAddressStepDisplayed(){
        return isElementExisting(CURRENT_STEP_3);
    }

    public void isOnSignInStep(){
        Log.debug("Verify if user is on Shopping Cart - Sign in step");

        //TO DO

    }

    //Input a email to create form
    public void inputAEmailToCreateForm(String email)
    {
        Log.debug("Input e-mail in Create form: " + email);

        //TO DO

    }

    public void clickCreateAnAccountButton(){

        //TO DO

    }

    public void uncheckOptionSameAddress(){
        click(CHK_ADDRESSES_ARE_EQUAL);
    }

    public void isButtonAddressDisplayed(){
        Log.debug("TestShoppingCartPage - Verify the Add new address button is displayed");

        //TO DO

    }

    public void clickUpdateDeliveryAddress(){
        click(BTN_UPDATE_DELIVERY_ADDRESS);
    }

    public void clickUpdateBillingAddress(){
        click(BTN_UPDATE_INVOICE_ADDRESS);
    }

    public void isOnUpdateMyAddressPage(){
        Log.debug("Verify if user is on Update Address page");

        //TO DO

    }

    public void updateCompanyNameInMyAddress(){

        //TO DO

    }

    public void isCompanyNameInAddressUpdated(){

        //TO DO

    }

    public void clickSubmitAddress(){
        click(BTN_SUBMIT_ADDRESS);
    }

    public void addComment(){

        //TO DO

    }

    public void selectDeliveryAddress(){

        //TO DO

    }

    public void clickCheckoutButtonAddressStep(){
        click(BTN_CHECKOUT_ADDRESS_STEP);
    }

    public void isOnShippingStep() {
        Log.debug("Verify if user is on Shopping Cart - Shipping step");

        //TO DO

    }

    public boolean isShippingStepDisplayed(){
        return isElementExisting(CURRENT_STEP_4);
    }

    public void isShippingPriceDisplayedCorrectly(){
        Log.debug("TestShoppingCart - Verify the shipping price is displayed correctly");

        //TO DO

    }

    public void isDeliveryAddressDisplayedCorrectly(){
        Log.debug("TestShoppingCart - Verify the delivery address is displayed correctly");

        //TO DO

    }

    public void isWarningForNotCheckingAgreeTermDisplayed(){

        //TO DO

    }

    public void clickCloseWarningMessage(){

        //TO DO

    }

    public void checkOptionAgreeTerm(){

        //TO DO

    }

    public void clickCheckoutButtonShippingStep(){
        click(BTN_CHECKOUT_CARRIER_STEP);
    }

    public void isOnPaymentStep(){
        Log.debug("Verify if user is on Shopping Cart - Payment step");

        //TO DO

    }

    public boolean isPaymentStepDisplayed(){
        return isElementExisting(CURRENT_STEP_5);
    }

    public void selectPaymentMethod(){
        try{

            //TO DO

        }
        catch(Exception ex) {
            throw ex;
        }
    }

    public void isOnConfirmOrderStep(){
        Log.debug("Verify if user is on Shopping Cart - Confirm order step");

        //TO DO

    }

    public void clickOtherPaymentMethodButton(){
        click(BTN_OTHER_PAYMENT_METHODS);
    }

    public void clickConfirmOrderButton(){
        click(BTN_CONFIRM_ORDER);
    }

    public void isOnOrderCompleteStep(){
        Log.debug("Verify if user is on Shopping Cart - Order complete step");
        try {

            //TO DO

        }
        catch(Exception ex){
            throw ex;
        }
        Log.debug("Shopping Cart - Order complete step is displayed correctly");
    }

    public boolean isElementExisting(By locator){
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
