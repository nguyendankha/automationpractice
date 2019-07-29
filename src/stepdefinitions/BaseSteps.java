package stepdefinitions;

import objects.Customer;
import pages.*;

import java.math.BigDecimal;

public class BaseSteps {

    static PageController webapp = TestConfiguration.getWebapp();

    static Customer customer;
    static HomePage homePage = webapp.getHomePage();
    static LoginPage loginPage = webapp.getLoginPage();
    static MyAccountPage myAccountPage = webapp.getMyAccountPage();
    static SearchPage searchPage = webapp.getSearchPage();
    static CategoryPage categoryPage = webapp.getCategoryPage();
    static CreateAccountPage createAccountPage = webapp.getCreateAccountPage();
    static HeaderContainer headerContainer = webapp.getHeaderContainer();
    static ProductQuickView productQuickView = webapp.getProductQuickView();
    static ProductDetailsView productDetailsView = webapp.getProductDetailsView();
    static AddToCart addToCart = webapp.getAddToCart();
    static ShoppingCart shoppingCart = webapp.getsShoppingCart();
    static ContactUsPage contactUsPage = webapp.getContactUsPage();

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        BaseSteps.customer = customer;
    }

    public BaseSteps(){
        webapp = TestConfiguration.getWebapp();
    }

    public static PageController getWebapp() {
        return webapp;
    }

    public static HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage() {
        this.homePage = webapp.getHomePage();
    }

    public static LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage() {
        this.loginPage = webapp.getLoginPage();
    }

    public static MyAccountPage getMyAccountPage() {
        return myAccountPage;
    }

    public void setMyAccountPage() {
        this.myAccountPage = webapp.getMyAccountPage();
    }

    public static SearchPage getSearchPage() {
        return searchPage;
    }

    public void setSearchPage() {
        this.searchPage = webapp.getSearchPage();
    }

    public static CategoryPage getCategoryPage() {
        return categoryPage;
    }

    public void setCategoryPage() {
        this.categoryPage = webapp.getCategoryPage();
    }

    public static CreateAccountPage getCreateAccountPage() {
        return createAccountPage;
    }

    public void setCreateAccountPage() {
        this.createAccountPage = webapp.getCreateAccountPage();
    }

    public static HeaderContainer getHeaderContainer() {
        return headerContainer;
    }

    public void setHeaderContainer() {
        this.headerContainer = webapp.getHeaderContainer();
    }

    public static ProductQuickView getProductQuickView() {
        return productQuickView;
    }

    public void setProductQuickView() {
        this.productQuickView = webapp.getProductQuickView();
    }

    public static ProductDetailsView getProductDetailsView() {
        return productDetailsView;
    }

    public void setProductDetailsView() { this.productDetailsView = webapp.getProductDetailsView(); }

    public static AddToCart getAddToCart(){return addToCart;}

    public void setAddToCart(){addToCart = webapp.getAddToCart();}

    public static ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart() { this.shoppingCart = webapp.getsShoppingCart(); }

}
