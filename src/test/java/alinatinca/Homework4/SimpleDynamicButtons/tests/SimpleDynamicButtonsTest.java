package alinatinca.Homework4.SimpleDynamicButtons.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework4.SimpleDynamicButtons.pageObjects.SimpleDynamicButtonsConfirmationPAGE;
import alinatinca.Homework4.SimpleDynamicButtons.pageObjects.SimpleDynamicButtonsPAGE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDynamicButtonsTest extends BaseTest {

    @Test(groups = {"desktop.H4", "mobile.H4"}, description = "verify that the message is displayed after the buttons are clickable")
    public void checkClickOnAllButtons(){
        try{
            chromeDriver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");
            System.out.println("Navigate to Simple Dynamic Buttons web page");
            SimpleDynamicButtonsConfirmationPAGE simpleDynamicButtonConfirmationPage = new SimpleDynamicButtonsConfirmationPAGE(chromeDriver);
            Assert.assertEquals(simpleDynamicButtonConfirmationPage.displayTextForClickAllButtons(), "Click all 4 buttons.");
            System.out.println("The message that appears before openening all the buttons is: " + simpleDynamicButtonConfirmationPage.displayTextForClickAllButtons());
            SimpleDynamicButtonsPAGE simpleDynamicButtonsPAGE = new SimpleDynamicButtonsPAGE(chromeDriver);
            simpleDynamicButtonsPAGE.clickOnStartButton();
            simpleDynamicButtonsPAGE.clickOnFirstButton();
            simpleDynamicButtonsPAGE.clickOnSecondButton();
            simpleDynamicButtonsPAGE.clickOnThirdButton();
        }catch (Exception e){
            SimpleDynamicButtonsConfirmationPAGE simpleDynamicButtonConfirmationPage = new SimpleDynamicButtonsConfirmationPAGE(chromeDriver);
            Assert.assertEquals(simpleDynamicButtonConfirmationPage.displayTextForClickAllButtons(), "All Buttons Clicked");
            System.out.println("The message that appears after opening all the buttons is: " + simpleDynamicButtonConfirmationPage.displayTextForClickAllButtons());
            System.out.println("Test passed!");
        }
    }
}