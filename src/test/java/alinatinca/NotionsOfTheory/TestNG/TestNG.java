package alinatinca.NotionsOfTheory.TestNG;

import alinatinca.NotionsOfTheory.SeleniumBasic2.BaseTest;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class TestNG extends BaseTest {

    //the first element of TestNG used on classes and methods!
    //For @Test on classes, it will run only the public methods, not the private methods;
    //But if the all methods are public, then each method will be ran in alphabetical order
    @Test
    public void Test3(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/");
        quitChromeDriver();
        throw new RuntimeException("Custom exception");
    }

    private static void Test2(){
        ChromeDriver chromeDriver;
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/forms");
        chromeDriver.quit();
    }

    public static void Test1(){
        ChromeDriver chromeDriver;
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/auto-complete");
        chromeDriver.quit();
    }
}