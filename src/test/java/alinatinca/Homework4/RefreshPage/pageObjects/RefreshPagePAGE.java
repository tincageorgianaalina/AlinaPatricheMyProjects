package alinatinca.Homework4.RefreshPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RefreshPagePAGE {

    ChromeDriver chromeDriver;
    WebDriverWait wait;

    public RefreshPagePAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(id = "refreshdate")
    WebElement refreshButton;

    public String getStatusForTimestamp() {
        return refreshButton.getText();
    }
}