package alinatinca.UITestingPlayground.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UITestingPlaygroundPage {

    ChromeDriver chromeDriver;

    public UITestingPlaygroundPage(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(xpath = "//a[text()='Progress Bar']")
    WebElement progressBarLink;

    public void clickOnProgressBarLink() {
        progressBarLink.click();
    }

    @FindBy(css = ".container ul")
    WebElement scenario;

    public WebElement getScenario() {
        return scenario;
    }

    @FindBy(css = "progress")
    WebElement progressBar;

    @FindBy(id = "startButton")
    WebElement startButton;

    public void clickOnStartButton() {
        startButton.click();
    }

    @FindBy(id = "stopButton")
    WebElement stopButton;

    public void clickOnStopButton() {
        stopButton.click();
    }

    @FindBy(id = "result")
    WebElement result;

    public WebElement getResult() {
        return result;
    }
}