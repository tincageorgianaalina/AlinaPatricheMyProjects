package alinatinca.UITestingPlayground;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ChromeDriver chromeDriver;

    @BeforeMethod
    public void createChromeDriver(){
        chromeDriver = BrowserManager.createChromeDriverWithOptions();
    }

    @AfterMethod(alwaysRun = true)
    public void quitChromeDriver(){
        if(chromeDriver != null){
            chromeDriver.quit();
        }
    }
}