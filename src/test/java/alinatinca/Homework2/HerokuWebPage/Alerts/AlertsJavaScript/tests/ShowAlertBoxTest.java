package alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.pageObjects.ShowAlertBoxPAGE;
import org.testng.annotations.Test;

public class ShowAlertBoxTest extends BaseTest {

    @Test(description = "verify how to accept a simple alert", groups = {"desktop.H2", "mobile.H2"})
    public void showAlertBoxTest(){
        chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        System.out.println("Navigate to Heroku Alerts web page ");
        ShowAlertBoxPAGE showAlertBoxPAGE = new ShowAlertBoxPAGE(chromeDriver);
        System.out.println("The paragraph from the first alert is: " + showAlertBoxPAGE.getParagraph().getText());
        showAlertBoxPAGE.getAlert();
        showAlertBoxPAGE.isAlertOpened(chromeDriver);
        System.out.println("Test passed!");
    }
}