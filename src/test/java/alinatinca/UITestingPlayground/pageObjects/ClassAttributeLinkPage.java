package alinatinca.UITestingPlayground.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClassAttributeLinkPage {

    ChromeDriver chromeDriver;

    public ClassAttributeLinkPage(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(css = "a[href=\"/classattr\"]")
    WebElement classAttributeLink;

    public void clickOnClassAttribute() {
        classAttributeLink.click();
    }

    @FindBy(css = "[class='container'] > ul")
    WebElement scenarioText;

    public WebElement getScenarioText() {
        return scenarioText;
    }

    @FindBy(className = "btn-primary")
    WebElement blueButton;

    public void clickOnBlueButtonAndGetAlert() {
        blueButton.click();
        System.out.println("Click on blue Button!");
        Alert alert = chromeDriver.switchTo().alert();
        System.out.println("Alert has the following text: " + alert.getText());
        alert.accept();
        System.out.println("Alert is accepted!");
        blueButton.click();
        System.out.println("The blue Button can be identify using btn-primary class!");
    }
}