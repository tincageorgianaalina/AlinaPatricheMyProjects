package alinatinca.UITestingPlayground.tests;

import alinatinca.UITestingPlayground.BaseTest;
import alinatinca.UITestingPlayground.pageObjects.LoadDelayLinkPage;
import org.testng.annotations.Test;

public class LoadDelayLinkTest extends BaseTest {
    @Test(description = "verify that scenario from Load Delay web page is working")
    public void goToLoadDelayLinkTest(){
        chromeDriver.get("http://uitestingplayground.com/");
        LoadDelayLinkPage loadDelayLinkPage = new LoadDelayLinkPage(chromeDriver);
        loadDelayLinkPage.clickOnLoadDelayLink();
        System.out.println("Scenario has the following text: " + loadDelayLinkPage.getScenarioText().getText());
        loadDelayLinkPage.confirmationForButtonAppearingAfterDelay();
        System.out.println("The presence of the button has been checked on the page after delay!");
        System.out.println("Test passed!");
    }
}