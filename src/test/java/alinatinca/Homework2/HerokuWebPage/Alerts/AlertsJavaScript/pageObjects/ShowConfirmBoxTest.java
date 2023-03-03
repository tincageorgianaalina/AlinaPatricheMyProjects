package alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.pageObjects;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.HerokuWebPage.Alerts.AlertsJavaScript.tests.ShowConfirmBoxPAGE;
import org.testng.annotations.Test;

public class ShowConfirmBoxTest extends BaseTest {

    @Test(description = "verify how to accept and dismiss a bob alert")
    public void showConfirmBoxAlertTest(){
        chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        System.out.println("Navigate to Heroku Alerts web page ");
        ShowConfirmBoxPAGE showConfirmBoxPAGE = new ShowConfirmBoxPAGE(chromeDriver);
        System.out.println("The paragraph is: " + showConfirmBoxPAGE.getParagraph().getText());
        showConfirmBoxPAGE.clickOnAlert();
        showConfirmBoxPAGE.isAcceptedForConfirmationAlert();
        showConfirmBoxPAGE.isAlertOpened(chromeDriver);
        System.out.println("Test passed!");
    }
}
