package alinatinca.Homework3.KatalonDemoCuraHerokuWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyRedirectToLoginWhenUserNotLoggedInPAGE {

    ChromeDriver chromeDriver;

    public VerifyRedirectToLoginWhenUserNotLoggedInPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(id = "btn-make-appointment")
    WebElement makeAppointment;

    @FindBy(xpath = "//h1[text()='CURA Healthcare Service']")
    WebElement confirmationMessageHomePage;

    @FindBy(className = "lead")
    WebElement confirmationMessageForLoginPage;

    public void clickOnMakeAppointment() {
        makeAppointment.click();
        System.out.println("Click on the make appointment button!");
    }

    public WebElement getConfirmationMessageHomePage() {
        return confirmationMessageHomePage;
    }

    public WebElement getConfirmationMessageForLoginPage() {
        return confirmationMessageForLoginPage;
    }
}