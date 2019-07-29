package stepdefinitions;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HeaderContainer;
import utilities.Log;

public class HeaderContainerSteps extends BaseSteps{

    public HeaderContainerSteps() {
    };

    @And("^I click the Sign In button$")
    public void iClickTheSignInButton() throws Throwable{
        try
        {
           headerContainer.click(By.cssSelector("div.header_user_info a"));
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @When("^I click the Sign out button$")
    public void iClickTheSignOutButton() throws Throwable {
        try{
            //TO DO
        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I can see the Header container$")
    public void iCanSeeTheHeaderContainer() throws Throwable {
        try{
            //TO DO
        }
        catch (Exception e){
            throw e;
        }
    }

    @When("^I click the (.*) menu$")
    public void iClickTheMenu(String arg0) throws Throwable {
        try{
            //TO DO
        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I click on the submenu under (.*) menu$")
    public void iClickTheSubmenuUnderMenu(String arg0) throws Throwable {
        try{
            //TO DO
        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I click on the logo in the header container$")
    public void iClickOnTheLogoInTheHeaderContainer() throws Throwable {
        try{
            //TO DO
        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I hover on the shopping cart dropdown list$")
    public void iHoverOnTheShoppingCartDropdownList() throws Throwable {
        try{
            //TO DO
        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I click Proceed to Checkout button$")
    public void iClickProceedToCheckoutButton() throws Throwable {
        try{
            headerContainer.clickProceedToCheckout();
        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I remove (.*) from shopping cart dropdown list$")
    public void iRemoveAnyProductFromShoppingCartDropdownList(String arg0) throws Throwable {
        try{
            switch (arg0){
                case "any product":
                    headerContainer.removeItemInShoppingCartHeader();
                    break;
                case "all products":
                    headerContainer.removeAllShoppingItemsOnTheHeaderIfAny();
                    break;
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I navigate to another website$")
    public void iNavigateToAnotherWebsite() throws Throwable {
        try{
            headerContainer.navigateToAnotherWebsite();
        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I can see the item count in the shopping cart dropdown list retain after reopen website$")
    public void iCanSeeTheItemCountInTheShoppingCartDropdownListRetainAfterReopenWebsite() throws Throwable {
        try{
            headerContainer.isTheShoppingCartRetain();
        }
        catch (Exception e){
            throw e;
        }
    }

    @And("^I click on the Shopping cart dropdown list$")
    public void iClickOnTheShoppingCartDropdownList() throws Throwable {
        try
        {
            headerContainer.clickShoppingCartDropDownList();
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @And("^I click on the user button on the header$")
    public void iClickOnTheUserButtonOnTheHeader() throws Throwable {
        try
        {
            headerContainer.clickUserAccountButton();
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
