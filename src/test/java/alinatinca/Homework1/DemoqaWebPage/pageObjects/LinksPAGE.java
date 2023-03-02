package alinatinca.Homework1.DemoqaWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPAGE {

    ChromeDriver chromeDriver;

    public LinksPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(id = "dynamicLink")
    WebElement homeLink;

    @FindBy(partialLinkText = "Created")
    WebElement createdLink;

    @FindBy(id = "no-content")
    WebElement noContentLink;

    @FindBy(id = "moved")
    WebElement movedLink;

    @FindBy(id = "bad-request")
    WebElement badRequestLink;

    @FindBy(id = "unauthorized")
    WebElement unauthorizedLink;

    @FindBy(id = "forbidden")
    WebElement forbiddenLink;

    @FindBy(id = "invalid-url")
    WebElement notFoundLink;

    @FindBy(id = "linkResponse")
    WebElement conformationMessageLink;


    public void clickOnHomeLink() {
        homeLink.click();
        System.out.println("Click on Home link");
    }

    public void clickOnCreatedLink() {
        createdLink.click();
        System.out.println("Click on Created link");
    }

    public void clickOnNoContentLink() {
        noContentLink.click();
        System.out.println("Click on No Content link");
    }

    public void clickOnMovedLink() {
        movedLink.click();
        System.out.println("Click on Moved link");
    }

    public void clickOnBadRequestLink() {
        badRequestLink.click();
        System.out.println("Click on Bad Request link");
    }

    public void clickOnUnauthorizedLink() {
        unauthorizedLink.click();
        System.out.println("Click on Unauthorized link");
    }

    public void clickOnForbiddenLink() {
        forbiddenLink.click();
        System.out.println("Click on Forbidden link");
    }

    public void clickOnNotFoundLink() {
        notFoundLink.click();
        System.out.println("Click on Not Found link");
    }

    public WebElement getConformationMessageLink() {
        return conformationMessageLink;
    }
}