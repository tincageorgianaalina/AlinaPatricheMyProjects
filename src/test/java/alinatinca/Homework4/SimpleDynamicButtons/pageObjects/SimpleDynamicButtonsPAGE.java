package alinatinca.Homework4.SimpleDynamicButtons.pageObjects;

import org.openqa.selenium.By;
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

public class SimpleDynamicButtonsPAGE {
    ChromeDriver chromeDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    public SimpleDynamicButtonsPAGE(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(chromeDriver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(chromeDriver, this);
    }

    //Find the start button on the page
    @FindBy(id="button00")
    WebElement startButton;

    public void clickOnStartButton(){
        startButton.click();
        System.out.println("The start button has been opened!");
    }

    //Find the one button on the page
    @FindBy(id="button01")
    WebElement firstButton;

    public void clickOnFirstButton(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
        System.out.println("Wait some time until the first button can be clickable!");
        firstButton.click();
        System.out.println("The first button has been opened!");
    }

    //Find the second button
    @FindBy(id="button02")
    WebElement secondButton;

    public void clickOnSecondButton(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
//        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        System.out.println("Wait some time until the second button can be clickable!");
        secondButton.click();
        System.out.println("The second button has been opened!");
    }

    //Find the third button
    @FindBy (id="button03")
    WebElement thirdButton;

    public void clickOnThirdButton(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        System.out.println("Wait some time until the third button can be clickable!");
        thirdButton.click();
        System.out.println("The third button has been opened!");
    }
}