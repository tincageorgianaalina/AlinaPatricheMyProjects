package alinatinca.Homework1.DemoqaWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPAGE {

    ChromeDriver chromeDriver;

    public TextBoxPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }
    //Create the constructor that can define the required parameters for this test case

    //Find the elements on the web page
    @FindBy(className = "main-header")
    WebElement title;

    @FindBy(id = "userName")
    WebElement fullName;

    @FindBy(css = "input[class='mr-sm-2 form-control']")
    WebElement email;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    //Create methods for these elements
    public WebElement getTitle() {
        return title;
    }

    public WebElement getFullName() {
        return fullName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getCurrentAddress() {
        return currentAddress;
    }

    public WebElement getPermanentAddress() {
        return permanentAddress;
    }
}