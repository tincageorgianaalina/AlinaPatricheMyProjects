package alinatinca.Homework4.DisabledDynamicButtons.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DisabledDynamicButtonsConfirmationPAGE {

    //Create the required attributes for this test case
    ChromeDriver chromeDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    //Create the constructor that can define the required parameters for this test case
    public DisabledDynamicButtonsConfirmationPAGE(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(4));
        fluentWait = new FluentWait<WebDriver>(chromeDriver)
                .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(chromeDriver, this);
    }

    //Find the text on the page
    @FindBy(id = "buttonmessage")
    WebElement text;

    //Create a method that display the text for opening all buttons
    public String displayTextForClickAllButtons() {
        return text.getText();
    }
}