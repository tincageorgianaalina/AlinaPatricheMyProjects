package alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowAlertBoxPAGE {

    ChromeDriver chromeDriver;

    public ShowAlertBoxPAGE(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(xpath = "//p[text()='The following button will display an alert when clicked.']")
    WebElement paragraph;

    @FindBy(id = "alertexamples")
    WebElement alert;

    public WebElement getParagraph() {
        return paragraph;
    }

    public void getAlert() {
        alert.click();
        Alert alert1 = chromeDriver.switchTo().alert();
        System.out.println("The text from the simple alert box is: " + alert1.getText());
        alert1.accept();
        System.out.println("Alert is accepted!");
    }

    public boolean isAlertOpened(ChromeDriver chromeDriver) {
        try {
            chromeDriver.switchTo().alert();
            System.out.println("Alert remained opened!");
            return true;
        } catch (Exception | Error e) {
            return false;
        }
    }
}