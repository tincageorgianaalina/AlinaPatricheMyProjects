package alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.pageObjects.ShowAlertBoxPAGE;
import alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.pageObjects.ShowConfirmBoxPAGE;
import alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.pageObjects.ShowPromptBoxPAGE;
import org.testng.annotations.Test;

import javax.sound.midi.SysexMessage;

public class ShowPromptBoxTest extends BaseTest {

    @Test(description = "verify how to accept or dismiss a alert with text")
    public void showPromptBoxAlert(){
        chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        System.out.println("Navigate to Heroku Alerts web page");
        ShowPromptBoxPAGE showPromptBoxPAGE = new ShowPromptBoxPAGE(chromeDriver);
        System.out.println("The paragraph is: " + showPromptBoxPAGE.getParagraph().getText());
        showPromptBoxPAGE.getAlert();
        showPromptBoxPAGE.isAcceptedAlert();
        showPromptBoxPAGE.isAlertOpened(chromeDriver);
        System.out.println("The confirmation message is: " + showPromptBoxPAGE.getConfirmationMessage().getText());
        System.out.println("Test passed!");
    }
}