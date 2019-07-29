package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CategoryPage;
import utilities.Log;

public class CategoryPageSteps extends BaseSteps{
    public CategoryPageSteps(){};

    @Then("^I can randomly apply one of Categories filter$")
    public void iCanSeeTheCategoriesFilterIsApplied() throws Throwable {
        try{

            //TO DO

        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I can randomly apply one of Size filter$")
    public void iRandomlySelectOneOfSizeFilter() throws Throwable {
        try{

            //TO DO

        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I can randomly apply one of Color filter$")
    public void iCanSeeTheSizeFilterIsApplied() throws Throwable {
        try{

            //TO DO

        }
        catch (Exception e){
            throw e;
        }
    }

    @Then("^I am on the (.*)'s subcategory page$")
    public void iAmOnTheSSubcategoryPage(String arg0) throws Throwable {
        try{

            //TO DO

        }
        catch (Exception e){
            throw e;
        }
    }

    @Then("^I am on the (.*) category page$")
    public void iAmOnTheCategoryPage(String arg0) throws Throwable {
        try{

            //TO DO

        }
        catch (Exception e){
            throw e;
        }
    }

}
