package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

/**
 * Created by KYZU
 * Date: 9/1/2018
 * Time: 1:04 PM
 **/
public class DriverManager {

    public DesiredCapabilities caps = null;
    public String browser = null;
    public WebDriver driver = null;
    private String driverPath;

    public DriverManager(DesiredCapabilities capabilities, String browser, String driverPath) {
        this.caps = capabilities;
        this.browser = browser;
        this.driverPath = driverPath;
    }

    public WebDriver createDriver () {
        if (browser.equals("firefox")) {
            driver = new FirefoxDriver(caps);
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", this.driverPath + "chromedriver.exe");
            driver = new ChromeDriver(caps);
        } else {
            Assert.assertTrue(false,"There is a problem on browser selection! Please check testng xml file!");
        }
        return driver;
    }
}
