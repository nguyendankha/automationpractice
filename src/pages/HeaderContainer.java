package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.xml.sax.Locator;
import utilities.AssertCollection;
import utilities.JSWaiter;
import utilities.Log;

import javax.swing.*;

public class HeaderContainer extends BasePage {

    public HeaderContainer(WebDriver driver)
    {
        super(driver);
    }

    private String textSearch;
    private BigDecimal totalQuantityBefore = new BigDecimal(0);
    private BigDecimal totalQuantityAfter = new BigDecimal(0);
    private BigDecimal quantityToBeRemoved = new BigDecimal(0);


    //*********Web Elements*********
    private static By HEADER_CONTAINER = By.cssSelector(".header-container");
    private static By HEADER_BANNER_IMG = By.cssSelector("");
    private static By LBL_SHOP_PHONE = By.cssSelector("");
    private static By BTN_CONTACT_US = By.cssSelector("");
    private static By BTN_SIGN_OUT = By.cssSelector("");
    private static By BTN_LOGIN = By.cssSelector("");
    private static By BTN_USER = By.cssSelector("");
    private static By BTN_ACCOUNT_INFO = By.cssSelector("");
    private static By LOGO_IMG = By.cssSelector("");
    private static By TXT_SEARCH_QUERY = By.cssSelector("");
    private static By BTN_SUBMIT_SEARCH = By.cssSelector("");
    private static By SHOPPING_CART = By.cssSelector("");
    private static By TOP_MENU_BLOCK = By.cssSelector("");
    private static By TOP_MENU = By.cssSelector("");
    private static By TOP_SUB_MENU = By.cssSelector("");
    private static By TOP_MENU_WOMEN = By.cssSelector("");
    private static By TOP_MENU_DRESSES = By.cssSelector("");
    private static By TOP_MENU_TSHIRTS = By.cssSelector("");
    private static By TOP_MENU_BLOG = By.cssSelector("");

    //Shopping cart dropdown in header container
    private static By BTN_REMOVE_IN_DROPDOWN = By.cssSelector("");
    private static By CART_DROPDOWN = By.cssSelector("");
    private static By LBL_EMPTY = By.cssSelector("");
    private static By PRODUCTS_LIST_IN_DROPDOWN = By.cssSelector("");
    private static By LBL_ITEMS_COUNT = By.cssSelector("");
    private static By BTN_CHECKOUT_IN_DROPDOWN = By.cssSelector("");
    private static By LBL_ITEM_QUANTITY = By.cssSelector("");

    //Data for random general
    private String[] searchTexts = new String[]{"Blouse", "Dress", "Yellow", "Printed"};

    public void isHeaderContainerDisplayed() {
        Log.debug("HeaderContainerLog - Verify if header container displayed");

        //TO DO

    }

    public void generateTextSearchWithRandomizedInformation() {
        try {

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void waitUntilTheButtonClickable(By locator){

        //TO DO

    }

    public void clickSignInButton() {

        //TO DO

    }

    public void clickSignOutButton() {
        click(BTN_SIGN_OUT);
    }

    public void clickContactUsButton() {
        click(BTN_CONTACT_US);
    }

    public void writeTextInSearchField() {

        //TO DO

    }

    public void setSearchText(String searchText) {
        writeText(TXT_SEARCH_QUERY, searchText);
    }

    public void clickSearchButton() {
        click(BTN_SUBMIT_SEARCH);
    }

    public void clickHomeIcon() {
        click(LOGO_IMG);
    }

    public void clickWomanCategory(){
        click(TOP_MENU_WOMEN);
    }

    public void clickDressCategory(){
        click(TOP_MENU_DRESSES);
    }

    public void clickTShirtsCategory(){
        click(TOP_MENU_TSHIRTS);
    }

    public void clickUserAccountButton(){

        //TO DO

    }

    public String getTextSearch() {
        String s = null;
        return s;
    }

    public void setTextSearch(String textSearch) {

    }

    public void selectRandomSubCategories(int index){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public boolean isUserLoggedIn(){
        Log.debug("HeaderContainerLog - Check if user is logged in.");

        //TO DO
        return true;

    }

    public void hoverOnShoppingCartOnHeader(){

        //TO DO

    }

    public void clickShoppingCartDropDownList(){
        click(CART_DROPDOWN);
    }

    public void clickProceedToCheckout(){

        //TO DO

    }

    public void removeItemInShoppingCartHeader(){
        try{

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void removeAllShoppingItemsOnTheHeaderIfAny(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }finally {
            driver.manage().timeouts().implicitlyWait(serverTimeout, TimeUnit.SECONDS);
        }
    }

    public void isTheTotalOfShoppingCartItemsDecrease(){
        Log.debug("Shopping cart dropdown list - Verify the item count in the shopping cart dropdown list is decrease");

        //TO DO

    }

    public void isTheShoppingCartRetain(){

        //TO DO

    }

    public void navigateToAnotherWebsite(){

        //TO DO

    }


}
