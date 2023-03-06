package alinatinca.Homework2.HerokuWebPage.Windows.WindowsLinkTestPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.HerokuWebPage.Windows.WindowsLinkTestPage.pageObjects.NewWindowPAGE;
import org.testng.annotations.Test;

import javax.swing.*;

public class NewWindowTest extends BaseTest {

    @Test(description = "verify how to interact with a new window")
    public void getNewWindowTest(){
        chromeDriver.get("https://demoqa.com/browser-windows");
        System.out.println("Navigate to Demoqa Browser Windows page!");
        NewWindowPAGE newWindowPAGE = new NewWindowPAGE(chromeDriver);
        newWindowPAGE.getNewWindow();
        System.out.println("Test passed!");
    }
}