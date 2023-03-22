package alinatinca.UITestingPlayground.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TextInputLinkPage {

    ChromeDriver chromeDriver;

    public TextInputLinkPage(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(css = "a[href=\"/textinput\"]")
    WebElement textInputLink;

    public void clickOnTextInputLink() {
        textInputLink.click();
    }

    @FindBy(css = "[class = 'container'] > ul")
    WebElement scenarioText;

    public WebElement getScenarioText() {
        return scenarioText;
    }

    @FindBy(id = "newButtonName")
    WebElement myButtonInputValue;

    public void inputInMyButtonField() {
        myButtonInputValue.click();
        myButtonInputValue.sendKeys("Alina");
    }

    @FindBy(id = "updatingButton")
    WebElement buttonThatShouldChangeInput;

    public void clickOnButtonThatShouldChangeInput() {
        buttonThatShouldChangeInput.click();
    }

    public void assertInputValue(){
        Assert.assertTrue(buttonThatShouldChangeInput.isDisplayed(), "Button with Alina input value does not displayed on the page!");
        Assert.assertEquals(buttonThatShouldChangeInput.getText(), "Alina", "This button does not have Alina input value!");
    }
}