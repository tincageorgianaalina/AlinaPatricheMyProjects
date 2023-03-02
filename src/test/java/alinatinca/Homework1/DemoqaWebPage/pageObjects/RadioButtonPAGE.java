package alinatinca.Homework1.DemoqaWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPAGE {

    ChromeDriver chromeDriver;

    public RadioButtonPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver,this);
    }

    @FindBy (css = ".element-list.collapse.show .menu-list > li:nth-child(3) ")
    WebElement URL;

    @FindBy(css = "label[for='yesRadio']")
    WebElement yesRadioButton;

    @FindBy(css = ".mt-3")
    WebElement confirmationMessageForYesButton;

    @FindBy(css = "label[for='impressiveRadio']")
    WebElement impressiveRadioButton;

    @FindBy(css = ".mt-3")
    WebElement confirmationMessageForImpressiveButton;

    public void clickOnUrl() {
        URL.click();
        System.out.println("Go to Radio Button category");
    }

    public void clickOnYesRadioButton() {
        yesRadioButton.click();
        System.out.println("Click on yes radio button!");
    }

    public WebElement getConfirmationMessageForYesButton() {
        return confirmationMessageForYesButton;
    }

    public void clickOnImpressiveRadioButton(){
        impressiveRadioButton.click();
        System.out.println("Click on impressive radio button!");
    }

    public WebElement getGetConfirmationMessageForImpressiveButton() {
        return confirmationMessageForImpressiveButton;
    }
}