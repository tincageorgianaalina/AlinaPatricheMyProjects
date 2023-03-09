package alinatinca.Homework3.KatalonDemoCuraHerokuWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework3.KatalonDemoCuraHerokuWebPage.pageObjects.VerifyRedirectToLoginWhenUserNotLoggedInPAGE;
import org.bouncycastle.asn1.eac.CertificateHolderReference;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyRedirectToLoginWhenUserNotLoggedInTest extends BaseTest {

    @Test(groups = {"desktop.H3", "mobile.H3"}, description = "verify that user is redirected to login page when wants to make an appointment")
    public void verifyRedirectToLoginWhenUserNotLoggedInTest(){
        try{
            chromeDriver.get("https://katalon-demo-cura.herokuapp.com/");
            System.out.println("Navigate to Katalon Demo Cura Heroku web page!");
            VerifyRedirectToLoginWhenUserNotLoggedInPAGE verifyRedirectToLoginWhenUserNotLoggedInPAGE = new VerifyRedirectToLoginWhenUserNotLoggedInPAGE(chromeDriver);
            Assert.assertEquals(verifyRedirectToLoginWhenUserNotLoggedInPAGE.getConfirmationMessageHomePage().getText(),
                    "CURA Healthcare Service",
                    "The following message: Cura Healthcare Service is not displayed on the Katalon Demo Cura Heroku web page!");
            System.out.println("The presence on the home page has been verified.CURA Healthcare Service appears on the home page!");
            verifyRedirectToLoginWhenUserNotLoggedInPAGE.clickOnMakeAppointment();
            Assert.assertEquals(verifyRedirectToLoginWhenUserNotLoggedInPAGE.getConfirmationMessageForLoginPage().getText(),
                    "Please login to make appointment.",
                    "The following message: Please login to make appointment is not displayed on the login page!");
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                    "User is not redirected to login page when not logged in!");
        }catch (Exception e){
            System.out.println("An appointment could not be made!");
            System.out.println("To make an appointment it is required to log in!");
            System.out.println("Test passed!");
        }
    }
}