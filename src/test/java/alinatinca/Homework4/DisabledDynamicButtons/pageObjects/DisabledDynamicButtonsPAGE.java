package alinatinca.Homework4.DisabledDynamicButtons.pageObjects;

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
public class DisabledDynamicButtonsPAGE {
    ChromeDriver chromeDriver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;

    //Create the constructor that can define the required parameters for this test case
    public DisabledDynamicButtonsPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(6));
        fluentWait = new FluentWait<WebDriver>(chromeDriver)
                .withTimeout(Duration.ofSeconds(7))
                .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(chromeDriver, this);
    }

    //Find the start button
    @FindBy(id="button00")
    WebElement startButton;

    //Create a method that click on start button
    public void clickOnStartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button00")));
        System.out.println("Wait some time until the first button can be clickable!");
        startButton.click();
        System.out.println("The first button has been opened!");
    }

    //Find the first button
    @FindBy(id="button01")
    WebElement firstButton;

    //Create a method that click on the one button
    public void clickOnFirstButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button01")));
        System.out.println("Wait some time until the first button can be clickable!");
        firstButton.click();
        System.out.println("The first button has been opened!");
    }

    //Find the second button
    @FindBy(id = "button02")
    WebElement secondButton;

    //Create a method that click on the second button
    public void clickOnSecondButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button02")));
        System.out.println("Wait some time until the second button can be clickable!");
        secondButton.click();
        System.out.println("The second button has been opened!");
    }

    //Find the third button
    @FindBy(id="button03")
    WebElement thirdButton;

    //Create a method that click on the third button
    public void clickOnThirdButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button03")));
        System.out.println("Wait some time until the third button can be clickable!");
        thirdButton.click();
        System.out.println("The third button has been opened!");
    }
}