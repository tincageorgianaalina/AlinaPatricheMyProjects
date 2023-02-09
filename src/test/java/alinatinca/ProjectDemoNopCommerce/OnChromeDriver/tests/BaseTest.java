package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.tests;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver chromeDriver;

    @BeforeMethod
    public void createChromeDriverForDesktop(){
        chromeDriver = BrowserManager.createChromeDriverForDesktop();
    }

    @BeforeMethod
    public void createChromeDriverForMobile(){
        chromeDriver = BrowserManager.createChromeDriverForMobile();
    }

    @AfterMethod
    public void quitDriver(){
        chromeDriver.quit();
    }
}