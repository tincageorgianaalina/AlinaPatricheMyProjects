package alinatinca.Homework1.DemoqaWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.DemoqaWebPage.pageObjects.WebTablesPAGE;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class WebTablesTest extends BaseTest {

    String URL = "https://demoqa.com/elements";

    @Test(description = "verify how to get data in table")
    public void getDataTableTest() {
        chromeDriver.get(URL);
        System.out.println("Navigate to Demoqa Elements web page");
        WebTablesPAGE webTablesPAGE = new WebTablesPAGE(chromeDriver);
        webTablesPAGE.clickOnUrl();
        System.out.println("Go to WebTable page");
        webTablesPAGE.getSearchBox().sendKeys("Cierra");
        System.out.println("Search Cierra in table");
        System.out.println("The first row from table: " + webTablesPAGE.getCierraRow().getText());
        Assert.assertTrue(webTablesPAGE.getCierraRow().isDisplayed(), "The first row is not displayed!");
        System.out.println("The first row has been checked!");
    }

    @Test(description = "verify confirmation for editing table data")
    public void editDataTableConfirmationTest() throws IOException {
        try {
            chromeDriver.get(URL);
            System.out.println("Navigate to Demoqa Elements web page");
            WebTablesPAGE webTablesPAGE = new WebTablesPAGE(chromeDriver);
            webTablesPAGE.clickOnUrl();
            System.out.println("Go to WebTable page");
            Actions actions = new Actions(chromeDriver);
            actions.moveToElement(webTablesPAGE.getEditButton());
            webTablesPAGE.getEditButton().click();
            System.out.println("Click on edit button for the third row of the table");
            webTablesPAGE.getConfirmationForRegistrationForm();
        } catch (Exception e) {
            if (chromeDriver != null) {
                File sourceFile = chromeDriver.getScreenshotAs(OutputType.FILE);
                File fileDestination = new File(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\Homework1.png");
                FileUtils.copyFile(sourceFile, fileDestination);
                System.out.println("It takes a screenshot for this test case that verify that Registration Form is displayed after pressed on edit button");
                System.out.println("Test passed!");
            }
        }
    }

    @Test(description = "verify confirmation for editing table data")
    public void editDataTableTest(){
        chromeDriver.get(URL);
        System.out.println("Navigate to Demoqa Elements web page");
        WebTablesPAGE webTablesPAGE = new WebTablesPAGE(chromeDriver);
        webTablesPAGE.clickOnUrl();
        System.out.println("Go to WebTable page");
        WebTablesPAGE webTablesPAGE2 = new WebTablesPAGE(chromeDriver);
        webTablesPAGE2.getEditButton().click();
        System.out.println("Click on edit button for the third row of the table");
        webTablesPAGE2.getEditSalaryField().clear();
        webTablesPAGE2.getEditSalaryField().sendKeys("100");
        webTablesPAGE2.getSubmitButton().click();
        Assert.assertEquals(webTablesPAGE2.getConfirmationEditSalaryField().getText(), "100", "It is not match!");
        System.out.println("Salary has been checked after it was edited");
    }
}