package alinatinca.NotionsOfTheory.SeleniumBasic2.RadioButtons;

import alinatinca.NotionsOfTheory.SeleniumBasic2.BaseTest;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RadioButtonsFromDemoqaWebPage extends BaseTest {
    //RadioButtons are used for the users that can choose one option from a set of items

    @Test(description = "verify how to select yes radio button")
    public void yesRadioButtonTest(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/radio-button");
        WebElement yesRadioButton = chromeDriver.findElement(By.id("yesRadio"));
//        chromeDriver.executeScript("arguments[0].click()", yesRadioButton);
        //select yes button radio with executorJava

        WebElement yesRadioButtonLabel = chromeDriver.findElement(By.cssSelector("label[for = 'yesRadio']"));
        yesRadioButtonLabel.click();
        //select yes radio button by label

        quitChromeDriver();
    }

    @Test(description = "verify how to select impressive radio button")
    public void impressiveRadioButtonTest(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/radio-button");
//        WebElement impressiveRadioButtonLabel = chromeDriver.findElement(By.cssSelector("label[for = 'impressiveRadio']"));
//        impressiveRadioButtonLabel.click();
        //select yes radio button by label

        WebElement impressive = chromeDriver.findElement(By.id("impressiveRadio"));
        chromeDriver.executeScript("arguments[0].click", impressive);
        //select yes button radio with executorJava

        quitChromeDriver();
    }
}