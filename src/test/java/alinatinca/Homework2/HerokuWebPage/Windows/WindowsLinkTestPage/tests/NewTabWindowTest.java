package alinatinca.Homework2.HerokuWebPage.Windows.WindowsLinkTestPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.HerokuWebPage.Windows.WindowsLinkTestPage.pageObjects.NewTabWindowPAGE;
import org.testng.annotations.Test;

public class NewTabWindowTest extends BaseTest {

    @Test(description = "verify how to interact with a new tab")
    public void newTabWindowTest(){
        chromeDriver.get("https://demoqa.com/browser-windows");
        System.out.println("Navigate to Demowa Browser Windows page!");
        NewTabWindowPAGE newTabWindowPAGE = new NewTabWindowPAGE(chromeDriver);
        newTabWindowPAGE.getNewTabWindow();
        System.out.println("Test passed!");
    }
}