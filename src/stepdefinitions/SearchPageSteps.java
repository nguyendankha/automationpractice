package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.HeaderContainer;
import utilities.Log;

import java.util.Random;

public class SearchPageSteps extends BaseSteps {
    public SearchPageSteps()
    {};

    private String[] keyword = new String[]{"Dress","Summer", "Short","White"};


    @When("^I input the Search keyword$")
    public void iInputTheSearchKeyword() throws Throwable {
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @And("^I click the Search button$")
    public void iClickTheSearchButton() throws Throwable {
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Then("^I am on the Search Page$")
    public void iAmOnTheSearchPage() throws Throwable {
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @And("^I can view search results$")
    public void iCanViewSearchResults() throws Throwable {
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Then("^I can view the search result by (.*)$")
    public void iCanViewTheSearchResultByList(String arg0) throws Throwable {
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @And("^I click the (.*) view button$")
    public void iClickTheGridViewButton(String arg0) throws Throwable {
        try
        {
            //TO DO
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @And("^I can see the number of row items display correctly in (.*) view$")
    public void iCanSeeTheNumberOfRowItemsDisplayCorrectlyInView(String arg0) throws Throwable {
        try
        {
            //TO DO

        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Given("^I can sort the products by (.*)$")
    public void iCanSortTheProductsBy(String arg0) throws Throwable {
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
