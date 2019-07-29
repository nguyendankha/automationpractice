package stepdefinitions;

import cucumber.api.java.en.And;
import utilities.Log;

public class CommonSteps extends BaseSteps {

    public static String BASE_URL = "http://automationpractice.com";

    

    public CommonSteps() throws Exception{
    }

    @And("^I navigate to the homepage$")
    public void iNavigateToTheHomepage() throws Throwable {
        try {
            homePage.navigateToHomePage();
        } catch (Exception e) {
            throw e;
        }
    }
}
