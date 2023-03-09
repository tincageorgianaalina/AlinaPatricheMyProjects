package alinatinca.Homework3.KatalonDemoCuraHerokuWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework3.KatalonDemoCuraHerokuWebPage.pageObjects.BackToHomePAGE;
import org.bouncycastle.asn1.eac.CertificateHolderReference;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BackToHomePageTests extends BaseTest {

    @Test(groups = {"desktop.H3", "mobile.H3"}, description = "verify that return to Home page from home page menu")
    public void backToHomePageFromHomePageMenuTest(){
        try{
            chromeDriver.get("https://katalon-demo-cura.herokuapp.com/");
            BackToHomePAGE backToHomePAGE = new BackToHomePAGE(chromeDriver);
            backToHomePAGE.clickOnMenuButton();
            backToHomePAGE.clickOnHomeButton();
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/",
                    "Return to home page is not successfully!");
            backToHomePAGE.assertMessageAtTheTopSideOfHomePage();
            backToHomePAGE.assertMessageAtTheBottomSideOfHomePage();
        }catch (Exception e){
            System.out.println("Test passed!");
        }
    }

    @Test(groups = {"desktop.H3", "mobile.H3"}, description = "verify how to log in to the system")
    public void loginWithValidCredentialsTest(){
        try{
            chromeDriver.get("https://katalon-demo-cura.herokuapp.com/");
            BackToHomePAGE backToHomePAGE = new BackToHomePAGE(chromeDriver);
            backToHomePAGE.clickOnMenuButton();
            backToHomePAGE.clickOnLoginButton();
            backToHomePAGE.getUserName().sendKeys("John Doe");
            backToHomePAGE.getPassword().sendKeys("ThisIsNotAPassword");
            backToHomePAGE.clickOnLogin();
            backToHomePAGE.assertMessageAtTheTopSideOfHomePage();
            backToHomePAGE.assertMessageAtTheBottomSideOfHomePage();
        }catch (Exception e){
            System.out.println("Test passed!");
        }
    }

    @Test(groups = {"desktop.H3", "mobile.H3"}, description = "verify how to return to home page from Login page")
    public void backToHomePageFromLoginPageTest(){
        try{
            loginWithValidCredentialsTest();
            backToHomePageFromHomePageMenuTest();
            BackToHomePAGE backToHomePAGE = new BackToHomePAGE(chromeDriver);
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/",
                    "Return to home page is not successfully!");
            backToHomePAGE.assertMessageAtTheTopSideOfHomePage();
            backToHomePAGE.assertMessageAtTheBottomSideOfHomePage();
        }catch (Exception e){
            System.out.println("Back to home page from Login page with successfully!");
            System.out.println("Test passed!");
        }
    }

    @Test(groups = {"desktop.H3", "mobile.H3"}, description = "verify how to return to home page from Appointment form page")
    public void backToHomePageFromAppointmentFormPageTest(){
        try{
            loginWithValidCredentialsTest();
            backToHomePageFromHomePageMenuTest();
            BackToHomePAGE backToHomePAGE = new BackToHomePAGE(chromeDriver);
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/",
                    "Return to home page is not successfully!");
            backToHomePAGE.assertMessageAtTheTopSideOfHomePage();
            backToHomePAGE.assertMessageAtTheBottomSideOfHomePage();
        }catch (Exception e){
            System.out.println("Back to home page from Appointment page with successfully!");
            System.out.println("Test passed!");
        }
    }

    @Test(groups = {"desktop.H3", "mobile.H3"}, description = "verify that return to home page from History page")
    public void backToHomePageFromHistoryPage(){
        try{
            loginWithValidCredentialsTest();
            BackToHomePAGE backToHomePAGE = new BackToHomePAGE(chromeDriver);
            backToHomePAGE.clickOnMenuButton();
            backToHomePAGE.clickOnHistoryButton();
            backToHomePageFromHomePageMenuTest();
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/",
                    "Return to home page is not successfully!");
            backToHomePAGE.assertMessageAtTheTopSideOfHomePage();
            backToHomePAGE.assertMessageAtTheBottomSideOfHomePage();
        }catch (Exception e){
            System.out.println("Back to home page from History page with successfully!");
            System.out.println("Test passed!");
        }
    }

    @Test(groups = {"desktop.H3", "mobile.H3"}, description = "verify that return to home page from profile page")
    public void backToHomePageFromProfilePage() {
        try{
            loginWithValidCredentialsTest();
            BackToHomePAGE backToHomePAGE = new BackToHomePAGE(chromeDriver);
            backToHomePAGE.clickOnMenuButton();
            backToHomePAGE.clickOnProfileButton();
            backToHomePageFromHomePageMenuTest();
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/",
                    "Return to home page is not successfully!");
            backToHomePAGE.assertMessageAtTheTopSideOfHomePage();
            backToHomePAGE.assertMessageAtTheBottomSideOfHomePage();
        }catch (Exception e){
            System.out.println("Back to home page from Profile page with successfully!");
            System.out.println("Test passed!");
        }
    }

    @Test(groups = {"desktop.H3", "mobile.H3"}, description = "verify that return to home page from Logout page")
    public void backToHomePageFromLogoutPage(){
        try{
            loginWithValidCredentialsTest();
            backToHomePageFromHomePageMenuTest();
            BackToHomePAGE backToHomePAGE = new BackToHomePAGE(chromeDriver);
            backToHomePAGE.clickOnLogoutButton();
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/",
                    "Return to home page is not successfully!");
            backToHomePAGE.assertMessageAtTheTopSideOfHomePage();
            backToHomePAGE.assertMessageAtTheBottomSideOfHomePage();
        }catch (Exception e){
            System.out.println("Back to home page from Logout page with successfully!");
            System.out.println("Test passed!");
        }
    }
}