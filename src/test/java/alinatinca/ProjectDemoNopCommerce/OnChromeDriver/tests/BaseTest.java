package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.tests;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public ChromeDriver chromeDriver = null;

    @BeforeClass
    public void createChromeDriver(){
        chromeDriver = BrowserManager.createChromeDriverWithOptions();
    }

//    @BeforeMethod
//    public void createChromeDriverForDesktop(){
//        chromeDriver = BrowserManager.createChromeDriverForDesktop();
//    }

//    @BeforeMethod
//    public void createChromeDriverForMobile(){
//        chromeDriver = BrowserManager.createChromeDriverForMobile();
//    }

    @AfterClass(alwaysRun = true)
    public void quitDriver(){
        if(chromeDriver != null) {
            chromeDriver.quit();
        }
    }

    //define here this method to be called everytime it is needed
    protected FluentWait<ChromeDriver> getFluentWait(ChromeDriver chromeDriver){
        FluentWait<ChromeDriver> fluentWait = new FluentWait<>(chromeDriver);
        fluentWait.withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500));
        return fluentWait;
    }
}