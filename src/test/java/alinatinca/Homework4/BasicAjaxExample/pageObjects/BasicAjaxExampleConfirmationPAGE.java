package alinatinca.Homework4.BasicAjaxExample.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.DatagramChannel;
import java.time.Duration;

public class BasicAjaxExampleConfirmationPAGE {

    ChromeDriver chromeDriver;
    Wait<WebDriver> fluentWait;
    WebDriverWait wait;

    public BasicAjaxExampleConfirmationPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(chromeDriver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(200));
    }

    @FindBy(xpath = "//h1[text()='Processed Form Details']")
    WebElement titleFromNextPage;

    public String getTitleFromNextPage() {
        return titleFromNextPage.getText();
    }

    @FindBy(id = "_valueid")
    WebElement id;

    public String getCategoryID() {
        return id.getText();
    }

    @FindBy(id = "_valuelanguage_id")
    WebElement language_id;

    public String getCategoryLanguage() {
        return language_id.getText();
    }

    @FindBy(id = "back_to_form")
    WebElement goBackToTheFormButton;

    public void clickOnGoBackToTheFormButton() {
        goBackToTheFormButton.click();
    }
}