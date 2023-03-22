package alinatinca.UITestingPlayground.tests;

import alinatinca.UITestingPlayground.BaseTest;
import alinatinca.UITestingPlayground.pageObjects.UITestingPlaygroundPage;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class ProgressBarLinkTest extends BaseTest {

    @Test(description = "verify how to go to the Progress Bar Link")
    public void goToProgressBarLink(){
        chromeDriver.get("http://uitestingplayground.com/");
        UITestingPlaygroundPage uiTestingPlaygroundPage = new UITestingPlaygroundPage(chromeDriver);
        uiTestingPlaygroundPage.clickOnProgressBarLink();
        System.out.println("This test has the following scenario: " + uiTestingPlaygroundPage.getScenario().getText());
        uiTestingPlaygroundPage.clickOnStartButton();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
        uiTestingPlaygroundPage.clickOnStopButton();
        System.out.println("After click on stop button, the result is: " + uiTestingPlaygroundPage.getResult().getText());
        System.out.println("Test passed!");
    }
}