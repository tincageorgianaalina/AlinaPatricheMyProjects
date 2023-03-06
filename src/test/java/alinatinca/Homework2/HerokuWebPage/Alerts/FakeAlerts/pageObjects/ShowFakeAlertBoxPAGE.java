package alinatinca.Homework2.HerokuWebPage.Alerts.FakeAlerts.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowFakeAlertBoxPAGE {

    ChromeDriver chromeDriver;

    public ShowFakeAlertBoxPAGE(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(className = "explanation")
    WebElement mainParagraph;

    @FindBy(xpath = "//p[text()='The following button will display a fake alert when clicked.']")
    WebElement paragraphForAlert;

    @FindBy(id = "fakealert")
    WebElement fakeAlert;

    public WebElement getMainParagraph() {
        return mainParagraph;
    }

    public WebElement getParagraphForAlert() {
        return paragraphForAlert;
    }

    public void clickOnFakeAlert() {
        fakeAlert.click();
    }

    public boolean isAlertAccepted() {
        Alert alert = chromeDriver.switchTo().alert();
        System.out.println("The fake alert has the following text: " + alert.getText());
        if (alert.getText().equalsIgnoreCase("I am a fake alert box!")) {
            alert.accept();
            System.out.println("The fake alert is accepted!");
            return true;
        } else {
            System.out.println("The fake alert is dismissed!");
            return false;
        }
    }

    public boolean isAlertOpened(ChromeDriver chromeDriver){
        try{
            chromeDriver.switchTo().alert();
            System.out.println("The fake alert remained opened!");
            return true;
        } catch (Exception e){
            return  false;
        }
    }
}