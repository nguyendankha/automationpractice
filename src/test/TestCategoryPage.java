package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HeaderContainer;
import utilities.Log;
import pages.HomePage;

import java.util.List;

import static org.testng.Assert.*;

public class TestCategoryPage extends TestBase {

    //Clicking on each category sequentially and verify them.
    @Test (priority = 1)
    public void asAUserIWantToSelectEachCategorySequentially() throws Exception{
        String testCaseName = "Step#1 - II.1 as A User I Want To Select Each Category Sequentially";
        Log.debug("CategoryPageTest - " + testCaseName);

        //TO DO

    }
}