package alinatinca.Homework1.HerokuWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DynamicHTMLTablePAGE {

    ChromeDriver chromeDriver;

    public DynamicHTMLTablePAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }
    //Create the constructor that can define the required parameters for this test case

    //Find the elements on the web page
    @FindBy(id = "dynamictablestest")
    WebElement URL;

    @FindBy(css = "h1")
    WebElement title;

    @FindBy(css = ".explanation")
    WebElement paragraph;

    @FindBy(css = "#dynamictable caption")
    WebElement titleOfTable;

    @FindBy(id = "dynamictable")
    WebElement table;

    @FindBy(xpath = "//summary[text()='Table Data']")
    WebElement tableData;

    @FindBy(id = "caption")
    WebElement captionField;

    @FindBy(id = "tableid")
    WebElement idField;

    @FindBy(id = "refreshtable")
    WebElement refreshButton;

    //Create methods for these elements
    public void clickOnUrl() {
        URL.click();
        System.out.println("The link has been opened!");
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getParagraph() {
        return paragraph;
    }

    public WebElement getTitleOfTable() {
        return titleOfTable;
    }

    public WebElement getTable() {
        return table;
    }

    public void clickOnTableData() {
        tableData.click();
        System.out.println("Click on table data");
    }

    public WebElement getCaptionField() {
        return captionField;
    }

    public WebElement getIdField() {
        return idField;
    }

    public void clickOnRefreshButton() {
        refreshButton.click();
        System.out.println("Click on refresh button");
    }
}