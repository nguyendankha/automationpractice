package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PageController;
import utilities.DesiredCapsManager;
import utilities.DriverManager;
import utilities.JSWaiter;
import utilities.Log;

public class TestConfiguration {

    WebDriver driver;
    JSWaiter waiter;
    static PageController webapp;
    private DesiredCapsManager desiredCapsManager = new DesiredCapsManager();

    public static PageController getWebapp() {
        return webapp;
    }

    @Before
    public void configTestEnvironment(){
        String browser  = System.getenv("browser");
        String platform  = System.getenv("platform");
        String driverPath  = System.getenv("driverPath");
        Log.debug("Config Test Environment. Browser is: " + browser);
        Log.debug("Config Test Environment. Platform is: " + platform);
        //Get DesiredCapabilities
        DesiredCapabilities capabilities = desiredCapsManager.getDesiredCapabilities("chrome","window");
        //Create Driver with capabilities
        driver = new DriverManager(capabilities, "chrome", "F:\\").createDriver();
        webapp = new PageController(driver);
        waiter = new JSWaiter(driver);
    }

    @After
    public void tearDown() throws Exception {
        Log.debug("Close Browser");
        driver.quit();
    }

}
