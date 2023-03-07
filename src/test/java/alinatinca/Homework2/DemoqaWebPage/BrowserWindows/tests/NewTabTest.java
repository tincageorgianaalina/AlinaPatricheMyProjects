package alinatinca.Homework2.DemoqaWebPage.BrowserWindows.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.DemoqaWebPage.BrowserWindows.pageObjects.NewTabPAGE;
import org.testng.annotations.Test;

public class NewTabTest extends BaseTest {

    @Test(description = "verify how to interact with a new tab", groups = {"desktop.H2", "mobile.H2"})
    public void newTabWindowTest(){
        chromeDriver.get("https://demoqa.com/browser-windows");
        System.out.println("Navigate to Demowa Browser Windows page!");
        NewTabPAGE newTabWindowPAGE = new NewTabPAGE(chromeDriver);
        newTabWindowPAGE.getNewTabWindow();
        System.out.println("Test passed!");
    }
}