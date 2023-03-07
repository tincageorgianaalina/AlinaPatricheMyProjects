package alinatinca.Homework2.HerokuWebPage.Alerts.FakeAlerts.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowModalDialogPAGE {

    ChromeDriver chromeDriver;

    public ShowModalDialogPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(xpath = "//p[text()='The following button will display a modal dialog when clicked. So you can also exit by clicking on the background.']")
    WebElement paragraphForFakeAlert;

    @FindBy(id = "modaldialog")
    WebElement fakeAlert;

    public WebElement getParagraphForFakeAlert() {
        return paragraphForFakeAlert;
    }

    public void clickOnFakeAlert() {
        fakeAlert.click();
    }

    public boolean isAlertAccepted(){
        Alert alert = chromeDriver.switchTo().alert();
        System.out.println("The fake alert has the following text: " + alert.getText());
        if(alert.getText().equalsIgnoreCase("I am a modal div!")){
            alert.accept();
            System.out.println("The fake alert is accepted!");
            return true;
        }else{
            System.out.println("The fake alert is dismissed!");
            return false;
        }
    }

    public boolean isAlertOpened(){
        try{
            chromeDriver.switchTo().alert();
            System.out.println("The fake alert remained opened!");
            return true;
        }catch (Exception e){
            return false;
        }
    }
}