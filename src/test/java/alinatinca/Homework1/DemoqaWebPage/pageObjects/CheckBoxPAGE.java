package alinatinca.Homework1.DemoqaWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPAGE {

    ChromeDriver chromeDriver;

    public CheckBoxPAGE (ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(className = "main-header")
    WebElement title;

    @FindBy (css = ".element-list.collapse.show .menu-list > li:nth-child(2) ")
    WebElement URL;

    @FindBy(css = ".rct-checkbox")
    WebElement checkBoxHomeButton;

    public WebElement getTitle() {
        return title;
    }

    public void clickOnUrl() {
        URL.click();
    }

    public void clickOnBoxHomeButton() {
       checkBoxHomeButton.click();
       System.out.println("Submit button has been clicked!");
    }
}