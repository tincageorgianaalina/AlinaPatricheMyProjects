package alinatinca.Homework1.DemoqaWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.DemoqaWebPage.pageObjects.TextBoxPAGE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TextBoxTest extends BaseTest {

    String URL = "https://demoqa.com/elements";

    @Test(groups = {"mobile", "desktop"}, description = "verify how to fill the form from Text Box category")
    public void fillDataTest(){
        chromeDriver.get(URL);
        System.out.println("Navigate to Demoqa Elements web page");
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TextBoxPAGE textBoxPAGE = new TextBoxPAGE(chromeDriver);
        chromeDriver.get("https://demoqa.com/text-box");
        System.out.println("Go to Text Box page");
//        Assert.assertTrue(textBoxPAGE.getTitle().isDisplayed(), "Text Box is not displayed on the page!");
//        System.out.println("Title has been checked, it is displayed on the page!");
        if(textBoxPAGE.getTitle().isDisplayed()){
            System.out.println("Title is: " + textBoxPAGE.getTitle().getText());
        }else{
            System.out.println("Text Box is not displayed on the page!");
        }
        textBoxPAGE.getFullName().sendKeys("Alina");
        System.out.println("Enter Alina in fullName field");
        textBoxPAGE.getEmail().sendKeys("teste@test.com");
        System.out.println("Enter test@test.com in email field");
        textBoxPAGE.getCurrentAddress().sendKeys("Uk");
        System.out.println("Enter Uk in currentAddress field");
        textBoxPAGE.getPermanentAddress().sendKeys("Uk");
        System.out.println("Enter Uk in permanentAddress field");
        ((JavascriptExecutor) chromeDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //scroll down the page to the end of the page
        WebElement submitButton = chromeDriver.findElement(By.id("submit"));
        submitButton.click();
        System.out.println("Click on submit button!");
        System.out.println("Test passed!");
    }
}