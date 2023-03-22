package alinatinca.UITestingPlayground.tests;

import alinatinca.UITestingPlayground.BaseTest;
import alinatinca.UITestingPlayground.pageObjects.TextInputLinkPage;
import org.testng.annotations.Test;

public class TextInputLinkTest extends BaseTest {

    @Test(description = "verify the scenario from Text Input page is working")
    public void goToTextInputLinkTest(){
        chromeDriver.get("http://uitestingplayground.com/");
        TextInputLinkPage textInputLinkPage = new TextInputLinkPage(chromeDriver);
        textInputLinkPage.clickOnTextInputLink();
        System.out.println("Scenario has the following text: " + textInputLinkPage.getScenarioText().getText());
        textInputLinkPage.inputInMyButtonField();
        textInputLinkPage.clickOnButtonThatShouldChangeInput();
        textInputLinkPage.assertInputValue();
        System.out.println("Test passed!");
    }
}