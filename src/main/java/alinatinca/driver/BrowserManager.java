package alinatinca.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager {

    public static ChromeDriver createChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
