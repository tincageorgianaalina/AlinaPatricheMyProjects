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

    @FindBy(id="Email")
    WebElement email;

    @FindBy(id="Password")
    WebElement password;



}
