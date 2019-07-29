package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utilities.Log;

public class HomePageSteps extends BaseSteps{


    public HomePageSteps() {
    };

    @And("^I am on the Home Page$")
    public void iAmOnTheHomePage() throws Throwable{
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @And("^I can see the Hero images displayed$")
    public void iCanSeeTheHeroImagesDisplayed() throws Throwable {
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @And("^I can see the Hero images auto slided$")
    public void iCanSeeTheHeroImagesAutoSlided() throws Throwable {
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Then("^I can see the (.*) image$")
    public void iCanSeeTheNextOrPreviousImage(String arg0) throws Throwable {
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @When("^I click on the (.*) button on the Hero images carousel$")
    public void iClickOnTheButtonOnTheHeroImagesCarousel(String arg0) throws Throwable {
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
