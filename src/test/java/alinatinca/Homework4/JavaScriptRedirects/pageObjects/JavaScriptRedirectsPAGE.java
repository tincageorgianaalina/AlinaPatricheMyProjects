package alinatinca.Homework4.JavaScriptRedirects.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class JavaScriptRedirectsPAGE {

    ChromeDriver chromeDriver;
    Wait<WebDriver> fluentWait;
    WebDriverWait wait;

    public JavaScriptRedirectsPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(chromeDriver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(200));
    }

    @FindBy(id = "delaygotobasic")
    WebElement firstButton;

    public void clickOnFirstButton() {
        firstButton.click();
        System.out.println("The first button is clicked!");
        wait.until(ExpectedConditions.invisibilityOf(firstButton));
        System.out.println("Wait some time until the first button can be clickable!");
        System.out.println("Condition has been executed and the first button has been clicked!");
    }

    @FindBy(id = "delaygotobounce")
    WebElement secondButton;

    public void clickOnSecondButton() {
        secondButton.click();
        System.out.println("The second button is clicked!");
        wait.until(ExpectedConditions.invisibilityOf(secondButton));
        System.out.println("Wait some time until the second button can be clickable!");
        System.out.println("Condition has been executed and the second button has been clicked!");
    }
}