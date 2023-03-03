package alinatinca.Homework1.HerokuWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementAttributesExamplesPAGE {

    ChromeDriver chromeDriver;

    public ElementAttributesExamplesPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }
    //Create the constructor that can define the required parameters for this test case

    //Find the elements on the web page
    @FindBy(id = "elementattributestest")
    WebElement URL;

    @FindBy(css = "div h1")
    WebElement title;

    @FindBy(css = ".explanation")
    WebElement paragraph1;

    @FindBy(xpath = "/html/body/div/h2[1]")
    WebElement title2;

    @FindBy(xpath = "/html/body/div/p[1]")
    WebElement paragraph2;

    @FindBy(xpath = "/html/body/div/h2[2]")
    WebElement title3;

    @FindBy(xpath = "/html/body/div/p[2]")
    WebElement paragraph3;

    //Create methods for these elements
    public void clickOnUrl() {
        URL.click();
        System.out.println("The link has been opened!");
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getParagraph1() {
        return paragraph1;
    }

    public WebElement getTitle2() {
        return title2;
    }

    public WebElement getParagraph2() {
        return paragraph2;
    }

    public WebElement getTitle3() {
        return title3;
    }

    public WebElement getParagraph3() {
        return paragraph3;
    }
}