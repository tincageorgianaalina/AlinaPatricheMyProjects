package alinatinca.Homework1.HerokuWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicWebPageExamplePAGE {

    ChromeDriver chromeDriver;

    public BasicWebPageExamplePAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }
    //Create the constructor that can define the required parameters for this test case

    //Find the elements on the web page
    @FindBy(id = "basicpagetest")
    WebElement URL;

    @FindBy(tagName = "h1")
    WebElement title;

    @FindBy(className = "explanation")
    WebElement paragraph;

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
}