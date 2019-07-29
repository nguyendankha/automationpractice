package test;

import net.bytebuddy.build.ToStringPlugin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Log;

import static org.testng.Assert.*;

public class TestHomePage extends TestBase{

    @BeforeTest
    public void navigateToHomePage(){
        //Access to Home page
        webApp.getHomePage().navigateToHomePage();
        webApp.getHomePage().isOnHomePage();
    }

    @Test(priority = 1)
    //Assignment 2: Hero Image - Test case I.1: Verify if Hero images are displayed in the Home page carousel
    public void verifyHeroImagesDisplayed() {
        String testCaseName = "TEST CASE  I.1: Verify if Hero images are displayed in the Home page carousel";
        Log.info("TestHeroImage - " + testCaseName);

        //TO DO

    }

    @Test(priority = 2)
    //Assignment 2: Hero Image - Test case I.3: Verify if auto slider function works correctly
    public void verifyAutoSliderWorksCorrectly() {
        String testCaseName = "TEST CASE  I.3: Verify if auto slider function works correctly";
        Log.info("TestHeroImage - " + testCaseName);

        //TO DO

    }

    @Test(priority = 3)
    //Assignment 2: Hero Image - Test case I.2: Verify clicking Previous/ Next slide works correctly
    public void verifyNextPreviousSlide() {
        String testCaseName = "TEST CASE  I.2: Verify clicking Previous/ Next slide works correctly";
        Log.info("TestHeroImage - " + testCaseName);

        //TO DO

    }
}