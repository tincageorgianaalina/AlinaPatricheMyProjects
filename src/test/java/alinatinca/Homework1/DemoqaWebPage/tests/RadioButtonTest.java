package alinatinca.Homework1.DemoqaWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.DemoqaWebPage.pageObjects.RadioButtonPAGE;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    String URL = "https://demoqa.com/elements";

    @Test(description = "verify how to click on yes radio button")
    public void clickOnYesRadioButton(){
        chromeDriver.get(URL);
        System.out.println("Navigate to Demoqa Elements web page");
        RadioButtonPAGE radioButtonPAGE = new RadioButtonPAGE(chromeDriver);
        radioButtonPAGE.clickOnUrl();
        radioButtonPAGE.clickOnYesRadioButton();
        Assert.assertEquals(radioButtonPAGE.getConfirmationMessageForYesButton().getText(),
                "You have selected Yes",
                "The confirmation message is not displayed!");
    }

    @Test(description = "verify how to click on impressive radio button")
    public void clickOnImpressiveRadioButtonTest(){
        chromeDriver.get(URL);
        System.out.println("Navigate to Demoqa Elements web page");
        RadioButtonPAGE radioButtonPAGE = new RadioButtonPAGE(chromeDriver);
        radioButtonPAGE.clickOnUrl();
        radioButtonPAGE.clickOnImpressiveRadioButton();
        Assert.assertTrue(radioButtonPAGE.getGetConfirmationMessageForImpressiveButton().isDisplayed(),
                "he confirmation message is not displayed!");
        System.out.println("The confirmation message has been checked!");
    }
}