package alinatinca.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserManager {

    //emulation on desktop - create Chrome Driver instance
    public static ChromeDriver createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    //Emulation on desktop - "start-maximized"
    //addArgument("start-maximized")
    public static ChromeDriver getChromeDriverWithOptionsForDesktop(){
        ChromeOptions chromeOptions = new ChromeOptions();
        //creating a ChromOptions object
        chromeOptions.addArguments("start-maximized");
        //set fullscreen option
        WebDriverManager.chromedriver().setup();
        //initialize the chrome driver with options
        return  new ChromeDriver(chromeOptions);
    }

    //Emulation on mobile
    //Map: map.put("","")
    //setExperimentalOption("", map)
    public static ChromeDriver getChromeDriverWithOptionsForMobile(){
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, String> map = new HashMap<>();
        //Map stocks keys that are values, for example:
        //"Andrei"(key) -> "student"(value)
        //"Roxana"(key) -> "engineer"(value)
        //"Telephone"(key) -> "Samsung S20"
        map.put("deviceName", "iPhone X");
        chromeOptions.setExperimentalOption("mobileEmulation", map);
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }


    //Special case - used to accept the insecure certs for the intern web pages, used to run either on mobile or desktop
    //setAcceptInsecureCerts(true)
    public static ChromeDriver getChromeDriverWithOptionsForSetAcceptInsecureCertsUsedForMobileOrDesktop(){
        ChromeOptions chromeOptions = new ChromeOptions();
//        Map<String, String> map = new HashMap<>();
        //Map stocks keys that are values, for example:
        //"Andrei"(key) -> "student"(value)
        //"Roxana"(key) -> "engineer"(value)
        //"Telephone"(key) -> "Samsung S20"
//        map.put("deviceName", "iPhone X");
//        chromeOptions.addArguments("start-maximized");
        chromeOptions.setAcceptInsecureCerts(true);
        //used for accept the insecure certs for the intern web pages
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }


    //Special case - used to run on a special profile from pc, used to run either mobile or desktop
    //addArguments("user-data-dir: path")
    //addArguments("profile-directory: Profile 1-for example!")
    public static ChromeDriver getChromeDriverWithOptionsUsedOnSpecialProfileOnMobileOrDesktop(){
        ChromeOptions chromeOptions = new ChromeOptions();
//      Map<String, String> map = new HashMap<>();
        //Map stocks keys that are values, for example:
        //"Andrei"(key) -> "student"(value)
        //"Roxana"(key) -> "engineer"(value)
//      map.put("deviceName", "iPhone X");
//      chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("user-data-dir: ");
        //("user-data-dir: path of profile from pc")
        chromeOptions.addArguments("profile-directory: Profile 1-for example!");
        //which profile to run on
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }
}