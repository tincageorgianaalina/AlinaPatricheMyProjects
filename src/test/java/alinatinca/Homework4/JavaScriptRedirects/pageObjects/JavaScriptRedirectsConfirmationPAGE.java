package alinatinca.Homework4.JavaScriptRedirects.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptRedirectsConfirmationPAGE {

    ChromeDriver chromeDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    public JavaScriptRedirectsConfirmationPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(chromeDriver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(200));
    }

    @FindBy(id ="goback")
    WebElement goBackButton;

    public void clickOnGoBackButton() {
        goBackButton.click();
    }
}