package alinatinca.Homework1.DemoqaWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.DemoqaWebPage.pageObjects.WebTablesPAGE;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {

    String URL ="https://demoqa.com/elements";

    @Test(description = "verify how to get data in table")
    public void getDataTableTest(){
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

//    @Test(description = "verify how to edit data in table")
//    public void editDataTableTest(){
//        chromeDriver.get(URL);
//        System.out.println("Navigate to Demoqa Elements web page");
//        WebTablesPAGE webTablesPAGE = new WebTablesPAGE(chromeDriver);
//        webTablesPAGE.clickOnUrl();
//        System.out.println("Go to WebTable page");
//        Actions actions = new Actions(chromeDriver);
//        actions.moveToElement(webTablesPAGE.getEditSalaryField());
//        webTablesPAGE.getEditSalaryField().click();
//
//    }
}