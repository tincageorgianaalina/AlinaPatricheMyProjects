package alinatinca.Homework4.BasicAjaxExample.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasicAjaxExamplePAGE {

    ChromeDriver chromeDriver;
    Wait<WebDriver> fluentWait;
    WebDriverWait wait;

    public BasicAjaxExamplePAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver,this);
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(chromeDriver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(200));
    }

    @FindBy(id = "combo1")
    WebElement category;

    @FindBy (id = "combo2")
    WebElement language;

    @FindBy(id = "ajaxBusy")
    WebElement waitIconOnThePage;

    @FindBy(className = "styled-click-button")
    WebElement submitButton;

    public void selectCategory(String categoryName) {
        Select category = new Select(this.category);
        category.selectByVisibleText(categoryName);
    }

    public void selectLanguage(String languageName) {
        wait.until(ExpectedConditions.invisibilityOf(waitIconOnThePage));
        fluentWait.until(ExpectedConditions.invisibilityOf(waitIconOnThePage));
        System.out.println("Wait some time until the page is loaded!");
        Select language = new Select(this.language);
        language.selectByVisibleText(languageName);
    }

    public void clickOnCodeInIT() {
        submitButton.click();
        System.out.println("Code In It button has been clicked!");
    }
}