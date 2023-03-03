package alinatinca.Homework1.DemoqaWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPAGE {

    ChromeDriver chromeDriver;

    public ButtonsPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }
    //Create the constructor that can define the required parameters for this test case

    //Find the elements on the web page
    @FindBy(xpath = "//button[text()='Click Me']")
    WebElement clickMeButton;

    @FindBy(id = "dynamicClickMessage")
    WebElement confirmationMessageForClickMeButton;

    @FindBy(id = "rightClickBtn")
    WebElement rightClickMeButton;

    @FindBy(id = "rightClickMessage")
    WebElement confirmationMessageForRightClickMeButton;

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickMeButton;

    @FindBy(css = "#doubleClickMessage")
    WebElement confirmationMessageForDoubleClickMeButton;

    //Create methods for these elements
    public void clickOnMeButton(){
        clickMeButton.click();
    }

    public WebElement getMessageConfirmationForClickMeButton() {
        return confirmationMessageForClickMeButton;
    }

    public void rightClickMeButton() {
        Actions actions = new Actions(chromeDriver);
        actions.contextClick(rightClickMeButton).build().perform();
    }

    public WebElement getMessageConfirmationForRightClickMeButton() {
        return confirmationMessageForRightClickMeButton;
    }

    public void doubleClickMeButton() {
        Actions actions = new Actions(chromeDriver);
        actions.doubleClick(doubleClickMeButton).build().perform();
    }

    public WebElement getMessageConfirmationForDoubleClickMeButton() {
        return confirmationMessageForDoubleClickMeButton;
    }
}