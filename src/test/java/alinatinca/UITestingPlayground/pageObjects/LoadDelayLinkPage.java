package alinatinca.UITestingPlayground.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoadDelayLinkPage {

    ChromeDriver chromeDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    public LoadDelayLinkPage(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(chromeDriver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(200));
    }

    @FindBy(css = "a[href=\"/loaddelay\"]")
    WebElement loadDelayLink;

    public void clickOnLoadDelayLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loadDelayLink));
        System.out.println("Wait some time until the Load Delay Link can be clickable!");
        loadDelayLink.click();
        System.out.println("The link has been opened!");
    }

    @FindBy(css = "[class=\"container\"] > ul")
    WebElement scenarioText;

    public WebElement getScenarioText() {
        return scenarioText;
    }

    @FindBy(className = "btn-primary")
    WebElement buttonAppearingAfterDelay;

    public void confirmationForButtonAppearingAfterDelay() {
        Assert.assertTrue(buttonAppearingAfterDelay.isDisplayed(), "This button is not displayed on the page!");
        Assert.assertEquals(buttonAppearingAfterDelay.getText(), "Button Appearing After Delay", "This Button does not show any message!");
    }
}