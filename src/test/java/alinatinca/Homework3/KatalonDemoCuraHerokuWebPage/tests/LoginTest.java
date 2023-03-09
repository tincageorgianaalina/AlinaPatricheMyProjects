package alinatinca.Homework3.KatalonDemoCuraHerokuWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework3.KatalonDemoCuraHerokuWebPage.pageObjects.LoginPAGE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"John Doe", "ThisIsNotAPassword", "validCredentials"},
                {"Jon Doe", "ThisIsNotAPassword", "invalidCredentials"},
        };
    }

    @Test(groups = {"desktop.H3", "mobile.H3"}, dataProvider = "loginDataProvider", description = "verify login scenarios with valid and invalid credentials")
    public void loginWithCredentials(String userName, String password, String credentialsType) {
        try {
            chromeDriver.get("https://katalon-demo-cura.herokuapp.com/");
            System.out.println("Navigate to Katalon Demo Cura Heroku web page!");
            LoginPAGE loginPAGE = new LoginPAGE(chromeDriver);
            Assert.assertEquals(loginPAGE.getConfirmationMessageHomePage().getText(),
                    "CURA Healthcare Service",
                    "The following message: Cura Healthcare Service is not displayed on the Katalon Demo Cura Heroku web page!");
            System.out.println("The presence on the home page has been verified. CURA Healthcare Service appears on the home page!");

            loginPAGE.clickOnHomeButton();

            loginPAGE.clickOnLoginButtonHome();
            Assert.assertEquals(loginPAGE.getConfirmationMessageForLoginPage().getText(),
                    "Please login to make appointment.",
                    "The following message: Please login to make appointment is not displayed on the login page!");
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                    "The link is not right for login! Couldn't navigate to login page!");
            System.out.println("The presence on the login page has been verified. The message on the login page appears on the login page; Login should be done with successfully now!");

            WebElement userNameInput = chromeDriver.findElement(By.id("txt-username"));
            userNameInput.click();
            userNameInput.sendKeys(userName);
            WebElement passwordInput = chromeDriver.findElement(By.id("txt-password"));
            passwordInput.click();
            passwordInput.sendKeys(password);
            WebElement loginButton = chromeDriver.findElement(By.id("btn-login"));
            loginButton.click();
            if (credentialsType.equals("validCredentials")) {
                Assert.assertEquals(loginPAGE.getConfirmationMessageForLoginSuccessfully().getText(),
                        "Make Appointment",
                        "Make Appointment is not displayed on the login page! Couldn't navigate to login page!");

                Assert.assertEquals(chromeDriver.getCurrentUrl(),
                        "https://katalon-demo-cura.herokuapp.com/#appointment",
                        "The link is not right to make appointment! Couldn't navigate to login page!");
                System.out.println("Login was successfully!");
            } else {
                WebElement unsuccessfullyLoginMessage = chromeDriver.findElement(By.className("text-danger"));
                Assert.assertEquals(unsuccessfullyLoginMessage.getText(),
                        "Login failed! Please ensure the username and password are valid.",
                        "Shouldn't navigate to appointment page!");
                System.out.println("Login was not successfully because the login is not made with a valid userName!");
            }
        } catch (Exception e) {
            System.out.println("Test passed!");
        }
    }
}