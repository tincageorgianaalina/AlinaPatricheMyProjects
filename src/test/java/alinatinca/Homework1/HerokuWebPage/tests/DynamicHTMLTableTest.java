package alinatinca.Homework1.HerokuWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.HerokuWebPage.pageObjects.DynamicHTMLTablePAGE;
import org.testng.annotations.Test;

public class DynamicHTMLTableTest extends BaseTest {

    String URL = "https://testpages.herokuapp.com/styled/index.html";

    @Test(groups = {"mobile", "desktop"}, description = "display information on the Dynamic HTML TABLE url")
    public void getDataDynamicHTMLTableTest(){
        chromeDriver.get(URL);
        System.out.println("Go to Heroku web page");
        DynamicHTMLTablePAGE dynamicHTMLTablePAGE = new DynamicHTMLTablePAGE(chromeDriver);
        dynamicHTMLTablePAGE.clickOnUrl();
        System.out.println("Go to Dynamic Table Test Page");
        System.out.println("Title is: " + dynamicHTMLTablePAGE.getTitle().getText());
        System.out.println("Paragraph is: " + dynamicHTMLTablePAGE.getParagraph().getText());
        System.out.println("The title of table is: " + dynamicHTMLTablePAGE.getTitleOfTable().getText());
        System.out.println("The body of table is: " + dynamicHTMLTablePAGE.getTable().getText());
        dynamicHTMLTablePAGE.clickOnTableData();
        dynamicHTMLTablePAGE.getCaptionField().sendKeys("test");
        System.out.println("Enter test in caption field");
        dynamicHTMLTablePAGE.getIdField().sendKeys("100");
        System.out.println("Enter 100 in id field");
        dynamicHTMLTablePAGE.clickOnRefreshButton();
        System.out.println("Test passed!");
    }
}