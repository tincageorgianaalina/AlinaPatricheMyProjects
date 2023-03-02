package alinatinca.Homework1.DemoqaWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.DemoqaWebPage.pageObjects.ButtonsPAGE;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    String URL = "https://demoqa.com/elements";

    @Test(description = "verify how to the simple button is clicked")
    public void clickMeButtonTest(){
        chromeDriver.get(URL);
        System.out.println("Navigate to Demoqa Elements page");
//        ((JavascriptExecutor) chromeDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //scroll down the page to the end of the page
        chromeDriver.get("https://demoqa.com/buttons");
        System.out.println("Go to Buttons category");
        ButtonsPAGE buttonsPAGE = new ButtonsPAGE(chromeDriver);
        System.out.println("Go to Buttons category");
        buttonsPAGE.clickOnMeButton();
        System.out.println("Click on clickMe button");
        Assert.assertEquals(buttonsPAGE.getMessageConfirmationForClickMeButton().getText(),
                "You have done a dynamic click",
                "The confirmation message is not displayed on the page ");
        System.out.println("The confirmation message has been checked; it is displayed on the page!");
    }

    @Test(description = "verify how to right click on button")
    public void rightClickMeButtonTest(){
        chromeDriver.get(URL);
        System.out.println("Navigate to Demoqa Elements page");
        chromeDriver.get("https://demoqa.com/buttons");
        System.out.println("Go to Buttons category");
        ButtonsPAGE buttonClickMePAGE = new ButtonsPAGE(chromeDriver);
        buttonClickMePAGE.rightClickMeButton();
        System.out.println("Click on rightClickMe button");
        Assert.assertEquals(buttonClickMePAGE.getMessageConfirmationForRightClickMeButton().getText(),
                "You have done a right click",
                "The confirmation message is not displayed on the page!");
        System.out.println("The confirmation message has been checked; it is displayed on the page!");
    }

    @Test(description = "verify how to double click on button")
    public void doubleClickMeButtonTest(){
        chromeDriver.get(URL);
        System.out.println("Navigate to Demoqa Elements page");
        chromeDriver.get("https://demoqa.com/buttons");
        System.out.println("Go to Buttons category");
        ButtonsPAGE buttonClickMePAGE = new ButtonsPAGE(chromeDriver);
        buttonClickMePAGE.doubleClickMeButton();
        System.out.println("Click on doubleClickMe button");
        Assert.assertEquals(buttonClickMePAGE.getMessageConfirmationForDoubleClickMeButton().getText(),
                "You have done a double click",
                "The confirmation message is not displayed on the page!");
        System.out.println("The confirmation message has been checked; it is displayed on the page!");
    }
}