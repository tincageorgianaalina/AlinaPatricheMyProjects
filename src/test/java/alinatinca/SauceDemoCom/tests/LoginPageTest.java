package alinatinca.SauceDemoCom.tests;

import alinatinca.SauceDemoCom.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider(){
        return new Object[][]{
                {"standard_user", "secret_sauce", "testShouldPass"},
                {"problem_user", "secret_sauce", "testShouldPass"},
                {"performance_glitch_user", "secret_sauce", "testShouldPass"},
                {"locked_out_user", "secret_sauce", "testShouldFail"},
                {"standard", "secret_sauce", "testShouldFail"},
        };
    }

    @Test(dataProvider = "loginDataProvider", description = "verify how to log into the system with valid and invalid credentials")
    public void loginTest(String userName, String password, String credentialsType){
        chromeDriver.get("https://www.saucedemo.com/");
        WebElement userNameInput = chromeDriver.findElement(By.id("user-name"));
        userNameInput.sendKeys(userName);
        WebElement passwordInput = chromeDriver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        loginButton.click();
        if(credentialsType.equals("testShouldPass")){
            Assert.assertEquals(chromeDriver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                    "Login does not work!");

            WebElement products = chromeDriver.findElement(By.className("title"));
            Assert.assertTrue(products.isDisplayed(),
                    "Login does not work!");
            System.out.println("Login successfully!");
        }else{
            WebElement errorMessage = chromeDriver.findElement(By.cssSelector(".error-message-container.error"));
            Assert.assertTrue(errorMessage.isDisplayed(), "There is not any warning message!");
            System.out.println("Login failed!");
        }
    }
}