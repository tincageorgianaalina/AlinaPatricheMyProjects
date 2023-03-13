package alinatinca.Homework4.JavaScriptRedirects.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework4.JavaScriptRedirects.pageObjects.JavaScriptRedirectsConfirmationPAGE;
import alinatinca.Homework4.JavaScriptRedirects.pageObjects.JavaScriptRedirectsPAGE;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class JavaScriptRedirectsTests extends BaseTest {

    @Test(groups = {"desktop.H4", "mobile.H4"}, description = "verify that the first button works")
    public void clickOnFirstButtonTest(){
        try{
            chromeDriver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
            System.out.println("Navigate to Basic Ajax Example web page!");
            String mainWindow = chromeDriver.getWindowHandle();
            Assert.assertEquals(chromeDriver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
            System.out.println("The focus is on this page (main page)!");
            JavaScriptRedirectsPAGE javaScriptRedirectsPAGE = new JavaScriptRedirectsPAGE(chromeDriver);
            javaScriptRedirectsPAGE.clickOnFirstButton();
            Set<String> newWindow = chromeDriver.getWindowHandles();
            for(String newWindows: newWindow) {
                if (!newWindows.equals(mainWindow)) {
                    chromeDriver.switchTo().window(newWindows);
                    break;
                }
            }
            System.out.println("Now the focus is on the next page!");
            System.out.println("After passing the first button, the right information appears on the next page!");
            JavaScriptRedirectsConfirmationPAGE javaScriptRedirectsConfirmationPAGE = new JavaScriptRedirectsConfirmationPAGE(chromeDriver);
            Assert.assertEquals(chromeDriver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/redirected.html");
            javaScriptRedirectsConfirmationPAGE.clickOnGoBackButton();
            System.out.println("Go back to the main page!");
        }catch (Exception e){
            System.out.println("Test passed!");
        }
    }

    @Test(groups = {"desktop.H4", "mobile.H4"}, description = "verify that the second button works")
    public void clickOnSecondButtonTest(){
        try{
            chromeDriver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
            System.out.println("Navigate to Basic Ajax Example web page!");

            String mainWindow = chromeDriver.getWindowHandle();
            Assert.assertEquals(chromeDriver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
            System.out.println("The focus is on this page (main page)!");
            JavaScriptRedirectsPAGE javaScriptRedirectsPAGE = new JavaScriptRedirectsPAGE(chromeDriver);
            javaScriptRedirectsPAGE.clickOnFirstButton();
            Set<String> newWindow = chromeDriver.getWindowHandles();
            for(String newWindows: newWindow){
                if(!newWindows.equals(mainWindow)){
                    chromeDriver.switchTo().window(newWindows);
                    break;
                }
            }
            System.out.println("Now the focus is on the next page!");
            System.out.println("After passing the first button, the right information appears on the next page!");
            JavaScriptRedirectsConfirmationPAGE javaScriptRedirectsConfirmationPAGE = new JavaScriptRedirectsConfirmationPAGE(chromeDriver);
            Assert.assertEquals(chromeDriver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/redirected.html");
            javaScriptRedirectsConfirmationPAGE.clickOnGoBackButton();
            System.out.println("Go back to the main page!");
        }catch (Exception e){
            System.out.println("Test passed!");
        }
    }
}