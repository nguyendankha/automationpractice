package pages;
import objects.CommonBehaviors;
import org.openqa.selenium.WebDriver;

public class PageController extends BasePage{

	public PageController(WebDriver driver) {
		super(driver);
		setHomePage();
		setSearchPage();
		setLoginPage();
		setMyAccountPage();
		setHeaderContainer();
		setCreateAccountPage();
		setCategoryPage();
		setProductQuickView();
		setProductDetailsView();
		setAddToCart();
		setShoppingCart();
		setContactUsPage();
	}

	//Pages definition
	HomePage homePage;
	SearchPage searchPage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	HeaderContainer headerContainer;
	CreateAccountPage createAccountPage;
	CategoryPage categoryPage;
	ProductQuickView productQuickView;
	ProductDetailsView productDetailsView;
	AddToCart addToCart;
	ShoppingCart shoppingCart;
	ContactUsPage contactUsPage;

	public SearchPage getSearchPage() {
		return searchPage;
	}

	public void setSearchPage() {
		searchPage = new SearchPage(driver);
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public void setHomePage() {
		homePage = new HomePage(driver);
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public  void setLoginPage() {
		loginPage = new LoginPage(driver);
	}

	public MyAccountPage getMyAccountPage() {
		return myAccountPage;
	}

	public void setMyAccountPage() {
		myAccountPage = new MyAccountPage(driver);
	}

	public HeaderContainer getHeaderContainer()
	{
		return headerContainer;
	}

	public void setHeaderContainer()
	{
		headerContainer = new HeaderContainer(driver);
	}

	public CreateAccountPage getCreateAccountPage(){
		return createAccountPage;
	}

	public void setCreateAccountPage(){
		createAccountPage = new CreateAccountPage(driver);
	}

	public CategoryPage getCategoryPage() {
		return categoryPage;
	}

	public void setCategoryPage() {
		categoryPage = new CategoryPage(driver);
	}

	public ProductQuickView getProductQuickView() {
		return productQuickView;
	}

	public void setProductQuickView() {
		productQuickView = new ProductQuickView(driver);
	}

	public ProductDetailsView getProductDetailsView() {
		return productDetailsView;
	}

	public void setProductDetailsView() {
		productDetailsView = new ProductDetailsView(driver);
	}

	public AddToCart getAddToCart(){return addToCart;}

	public void setAddToCart(){addToCart = new AddToCart(driver);}

	public ShoppingCart getsShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart() {
		shoppingCart = new ShoppingCart(driver);
	}

	public ContactUsPage getContactUsPage(){return contactUsPage;}

	public void setContactUsPage(){contactUsPage = new ContactUsPage(driver);}
}
