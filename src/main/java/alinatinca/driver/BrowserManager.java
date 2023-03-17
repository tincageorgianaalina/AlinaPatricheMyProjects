package alinatinca.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserManager {

    public static ChromeDriver createChromeDriverWithOptions(){
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }
    //create this method to create the chrome driver instance for new version of Chrome browser

    public static ChromeDriver getChromeDriverWithOptionsForDesktop(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }
   // create this method to emulate it on desktop

    public static ChromeDriver getChromeDriverWithOptionsForMobile(){
        Map<String, String> map = new HashMap<>();
        map.put("deviceName", "iPhone X");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", map);
        return new ChromeDriver(chromeOptions);
    }
    //create this method to emulate it on iPhone X mobile
}