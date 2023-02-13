package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.tests;

import alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects.LoginPage;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest{

    WebDriverWait wait;

    @DataProvider(name = "loginDataProvider1")
    public Object[][] loginDataProvider1(){
        return new Object[][]{
                {"admin@yourstore.com","admin","loginWithValidCredentials"},
                //test case with valid credentials
                {"dmin@yourstore.com","admin","loginWithInvalidCredentials"},
                //test case with invalid email and valid password
                {"dmin@yourstore.com","","loginWithInvalidCredentials"}
                //test case with invalid email and without password
        };
    }
    @Test(dataProvider = "loginDataProvider1", description = "verify login functionals with valid and invalid credentials for 3 cases")
    public void loginTest(String emailData, String passwordData, String credentialsType){
            chromeDriver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
            //go to URL
        Assert.assertEquals(chromeDriver.getCurrentUrl(),
                "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F",
                "This URL is not for login!");
        //verify if remain on the main URL
        LoginPage loginPage = new LoginPage(chromeDriver);
        loginPage.getEmail().clear();
        //empty the email field
        loginPage.getPassword().clear();
        //empty the password field
        loginPage.getEmail().sendKeys(emailData);
        //enter the email data
        loginPage.getPassword().sendKeys(passwordData);
        //enter the password data
        loginPage.getLoginButton().click();
        //click on the login button
        if (credentialsType.equals("loginWithValidCredentials")) {
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://admin-demo.nopcommerce.com/admin/",
                    "Login was unsuccesfully with the default data!");
            //if the valid credentials can be entered, it goes to this URL:https://admin-demo.nopcommerce.com/admin/
        }else{
            wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(4));
            WebElement messageWarning = chromeDriver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[1]"));
            Assert.assertEquals(messageWarning.getText(),
                    "Login was unsuccessful. Please correct the errors and try again.\n" +
                            "No customer account found",
                    "Should not navigate to admin page!");
            //else a red warning message is displayed on the page
        }
    }

    @DataProvider(name = "loginDataProvider2")
    public Object[][]loginDataProvider2(){
         return new Object[][]{
                 {"admin@yourstore.com","dmin"},
                 //test case with valid email and invalid password
                 {"admin@yourstore.com",""}
                 //test case with a valid email and without password
            };
    }

    @Test(dataProvider = "loginDataProvider2", description = "verify login functionals with another invalid credentials")
    public void loginTestForAnotherInvalidData(String emailData, String passwordData){
        chromeDriver.get("https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F");
        //go to URL
        Assert.assertEquals(chromeDriver.getCurrentUrl(),
                "https://admin-demo.nopcommerce.com/login?returnurl=%2Fadmin%2F",
                "This URL is not for login!");
        //verify if remain on the main URL
        LoginPage loginPage = new LoginPage(chromeDriver);
        loginPage.getEmail().clear();
        //empty the email field
        loginPage.getPassword().clear();
        //empty the password field
        loginPage.getEmail().sendKeys(emailData);
        //enter email data
        loginPage.getPassword().sendKeys(passwordData);
        //enter password data
        loginPage.getLoginButton().click();
        //click on the login button
        WebElement messageWarning = chromeDriver.findElement(By.cssSelector(".validation-summary-errors"));
        //find this element on the page
        Assert.assertEquals(messageWarning.getText(),
                "Login was unsuccessful. Please correct the errors and try again.\n" +
                        "The credentials provided are incorrect",
                "Should not navigate to admin page!");
        //verify if a red warning message is displayed on the page
    }
}