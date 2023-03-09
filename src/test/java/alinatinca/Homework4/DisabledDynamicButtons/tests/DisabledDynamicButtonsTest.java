package alinatinca.Homework4.DisabledDynamicButtons.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework4.DisabledDynamicButtons.pageObjects.DisabledDynamicButtonsConfirmationPAGE;
import alinatinca.Homework4.DisabledDynamicButtons.pageObjects.DisabledDynamicButtonsPAGE;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledDynamicButtonsTest extends BaseTest {

    @Test(groups = {"desktop.H4", "mobile.H4"}, description = "verify that the message is displayed after the buttons are clickable")
    public void clickOnAllButtons() {
        try{
            chromeDriver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
            DisabledDynamicButtonsConfirmationPAGE disabledDynamicButtonConfirmationPage = new DisabledDynamicButtonsConfirmationPAGE(chromeDriver);
            Assert.assertEquals(disabledDynamicButtonConfirmationPage.displayTextForClickAllButtons(), "Click Buttons In Order");
            System.out.println("The message that appears before openening all the buttons is: " + disabledDynamicButtonConfirmationPage.displayTextForClickAllButtons());
            DisabledDynamicButtonsPAGE disabledDynamicButtonsPage = new DisabledDynamicButtonsPAGE(chromeDriver);
            disabledDynamicButtonsPage.clickOnStartButton();
            disabledDynamicButtonsPage.clickOnFirstButton();
            disabledDynamicButtonsPage.clickOnSecondButton();
            disabledDynamicButtonsPage.clickOnThirdButton();
        }catch (Exception e){
            DisabledDynamicButtonsConfirmationPAGE disabledDynamicButtonConfirmationPage = new DisabledDynamicButtonsConfirmationPAGE(chromeDriver);
            Assert.assertEquals(disabledDynamicButtonConfirmationPage.displayTextForClickAllButtons(), "All Buttons Clicked");
            System.out.println("The message that appears after opening all the buttons is: " + disabledDynamicButtonConfirmationPage.displayTextForClickAllButtons());
            System.out.println("Check was done successfully!");
        }
    }
}