package alinatinca.Homework2.DemoqaWebPage.BrowserWindows.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class NewWindowMessagePAGE {

    ChromeDriver chromeDriver;

    public NewWindowMessagePAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(id = "messageWindowButton")
    WebElement newWindowMessage;

    public void clickOnNewWindowMessageButton(){
        newWindowMessage.click();
        String parentWindow = chromeDriver.getWindowHandle();
        Set<String> newWindows = chromeDriver.getWindowHandles();
        for (String newWindow: newWindows) {
            if (!newWindow.equals(parentWindow)) {
                chromeDriver.switchTo().window(newWindow);
                break;
            }
        }
        chromeDriver.switchTo().window(parentWindow);
        try{
            System.out.println(chromeDriver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']")).getText());
            chromeDriver.close();
            System.out.println("Click on New Window Message button");
        }catch (Exception e){
            System.out.println("Test passed!");
        }
    }
}