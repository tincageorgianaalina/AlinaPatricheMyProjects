package alinatinca.NotionsOfTheory.TestNG;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethodsAndAfterMethods {
// Before Methods are used to initialize some configures before the tests run
// After Methods are used to do something after the tests are run

    ChromeDriver chromeDriver;

    //Example: create the browser Chrome instance before the test is run
    @BeforeMethod
    public void initializeBrowserChromeInstance(){
        chromeDriver = BrowserManager.createChromeDriver();
    }

    //Example: close the browser Chrome instance after the test is run
    @AfterMethod(alwaysRun = true) //regardless of whether the text is run or not
    public void quitBrowserChromeInstance(){
        if(chromeDriver != null){
            chromeDriver.quit();
        }
    }

    @Test
    public void goToURLTest(){
        chromeDriver.get("https://demoqa.com/");
    }




}
