package alinatinca.Homework1.HerokuWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindByPlaygroundLocatorExamplesPAGE {

    ChromeDriver chromeDriver;

    public FindByPlaygroundLocatorExamplesPAGE (ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }
    //Create the constructor that can define the required parameters for this test case

    //Find the elements on the web page
    @FindBy(id = "findbytest")
    WebElement URL;

    @FindBy(css = ".page-body h1")
    WebElement title;

    @FindBy(css = ".explanation")
    WebElement paragraph;

    @FindBy(id = "p21")
    WebElement uParagraph;

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

    public WebElement getuParagraph() {
        return uParagraph;
    }
}