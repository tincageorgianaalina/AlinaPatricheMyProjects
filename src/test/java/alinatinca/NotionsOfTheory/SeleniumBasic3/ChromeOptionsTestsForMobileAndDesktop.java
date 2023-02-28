package alinatinca.NotionsOfTheory.SeleniumBasic3;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeOptionsTestsForMobileAndDesktop {

    @Test(description = "verify how to emulate on mobile")
    public void mobileTest(){
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsForMobile();
        chromeDriver.get("https://demoqa.com/");
        chromeDriver.quit();
    }

    @Test(description = "verify how to emulate on desktop - start-maximized")
    public void desktopTest(){
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsForDesktop();
        chromeDriver.get("https://demoqa.com/");
        chromeDriver.quit();
    }

    @Test(description = "verify how to create the chrome driver instance - default resolution")
    public void desktopTestCreateChromeDriverInstance(){
        ChromeDriver chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/");
    }

    //Special case
    @Test(description = "verify how to run either on mobile or desktop to accept the insecure certs")
    public void  mobileOrDesktopSetAcceptInsecureCerts(){
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsForSetAcceptInsecureCertsUsedForMobileOrDesktop();
        chromeDriver.get("https://demoqa.com/");
        chromeDriver.quit();
    }

    //Special case
    @Test(description = "verify how to run on a special profile from pc")
    public void mobileOrDesktopRunOnSpecialProfile(){
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsUsedOnSpecialProfileOnMobileOrDesktop();
        chromeDriver.get("https://demoqa.com/");
        chromeDriver.quit();
    }
}