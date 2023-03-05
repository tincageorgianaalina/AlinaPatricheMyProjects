package alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.pageObjects;

import alinatinca.Homework1.DemoqaWebPage.pageObjects.CheckBoxPAGE;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.testng.Assert;

public class ShowConfirmBoxPAGE {

    ChromeDriver chromeDriver;

    public ShowConfirmBoxPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(xpath = "//p[text()='The following button will display a confirm dialog when clicked.']")
    WebElement paragraph;

    @FindBy(id = "confirmexample")
    WebElement alert;

    @FindBy(id = "confirmexplanation")
    WebElement confirmationMessage;

    public WebElement getParagraph() {
        return paragraph;
    }

    public void clickOnAlert() {
        alert.click();
    }

    public WebElement getConfirmationMessage() {
        return confirmationMessage;
    }

    public boolean isAlertOpened(ChromeDriver chromeDriver){
        try{
            chromeDriver.switchTo().alert();
            System.out.println("Alert remained opened!");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isAcceptedForConfirmationAlert(){
        Alert alert1 = chromeDriver.switchTo().alert();
        System.out.println("The text from alert box is: " + alert1.getText());
        if(alert1.getText().equalsIgnoreCase("I am a confirm alert")){
            alert1.accept();
            System.out.println("Alert is accepted!");
            Assert.assertTrue(confirmationMessage.isDisplayed(), "The confirmation message is not displayed");
            System.out.println("The confirmation message is checked; it has been displayed on the page: " + getConfirmationMessage().getText());
            return true;

        }else{
            alert1.dismiss();
            System.out.println("Alert is dismissed");
            Assert.assertTrue(confirmationMessage.isDisplayed(), "The confirmation message is not displayed");
            System.out.println("The confirmation message is checked; it has been displayed on the page: " + getConfirmationMessage().getText());
            return false;
        }
    }
}