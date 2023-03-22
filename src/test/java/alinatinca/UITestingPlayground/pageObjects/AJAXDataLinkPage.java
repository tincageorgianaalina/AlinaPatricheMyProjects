package alinatinca.UITestingPlayground.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AJAXDataLinkPage {

    ChromeDriver chromeDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    public AJAXDataLinkPage(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(15));
        fluentWait = new FluentWait<WebDriver>(chromeDriver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(200));
    }

    @FindBy(css = "a[href=\"/ajax\"]")
    WebElement ajaxDataLink;

    public void clickOnAjaxDataLink() {
        ajaxDataLink.click();
    }

    @FindBy(xpath = "//div[@class=\"container\"] / ul")
    WebElement scenarioText;

    public WebElement getScenarioText() {
        return scenarioText;
    }

    @FindBy(id = "ajaxButton")
    WebElement buttonTriggeringAJAXRequest;

    public void clickOnButtonTriggeringAJAXRequest() {
//        wait.until(ExpectedConditions.elementToBeClickable(buttonTriggeringAJAXRequest));
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        System.out.println("Wait some time until the button can be clickable!");
        buttonTriggeringAJAXRequest.click();
        System.out.println("This button has been clicked!");
    }

    @FindBy(id = "content")
    WebElement confirmationMessage;

    public void confirmationMessage() {
        Assert.assertTrue(confirmationMessage.isDisplayed(), "There is not any green message on the page as a confirmation message after the button has been clicked!");
        Assert.assertEquals(confirmationMessage.getText(), "Data loaded with AJAX get request.", "The green confirmation message has not this text!");
    }
}