package alinatinca.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class BrowserManager {

    //create Chrome browser instance
    public static ChromeDriver createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    //create Egde browser instance
    public static EdgeDriver createEdgeDriver(){
        EdgeDriverManager.chromedriver().setup();
        return new EdgeDriver();
    }

    //create an emulation for desktop on the Chrome browser instance
    public static ChromeDriver createChromeDriverForDesktop(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    //create an emulation for mobile on the Edge browser instance
    public static ChromeDriver createChromeDriverForMobile(){
        Map<String, String> mobileEmulationOnChromeDriver = new HashMap<>();
        mobileEmulationOnChromeDriver.put("deviceName", "iPhone 12 Pro");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulationOnChromeDriver", mobileEmulationOnChromeDriver);
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    //create an emulation for desktop on the Edge browser instance
    public static EdgeDriver createEdgeDriverForDesktop(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        EdgeDriverManager.chromedriver().setup();
        return new EdgeDriver(options);
    }

    //create an emulation for mobile on the Edge browser instance
    public static EdgeDriver createEdgeDriverForMobile(){
        Map<String, String> mobileEmulationOnEdgeDriver = new HashMap<>();
        mobileEmulationOnEdgeDriver.put("deviceName","Samsung Galaxy S20 Ultra");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setExperimentalOption("mobileEmulationOnEdgeDriver", mobileEmulationOnEdgeDriver);
        EdgeDriverManager.chromedriver().setup();
        return new EdgeDriver(edgeOptions);
    }
}