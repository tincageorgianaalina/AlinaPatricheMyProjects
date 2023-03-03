package alinatinca.Homework1.DemoqaWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.DemoqaWebPage.pageObjects.LinksPAGE;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksTest extends BaseTest {

    String URL = "https://demoqa.com/elements";

    @Test(description = "verify that Home link can be opened")
    public void homeLinkTest() {
        try {
            chromeDriver.get(URL);
            System.out.println("Navigate to Demoqa Elements page");
            chromeDriver.get("https://demoqa.com/buttons");
            System.out.println("Go to Buttons category");
            LinksPAGE linksPAGE = new LinksPAGE(chromeDriver);
            linksPAGE.clickOnHomeLink();
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://demoqa.com/",
                    "Url is not match!");
        } catch (NoSuchElementException e) {
            System.out.println("Home link is opened!");
            System.out.println("Link has been checked; a new page has been opened!");
            System.out.println("Test passed!");
        }
    }

    @Test(description = "verify that Created link can be clicked and after that a message is displayed on the page")
    public void createdLinkTest() {
        try {
            chromeDriver.get(URL);
            System.out.println("Navigate to Demoqa Elements page");
            chromeDriver.get("https://demoqa.com/buttons");
            System.out.println("Go to Buttons category");
            LinksPAGE linksPAGE = new LinksPAGE(chromeDriver);
            linksPAGE.clickOnCreatedLink();
            Assert.assertEquals(linksPAGE.getConformationMessageLink().getText(),
                    "Link has responded with staus 201 and status text Created",
                    "Confirmation message is not match!");
        } catch (NoSuchElementException e) {
            System.out.println("Created link is clicked");
            System.out.println("Link has been checked; confirmation message is displayed on the page!");
            System.out.println("Test passed!");
        }
    }

    @Test(description = "verify that No Content link can be clicked and after that a message is displayed on the page")
    public void noContentLinkTest() {
        try {
            chromeDriver.get(URL);
            System.out.println("Navigate to Demoqa Elements page");
            chromeDriver.get("https://demoqa.com/buttons");
            System.out.println("Go to Buttons category");
            LinksPAGE linksPAGE = new LinksPAGE(chromeDriver);
            linksPAGE.clickOnNoContentLink();
            Assert.assertEquals(linksPAGE.getConformationMessageLink().getText(),
                    "Link has responded with staus 204 and status text No Content",
                    "Confirmation message is not match!");
        } catch (NoSuchElementException e) {
            System.out.println("No Content link is clicked");
            System.out.println("Link has been checked; confirmation message is displayed on the page!");
            System.out.println("Test passed!");
        }
    }

    @Test(description = "verify that No Content link can be clicked and after that a message is displayed on the page")
    public void movedLinkTest() {
        try {
            chromeDriver.get(URL);
            System.out.println("Navigate to Demoqa Elements page");
            chromeDriver.get("https://demoqa.com/buttons");
            System.out.println("Go to Buttons category");
            LinksPAGE linksPAGE = new LinksPAGE(chromeDriver);
            linksPAGE.clickOnMovedLink();
            Assert.assertEquals(linksPAGE.getConformationMessageLink().getText(),
                    "Link has responded with staus 301 and status text Moved Permanently",
                    "Confirmation message is not match!");
        } catch (NoSuchElementException e) {
            System.out.println("Moved link is clicked");
            System.out.println("Link has been checked; confirmation message is displayed on the page!");
            System.out.println("Test passed!");
        }
    }

    @Test(description = "verify that No Content link can be clicked and after that a message is displayed on the page")
    public void badRequestLinkTest(){
        try{
            chromeDriver.get(URL);
            System.out.println("Navigate to Demoqa Elements page");
            chromeDriver.get("https://demoqa.com/buttons");
            System.out.println("Go to Buttons category");
            LinksPAGE linksPAGE = new LinksPAGE(chromeDriver);
            linksPAGE.clickOnBadRequestLink();
            Assert.assertTrue(linksPAGE.getConformationMessageLink().isDisplayed(), "The confirmation message is not displayed");
        }catch (NoSuchElementException e){
            System.out.println("Bad Request link is clicked");
            System.out.println("Link has been checked; confirmation message is displayed on the page!");
            System.out.println("Test passed!");
        }
    }
}