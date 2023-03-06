package alinatinca.Homework2.HerokuWebPage.Windows.WindowsLinkTestPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class NewWindowMessagePAGE {

    ChromeDriver chromeDriver;

    public NewWindowMessagePAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }
}