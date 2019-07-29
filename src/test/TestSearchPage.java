package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Log;

import java.util.List;

import static org.testng.Assert.*;

public class TestSearchPage extends TestBase {

    @BeforeTest
    public void navigateToSearchPage(){
        webApp.getHomePage().navigateToHomePage();
        webApp.getHomePage().isOnHomePage();
        webApp.getHeaderContainer().generateTextSearchWithRandomizedInformation();
        webApp.getHeaderContainer().clickSearchButton();
        webApp.getSearchPage().isOnSearchPage();
    }

    @Test (priority = 1)
    //Assignment 2: Test Case II.1: Verify if search components are displayed correctly
    public void verifySearchPageComponents() {
        String testCaseName = "TEST CASE  II.1: Verify if search components are displayed correctly";
        Log.info("TestSearchPage - " + testCaseName);

        //TO DO

    }

    @Test (priority = 2)
    //Assignment 2: Test Case II.2 + II.4: Verify if the View mode function on Search page and verify if number of row items display correctly
    public void verifyViewModeFunctionAndNumberOfRowItemsDisplay() {
        String testCaseName = "TEST CASE  II.2 + II.4: Verify if the View mode function on Search page work and verify if number of row items display correctly";
        Log.info("TestSearchPage - " + testCaseName);

        //TO DO

    }

    @Test (priority = 3)
    //Assignment 2: Test Case II.3: Check Sort by function
    public void checkSearchResultSortBy() {
        String testCaseName = "TEST CASE  II.4: Check Sort by function";
        Log.info("TestSearchPage - " + testCaseName);

        //TO DO

    }

}