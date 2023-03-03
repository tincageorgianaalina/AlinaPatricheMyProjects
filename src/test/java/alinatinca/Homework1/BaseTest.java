package alinatinca.Homework1;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.management.Descriptor;

public class BaseTest {

   protected ChromeDriver chromeDriver;

    @BeforeMethod(groups = "desktop")
    public void createChromeDriverWithOptions(){
        chromeDriver = BrowserManager.getChromeDriverWithOptionsForDesktop();
    }
   // create this method to open chrome browser instance on desktop

//    @BeforeMethod(groups = "mobile")
//    public void  createChromeDriverForMobile(){
//        chromeDriver = BrowserManager.getChromeDriverWithOptionsForMobile();
//    }
//    //create this method to open chrome browser instance on mobile

    @AfterMethod(alwaysRun = true)
    public void quitChromeDriver(){
        if(chromeDriver != null){
            chromeDriver.quit();
        }
        System.out.println("Chrome instance has been closed!");
    }
    //create this method to close chrome browser instance
}