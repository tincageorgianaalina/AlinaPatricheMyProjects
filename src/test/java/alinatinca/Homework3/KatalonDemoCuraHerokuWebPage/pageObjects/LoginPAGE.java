package alinatinca.Homework3.KatalonDemoCuraHerokuWebPage.pageObjects;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPAGE {

    ChromeDriver chromeDriver;

    public LoginPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(xpath = "//h1[text()='CURA Healthcare Service']")
    WebElement confirmationMessageHomePage;

    @FindBy(id = "menu-toggle")
    WebElement homeButton;

    @FindBy(css = "a[href=\"profile.php#login\"]")
    WebElement loginButtonHome;

    @FindBy(className = "lead")
    WebElement confirmationMessageForLoginPage;

    @FindBy(xpath = "//h2[text()='Make Appointment']")
    WebElement confirmationMessageForLoginSuccessfully;

    public WebElement getConfirmationMessageHomePage() {
        return confirmationMessageHomePage;
    }

    public void clickOnHomeButton() {
        homeButton.click();
        System.out.println("Click on Home button!");
    }

    public void clickOnLoginButtonHome() {
        loginButtonHome.click();
        System.out.println("Click on Login home button!");
    }

    public WebElement getConfirmationMessageForLoginPage() {
        return confirmationMessageForLoginPage;
    }

    public WebElement getConfirmationMessageForLoginSuccessfully() {
        return confirmationMessageForLoginSuccessfully;
    }
}