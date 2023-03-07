package alinatinca.Homework2.DemoqaWebPage.BrowserWindows.pageObjects;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class NewWindowPAGE {

    ChromeDriver chromeDriver;

    public NewWindowPAGE(ChromeDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(id = "windowButton")
    WebElement newWindow;

    @FindBy(id = "sampleHeading")
    WebElement messageFromNewWindow;

    @FindBy(css = "img[src=\"/images/Toolsqa.jpg\"]")
    WebElement imageToolsQA;

    public void getNewWindow() {
        newWindow.click();
        System.out.println("Click on the second popup!");
        String parentWindow = chromeDriver.getWindowHandle();
        System.out.println("The new window is opened but the focus remained on the parent window!");

        Set<String> newWindow = chromeDriver.getWindowHandles();
        for(String newWindows: newWindow){
            if(!newWindows.equals(parentWindow)){
                chromeDriver.switchTo().window(newWindows);
                break;
            }
        }
        System.out.println("The focus is mouved on the new window!");
        System.out.println("The following message appears on the new window is:" + messageFromNewWindow.getText());

        chromeDriver.switchTo().window(parentWindow);
        Assert.assertTrue(imageToolsQA.isDisplayed(), "ToolsQa image is not displayed on the parent window!");
        System.out.println("As a result of checking the presence of the ToolQa image on the parent page, the focus is moved to the parent tab!");
        System.out.println("The focus is mouved on the parent window!");
    }
}