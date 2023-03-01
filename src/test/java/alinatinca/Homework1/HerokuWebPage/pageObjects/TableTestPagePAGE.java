package alinatinca.Homework1.HerokuWebPage.pageObjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableTestPagePAGE {

    ChromeDriver chromeDriver;

    public TableTestPagePAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }
    //Create the constructor that can define the required parameters for this test case

    //Find the elements on the web page
    @FindBy(css = "div h1")
    WebElement title;

    @FindBy(className = "explanation")
    WebElement paragraph;

    @FindBy(xpath = "//*[contains(text(),'This table has information')]")
    WebElement titleOfTable;

    //Create methods for these elements
    public WebElement getTitle() {
        return title;
    }

    public WebElement getParagraph() {
        return paragraph;
    }

    public WebElement getTitleOfTable() {
        return titleOfTable;
    }
}