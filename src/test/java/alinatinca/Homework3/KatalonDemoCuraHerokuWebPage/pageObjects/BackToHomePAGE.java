package alinatinca.Homework3.KatalonDemoCuraHerokuWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BackToHomePAGE {

    ChromeDriver chromeDriver;

    public BackToHomePAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(id ="menu-toggle")
    WebElement menuButton;

    @FindBy(xpath = "//a[text()='Home']")
    WebElement homeButton;

    public void clickOnMenuButton() {
        menuButton.click();
    }

    public void clickOnHomeButton() {
        homeButton.click();
    }

    @FindBy(linkText = "Login")
    WebElement loginButton;

    @FindBy(id = "txt-username")
    WebElement userName;

    @FindBy(id = "txt-password")
    WebElement password;

    @FindBy(id = "btn-login")
    WebElement login;

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public void clickOnLogin() {
        login.click();
    }

    @FindBy(xpath = "//a[text()='History']")
    WebElement historyButton;

    public void clickOnHistoryButton() {
        historyButton.click();
    }

    @FindBy(xpath = "//a[text()='Profile']")
    WebElement profileButton;

    public void clickOnProfileButton() {
        profileButton.click();
    }

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutButton;

    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    @FindBy(css = ".text-vertical-center")
    WebElement confirmationMessageAtTheTopSideOfHomePage;

    public void assertMessageAtTheTopSideOfHomePage() {
        Assert.assertTrue(confirmationMessageAtTheTopSideOfHomePage.isDisplayed(),
                "There is not Home page here!");
    }

    @FindBy(css = ".col-lg-10.col-lg-offset-1.text-center")
    WebElement confirmationMessageAtTheBottomSideOfHomePage;

    public void assertMessageAtTheBottomSideOfHomePage() {
        Assert.assertTrue(confirmationMessageAtTheBottomSideOfHomePage.isDisplayed(),
                "There is not Home page here!");
    }
}