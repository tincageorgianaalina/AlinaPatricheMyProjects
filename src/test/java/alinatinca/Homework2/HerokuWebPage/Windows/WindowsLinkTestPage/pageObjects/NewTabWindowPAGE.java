package alinatinca.Homework2.HerokuWebPage.Windows.WindowsLinkTestPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class NewTabWindowPAGE {

    ChromeDriver chromeDriver;

    public NewTabWindowPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(id = "tabButton")
    WebElement newTab;

    @FindBy(id = "sampleHeading")
    WebElement messageFromNewTab;

    @FindBy(css = "img[src=\"/images/Toolsqa.jpg\"]")
    WebElement imageToolsQA;

    public void getNewTabWindow() {
        String parentTab = chromeDriver.getWindowHandle();
        newTab.click();
        System.out.println("Click on the first popup!");
        System.out.println("The new tab is opened but the focus remained on the parent tab!");

        Set<String> newTab = chromeDriver.getWindowHandles();
        for (String tabs: newTab){
            if(!tabs.equals(parentTab)){
                chromeDriver.switchTo().window(tabs);
                break;
            }
        }
        System.out.println("The focus is mouved on the new tab!");
        System.out.println("The following message appears on the new tab is:" + messageFromNewTab.getText());

        chromeDriver.switchTo().window(parentTab);
        Assert.assertTrue(imageToolsQA.isDisplayed(), "ToolsQa image is not displayed on the parent window!");
        System.out.println("As a result of checking the presence of the ToolQa image on the parent page, the focus is moved to the parent tab!");
    }
}