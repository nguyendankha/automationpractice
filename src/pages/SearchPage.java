package pages;

import objects.Product;
import org.omg.IOP.ExceptionDetailMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.AssertCollection;
import utilities.JSWaiter;
import utilities.Log;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
        super(driver);
    }
	
	//*********Page Variables*********

    public static String BASE_URL = "controller=search";
    private String[] sortOptions = new String[]{"position:asc", "price:asc", "price:desc", "name:asc", "name:desc", "quantity:desc","reference:asc","reference:desc"};

    //*********Web Elements*********
    private static By LEFT_COLUMN_BLOCK = By.cssSelector("#left_column");
    private static By BEST_SELLER_BLOCK = By.cssSelector("#best-sellers_block_right");
    private static By BEST_SELLER_ITEMS = By.cssSelector("#best-sellers_block_right ul.block_content > li:nth-child(1)");
    private static By BTN_ALL_BEST_SELLERS = By.cssSelector("a[title='All best sellers']");

    private static By CATEGORY_BLOCK = By.cssSelector("#categories_block_left");
    private static By BTN_EXPAND = By.cssSelector("#categories_block_left ul.tree > li:nth-of-type(1) > span.CLOSE");
    private static By SUBCATEGORIES = By.cssSelector("#categories_block_left ul.tree > li:nth-of-type(1) > ul > li");

    private static By INFORMATION_BLOCK = By.cssSelector("#informations_block_left_1");
    private static By INFORMATION_ITEMS = By.cssSelector("#informations_block_left_1 .block_content ul > li:nth-child(1)");

    private static By MANUFACTURES_BLOCK = By.cssSelector("#manufacturers_block_left");
    private static By MANUFACTURES_ITEMS = By.cssSelector("#manufacturers_block_left .block_content ul > li");
    private static By SELECT_MANUFACTURES_LIST = By.cssSelector("select[name='manufacturer_list']");

    private static By NEW_PRODUCTS_BLOCK = By.cssSelector("");
    private static By NEW_PRODUCTS_ITEMS = By.cssSelector("");
    private static By BTN_ALL_NEW_PRODUCTS = By.cssSelector("");

    private static By SPECIALS_BLOCK = By.cssSelector("#special_block_right");
    private static By SPECIALS_ITEMS = By.cssSelector("#special_block_right .block_content ul > li");
    private static By BTN_ALL_SPECIALS = By.cssSelector("a[title='All specials']");

    private static By OUR_STORES_BLOCK = By.cssSelector("#stores_block_left");
    private static By OUR_STORES_ITEMS = By.cssSelector("#stores_block_left .block_content p a");
    private static By BTN_OUR_STORES = By.cssSelector("#stores_block_left .block_content div a[title='Our stores']");

    private static By OUR_SUPPLIERS_BLOCK = By.cssSelector("#suppliers_block_left");
    private static By OUR_SUPPLIERS_ITEMS = By.cssSelector("#suppliers_block_left .block_content ul > li");
    private static By SELECT_OUR_SUPPLIERS = By.cssSelector("select[name='supplier_list']");

    private static By VIEWED_PRODUCTS_BLOCK = By.cssSelector("#viewed-products_block_left");
    private static By VIEWED_PRODUCTS_ITEMS = By.cssSelector("#viewed-products_block_left .block_content ul > li:nth-child(1)");

    private static By SELECT_SORT_BY = By.cssSelector("#selectProductSort");
    private static By SORT_BY_DEFAULT = By.cssSelector("option[value='position:asc']");
    private static By SORT_BY_PRICE_ASC = By.cssSelector("option[value='price:asc']");
    private static By SORT_BY_PRICE_DESC = By.cssSelector("option[value='price:desc']");
    private static By SORT_BY_PRODUCT_NAME_ASC = By.cssSelector("option[value='name:asc']");
    private static By SORT_BY_PRODUCT_NAME_DESC = By.cssSelector("option[value='name:desc']");
    private static By SORT_BY_IN_STOCK = By.cssSelector("option[value='quantity:desc']");
    private static By SORT_BY_REFERENCE_ASC = By.cssSelector("option[value='reference:asc']");
    private static By SORT_BY_REFERENCE_DESC = By.cssSelector("option[value='reference:desc']");

    private static By BTN_GRID_VIEW = By.cssSelector("a[title='Grid']");
    private static By BTN_LIST_VIEW = By.cssSelector("a[title='List']");
    private static By BTN_COMPARE_TOP = By.cssSelector(".top-pagination-content button");
    private static By BTN_COMPARE_BOTTOM = By.cssSelector(".bottom-pagination-content button");

    private static By LIST_PRODUCT = By.cssSelector("ul.product_list");
    private static By LIST_PRODUCT_GRID = By.cssSelector("ul.product_list.grid");
    private static By LIST_PRODUCT_LIST = By.cssSelector("ul.product_list.list");
    private static By LIST_VIEW_ROWS = By.cssSelector("ul.product_list.row");
    private static By PRODUCT_ITEM = By.cssSelector("ul.product_list > li:nth-of-type(1)");
    private static By BTN_QUICK_VIEW = By.cssSelector("ul.product_list > li:nth-of-type(1) a.quick-view");
    private static By PRODUCT_IMG = By.cssSelector("ul.product_list > li:nth-of-type(1) img");
    private static By PRODUCT_NAME = By.cssSelector("ul.product_list > li:nth-of-type(1) a.product-name");
    private static By PRODUCT_PRICE = By.cssSelector("ul.product_list > li:nth-of-type(1) .right-block .price");
    private static By PRODUCT_PRICE_PERCENT_REDUCTION = By.cssSelector("ul.product_list > li:nth-of-type(1) .right-block .price-percent-reduction");
    private static By PRODUCT_OLD_PRICE = By.cssSelector("ul.product_list > li:nth-of-type(1) .right-block .old-price");
    private static By MOUSE_OVER_PRICE  = By.cssSelector("");
    private static By MOUSE_OVER_PRICE_PERCENT_REDUCTION = By.cssSelector("");
    private static By MOUSE_OVER_OLD_PRICE = By.cssSelector("");
    private static By BTN_ADD_TO_CART = By.cssSelector("ul.product_list > li:nth-of-type(1) a[title='Add to cart']");
    private static By BTN_MORE = By.cssSelector("ul.product_list > li:nth-of-type(1) a[title='View']");
    private static By BTN_ADD_TO_COMPARE = By.cssSelector("ul.product_list > li:nth-of-type(1) a.add_to_compare");
    private static By HEADING_RESULTS_COUNTER = By.cssSelector(".heading-counter");
    private static By SORT_PAGING_BAR_TOP = By.cssSelector(".content_sortPagiBar .top-pagination-content");
    private static By SORT_PAGING_BAR_BOTTOM = By.cssSelector(".content_sortPagiBar .bottom-pagination-content");
    private static By KEYWORD_BLOCK = By.cssSelector(".lighter");

    //****** Page Methods ******
    public void isOnSearchPage(){
        Log.debug("Verify if user is on Search Page");
        String currentURL = getCurrentURL();

        //TO DO

    }


    public int getSearchNumberResult(){

        //TO DO
        return 0;

    }

    public int getNumberProductDisplay(){
	    int i = 0;
	    return i;
    }

    public void sortByPriceAsc(){
    }

    public void sortByPriceDesc(){
    }

    public void sortByProductNameAsc(){
    }

    public void sortByProductNameDesc(){
    }

    public void sortByInStock(){
    }

    public void sortByReferenceAsc(){
    }

    public void sortByReferenceDesc(){
    }

    public void clickGridView(){
        click(BTN_GRID_VIEW);
    }

    public void clickListView(){
        click(BTN_LIST_VIEW);
    }

    public void isOnGridView(){

        //TO DO

    }

    public void isOnListView(){

        //TO DO

    }

    public void isNoResultFoundErrorMessageDisplayed(){
    }

    //check result found or not
    public boolean isHaveSearchResults(){
	    boolean b = true;
	    return b;
    }

    public List<String> getPriceOfSearchResultList(){
	    List list = null;
	    return list;
    }

    public boolean isPriceSortAsc(){
        boolean check=true;
        return check;
    }

    public boolean isPriceSortDesc(){
        boolean check=true;
        return check;
    }

    public void isNumberOfRowItemsInGridViewDisplayCorrectly(){
        Log.debug("Verify if number of row items display correctly in Grid View");

        //TO DO

    }

    public void isNumberOfRowItemsInListViewDisplayCorrectly(){
        Log.debug("Verify if number of row items display correctly in List View");

        //TO DO

    }

    public void isProductListSortedByNameAtoZ(){
        Log.debug("Verify if search result items are sorted by Name A to Z");
        List<String> listProductNameBefore = new ArrayList<>();
        List<String> listProductNameAfter = new ArrayList<>();
        try{

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
        Log.debug("Search result items are sorted by Name A to Z");
    }

    public void isProductListSortedByNameZtoA(){
        Log.debug("Verify if search result items are sorted by Name Z to A");
        List<String> listProductNameBefore = new ArrayList<>();
        List<String> listProductNameAfter = new ArrayList<>();
        try{

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
        Log.debug("Search result items are sorted by Name Z to A");
    }

    public void isProductListSortedByPriceAsc(){
        Log.debug("Verify if search result items are sorted by Price ASC");
        List<String> listProductPriceBefore = new ArrayList<>();
        List<String> listProductPriceAfter = new ArrayList<>();
        try{

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
        Log.debug("Search result items are sorted by Price ASC");
    }

    public void isProductListSortedByPriceDsc(){
        Log.debug("Verify if search result items are sorted by Price DESC");
        List<String> listProductPriceBefore = new ArrayList<>();
        List<String> listProductPriceAfter = new ArrayList<>();
        try{

            //TO DO

        }catch (Exception ex){
            System.out.println(ex);
        }
        Log.debug("Search result items are sorted by Price DESC");
    }
}
