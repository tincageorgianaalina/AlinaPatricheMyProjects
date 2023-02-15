package alinatinca.NotionsOfTheory;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public ChromeDriver chromeDriver = null;

    @BeforeMethod
    public void createChromeDriver(){
        chromeDriver = BrowserManager.createChromeDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void quitChromeDriver(){
        if(chromeDriver != null){
            chromeDriver.quit();
        }
    }
}