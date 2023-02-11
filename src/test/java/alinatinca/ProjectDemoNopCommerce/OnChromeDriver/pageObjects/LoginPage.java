package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected ChromeDriver chromeDriver;

    //create the LoginPage constructor
    public LoginPage (ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    //identify all the elements from the page
    @FindBy(id="Email")
    private WebElement email;

    @FindBy(id="Password")
    private WebElement password;

    @FindBy(xpath = "//div[@class='buttons']/ button")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[2]/div[1]/span/span")
    private WebElement messageWarningForEmailField;

    //define and assign methods to each element from the page
    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getMessageWarningForEmailField() {
        return messageWarningForEmailField;
    }
}