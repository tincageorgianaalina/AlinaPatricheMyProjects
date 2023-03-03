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
    //Create the constructor that can define the required parameters for this test case

    //Find the elements on the web page
    @FindBy(id = "dynamicLink")
    WebElement homeLink;

    @FindBy(partialLinkText = "Created")
    WebElement createdLink;

    @FindBy(id = "no-content")
    WebElement noContentLink;

    @FindBy(id = "moved")
    WebElement movedLink;

    @FindBy(partialLinkText = "Bad Request")
    WebElement badRequestLink;

    @FindBy(id = "linkResponse")
    WebElement conformationMessageLink;

    //Create methods for these elements
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

    public WebElement getConformationMessageLink() {
        return conformationMessageLink;
    }
}