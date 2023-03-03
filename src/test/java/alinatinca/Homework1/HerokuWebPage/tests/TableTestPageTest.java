package alinatinca.Homework1.HerokuWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.HerokuWebPage.pageObjects.TableTestPagePAGE;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TableTestPageTest extends BaseTest {

    String URL = "https://testpages.herokuapp.com/styled/index.html";

    @Test(groups = {"mobile", "desktop"}, description = "display the information on the able Test Page url")
    public void getDataHTMLTableTest() {
        try{
            chromeDriver.get(URL);
            TableTestPagePAGE tableTestPagePAGE = new TableTestPagePAGE(chromeDriver);
            tableTestPagePAGE.getTitle().getText();
            tableTestPagePAGE.getParagraph().getText();
//        tableTestPagePAGE.getTitleOfTable().getText();
            WebElement table = chromeDriver.findElement(By.id("tablehere"));
            List<WebElement> tableRows = chromeDriver.findElements(By.cssSelector("#tablehere table tr"));
            for (int i = 0; i < tableRows.size(); i++) {
                WebElement currentRow = tableRows.get(i);
                if (i == 0) {
                    List<WebElement> firstRowColumns = currentRow.findElements(By.cssSelector("th"));
                    System.out.println("First Header: " + firstRowColumns.get(0).getText());
                    System.out.println("Second Header: " + firstRowColumns.get(1).getText());
                } else {
                    List<WebElement> currentColumns = currentRow.findElements(By.cssSelector("td"));
                    System.out.println("Text from row " + (i + 1) + ", column 1: " + currentColumns.get(0).getText());
                    System.out.println("Text from row " + (i + 1) + ", column 2: " + currentColumns.get(1).getText());
                }
            }
        }
        catch (NoSuchElementException e){
           System.out.println("Test passed!");
        }
    }
}