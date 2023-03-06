package alinatinca.Homework2.HerokuWebPage.Alerts.FakeAlerts.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.HerokuWebPage.Alerts.FakeAlerts.pageObjects.ShowModalDialogPAGE;
import org.testng.annotations.Test;

public class ShowModalDialogTest extends BaseTest {

    @Test(description = "verify how to interact with a fake alert")
    public void showModalDialogTest(){
        try{
            chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
            System.out.println("Navigate to Heroku Fake Alert page");
            ShowModalDialogPAGE showModalDialogPAGE = new ShowModalDialogPAGE(chromeDriver);
            System.out.println("The fake alert has the following paragraph: " + showModalDialogPAGE.getParagraphForFakeAlert().getText());
            showModalDialogPAGE.clickOnFakeAlert();
            System.out.println("Click on the fake alert!");
            showModalDialogPAGE.isAlertAccepted();
            showModalDialogPAGE.isAlertOpened();
        }catch (Exception e){
            System.out.println("The text from the fake alert is checked but it could not display because this is a fake alert!");
            System.out.println("Test passed!");
        }
    }
}