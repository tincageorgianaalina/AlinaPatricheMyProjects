package alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class ShowPromptBoxPAGE {

    ChromeDriver chromeDriver;

    public ShowPromptBoxPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(xpath = "//p[text()='The following button will display a prompt dialog when clicked.']")
    WebElement paragraph;

    @FindBy(id = "promptexample")
    WebElement alert;

    @FindBy(id = "promptexplanation")
    WebElement confirmationMessage;

    public WebElement getParagraph() {
        return paragraph;
    }

    public void getAlert() {
        alert.click();
    }

    public WebElement getConfirmationMessage() {
        return confirmationMessage;
    }

    public boolean isAcceptedAlert(){
        Alert alert1 = chromeDriver.switchTo().alert();
        System.out.println("Alert has the text: " + alert1.getText());
        if (alert1.getText().equalsIgnoreCase("I prompt you")){
            alert1.sendKeys("test");
            alert1.accept();
            System.out.println("Alert is accepted!");
            return true;
        }else {
            alert1.dismiss();
            System.out.println("Alert id dismissed!");
            return false;
        }
    }

    public boolean isAlertOpened(ChromeDriver chromeDriver){
        try{
            chromeDriver.switchTo().alert();
            System.out.println("Alert remained opened!");
            return true;
        }catch (Exception e){
            return  false;
        }
    }
}