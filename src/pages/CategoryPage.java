package pages;

import org.openqa.selenium.WebElement;
import org.xml.sax.Locator;
import utilities.AssertCollection;
import utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.lang.model.element.Element;
import java.util.Random;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CategoryPage extends BasePage{
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    private static By LEFT_COLUMN_BLOCK = By.cssSelector("div#left_column");

    private static By CATEGORY_BLOCK = By.cssSelector("#categories_block_left");
    private static By SUBCATEGORY_ITEM = By.cssSelector(".block_content ul.tree > li:nth-of-type(1)");
    private static By SUB_SUBCATEGORY_ITEM = By.cssSelector(".block_content ul.tree > li:nth-of-type(1) li:nth-child(1)");
    private static By BTN_CATEGORIES_EXPAND = By.cssSelector(".block_content ul.tree > li:nth-of-type(1) span.CLOSE");
    private static By BTN_CATEGORIES_COLLAPSE = By.cssSelector(".block_content ul.tree > li:nth-of-type(1) span.OPEN");

    private static By CATALOG_BLOCK = By.cssSelector("#layered_block_left");
    private static By ENABLED_FILTERS = By.cssSelector("");
    private static By CATALOG_FILTERS = By.cssSelector("#layered_form");
    private static By CHK_CATEGORIES_OPTIONS = By.cssSelector("#ul_layered_category_0 > li:nth-child(1) input");
    private static By CHK_SIZE_OPTIONS = By.cssSelector("#ul_layered_id_attribute_group_1 > li:nth-child(1) input");
    private static By CHK_COLOR_OPTIONS = By.cssSelector("#ul_layered_id_attribute_group_3 > li:nth-child(1) input");
    private static By CHK_COMPOSITIONS_OPTIONS = By.cssSelector("#ul_layered_id_feature_5 > li:nth-child(1) input");
    private static By CHK_STYLES_OPTIONS = By.cssSelector("#ul_layered_id_feature_6 > li:nth-child(1) input");
    private static By CHK_PROPERTIES_OPTIONS = By.cssSelector("#ul_layered_id_feature_7 > li:nth-child(1) input");
    private static By CHK_AVAILABILITY_OPTIONS = By.cssSelector("#ul_layered_quantity_0 > li input");
    private static By CHK_MANUFACTURER_OPTIONS = By.cssSelector("#ul_layered_manufacturer_0 > li input");
    private static By CHK_CONDITION_OPTIONS = By.cssSelector("#ul_layered_condition_0 > li input");

    private static By INFORMATION_BLOCK = By.cssSelector("#informations_block_left_1");
    private static By INFORMATION_ITEMS = By.cssSelector(".block_content.list-block li:nth-child(1) a");

    private static By NEW_PRODUCTS_BLOCK = By.cssSelector("");
    private static By NEW_PRODUCTS_ITEMS = By.cssSelector("");
    private static By BTN_ALL_NEW_PRODUCTS = By.cssSelector("");

    private static By SPECIALS_BLOCK = By.cssSelector("#special_block_right");
    private static By SPECIALS_ITEMS = By.cssSelector("#special_block_right .block_content.products-block li a.products-block-image");
    private static By BTN_ALL_SPECIALS = By.cssSelector("a[title='All specials']");

    private static By OUR_STORES_BLOCK = By.cssSelector("#stores_block_left");
    private static By OUR_STORES_ITEMS = By.cssSelector("#stores_block_left .block_content.blockstore p a");
    private static By BTN_OUR_STORES = By.cssSelector("a[title='Our stores'] > span");

    private static By VIEWED_PRODUCTS_BLOCK = By.cssSelector("#viewed-products_block_left");
    private static By VIEWED_PRODUCTS_ITEMS = By.cssSelector("#viewed-products_block_left .block_content.products-block ul > li:nth-child(1) a.products-block-image");

    private static By CENTER_COLUMN_BLOCK = By.cssSelector("div#center_column");
    private static By CATEGORY_IMG = By.cssSelector("div.content_scene_cat_bg");
    private static By CATEGORY_HEADING = By.cssSelector("span.cat-name");
    private static By HEADING_COUNTER = By.cssSelector(".heading-counter");
    private static By SUBCATEGORIES_BLOCK = By.cssSelector("#subcategories");
    private static By SUBCATEGORIES_ITEM = By.cssSelector("#subcategories ul > li:nth-child(1) > div > a");

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
    private static By BTN_COMPARE_TOP = By.cssSelector("div.top-pagination-content button");
    private static By BTN_COMPARE_BOTTOM = By.cssSelector("div.bottom-pagination-content button");

    private static By LIST_PRODUCT = By.cssSelector(".product_list");
    private static By LIST_PRODUCT_GRID = By.cssSelector(".product_list.row.grid");
    private static By LIST_PRODUCT_LIST = By.cssSelector(".product_list.row.list");
    private static By PRODUCT_ITEM = By.cssSelector("li.ajax_block_product:nth-child(1)");
    private static By BTN_QUICK_VIEW = By.cssSelector("li.ajax_block_product:nth-child(1) i.icon-eye-open");
    private static By PRODUCT_IMG = By.cssSelector("li.ajax_block_product:nth-child(1) img");
    private static By PRODUCT_NAME = By.cssSelector("li.ajax_block_product:nth-child(1) a.product-name");
    private static By PRODUCT_PRICE = By.cssSelector("li.ajax_block_product:nth-child(1) div.right-block-content span.price");
    private static By PRODUCT_PRICE_PERCENT_REDUCTION = By.cssSelector("li.ajax_block_product:nth-child(7) div.right-block-content span.price-percent-reduction");
    private static By PRODUCT_OLD_PRICE = By.cssSelector("li.ajax_block_product:nth-child(7) div.right-block-content span.old-price");
    private static By MOUSE_HOVER_PRICE  = By.cssSelector("");
    private static By MOUSE_HOVER_PRICE_PERCENT_REDUCTION = By.cssSelector("");
    private static By MOUSE_HOVER_OLD_PRICE = By.cssSelector("");
    private static By BTN_ADD_TO_CART = By.cssSelector("li.ajax_block_product:nth-child(1) a[title='Add to cart']");
    private static By BTN_MORE = By.cssSelector("li.ajax_block_product:nth-child(1) a[title='View']");
    private static By BTN_ADD_TO_COMPARE = By.cssSelector("li.ajax_block_product:nth-child(1) a.add_to_compare");

    public void isOnCategoryPage() {
        Log.debug("CategoryPage - Verify if user is on Category Page");

        //TO DO

    }

    public void isSubcategoriesDisplay(boolean isDisplay) {
        try {

            //TO DO

        }catch(Exception e){
            throw e;
        }finally {
            driver.manage().timeouts().implicitlyWait(serverTimeout, TimeUnit.SECONDS);
        }

    }


    public void filterBySize(String size){

        //TO DO

    }

    public void filterByCategoryRandomly(){
        try {

            //TO DO

        }
        catch (Exception ex) {
            throw ex;
        }

    }

    public void filterBySizeRandomly(){
        try {

            //TO DO

        }

        catch (Exception ex){
            throw ex;
        }
    }

    public void filterByColorRandomly(){
        try {

            //TO DO

        }
        catch (Exception ex){
            throw ex;
        }
    }

    public boolean isElementNotExist(By elementLocation) {
        try {

            //TO DO
            return true;

        } catch (Exception ex) {
            driver.manage().timeouts().implicitlyWait(serverTimeout, TimeUnit.SECONDS);
            return false;
        }
    }
}
