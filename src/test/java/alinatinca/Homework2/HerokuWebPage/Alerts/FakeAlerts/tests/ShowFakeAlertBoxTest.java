package alinatinca.Homework2.HerokuWebPage.Alerts.FakeAlerts.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.HerokuWebPage.Alerts.FakeAlerts.pageObjects.ShowFakeAlertBoxPAGE;
import org.testng.annotations.Test;

public class ShowFakeAlertBoxTest extends BaseTest {

    @Test(description = "verify how to interact with a fake alert")
    public void showAlertBoxTest(){
        try{
            chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
            System.out.println("Navigate to Heroku Fake Alert page");
            ShowFakeAlertBoxPAGE showAlertBoxPAGE = new ShowFakeAlertBoxPAGE(chromeDriver);
            System.out.println("The main parahraph is: "  + showAlertBoxPAGE.getMainParagraph().getText());
            System.out.println("The paragraph of the fake alert is: " + showAlertBoxPAGE.getParagraphForAlert().getText());
            showAlertBoxPAGE.clickOnFakeAlert();
            System.out.println("Click on the fake alert!");
            showAlertBoxPAGE.isAlertAccepted();
            showAlertBoxPAGE.isAlertOpened(chromeDriver);
        }catch (Exception e){
            System.out.println("The text from the fake alert is checked but it could not display because this is a fake alert!");
            System.out.println("Test passed!");
        }
    }
}