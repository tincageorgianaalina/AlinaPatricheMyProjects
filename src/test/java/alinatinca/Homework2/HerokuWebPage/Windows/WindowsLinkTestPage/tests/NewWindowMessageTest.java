package alinatinca.Homework2.HerokuWebPage.Windows.WindowsLinkTestPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.HerokuWebPage.Windows.WindowsLinkTestPage.pageObjects.NewWindowMessagePAGE;

public class NewWindowMessageTest extends BaseTest {

    public void newWindowMessageTest(){
        chromeDriver.get("https://demoqa.com/browser-windows");
        NewWindowMessagePAGE newWindowMessagePAGE = new NewWindowMessagePAGE(chromeDriver);
    }
}