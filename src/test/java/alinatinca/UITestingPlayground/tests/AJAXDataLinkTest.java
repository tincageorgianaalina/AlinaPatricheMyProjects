package alinatinca.UITestingPlayground.tests;

import alinatinca.UITestingPlayground.BaseTest;
import alinatinca.UITestingPlayground.pageObjects.AJAXDataLinkPage;
import org.testng.annotations.Test;

public class AJAXDataLinkTest extends BaseTest {

    @Test(description = "verify that scenario from AJAX Data web page is working")
    public void goToAjaxDataLinkTest(){
        chromeDriver.get("http://uitestingplayground.com/");
        AJAXDataLinkPage ajaxDataLinkPage = new AJAXDataLinkPage(chromeDriver);
        ajaxDataLinkPage.clickOnAjaxDataLink();
        System.out.println("Scenario has the following text: " + ajaxDataLinkPage.getScenarioText().getText());
        ajaxDataLinkPage.clickOnButtonTriggeringAJAXRequest();
        ajaxDataLinkPage.confirmationMessage();
        System.out.println("The presence of Button Triggering AJAX Request on the page has been checked!");
    }
}