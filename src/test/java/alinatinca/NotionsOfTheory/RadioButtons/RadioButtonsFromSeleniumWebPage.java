package alinatinca.NotionsOfTheory.RadioButtons;

import alinatinca.NotionsOfTheory.BaseTest;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RadioButtonsFromSeleniumWebPage extends BaseTest {
    //RadioButtons are used for the users that can choose one option from a set of items

    @Test(description = "verify how to select a radio button")
    public void redRadioButtonTest(){
        chromeDriver= BrowserManager.createChromeDriver();
        chromeDriver.get("https://selenium08.blogspot.com/2019/08/radio-buttons.html");
        System.out.println("Navigate to Selenium web page");
        WebElement redRadioButton = chromeDriver.findElement(By.cssSelector("input[name='red']"));

        System.out.println("Verify that red radio button is enabled and visible on the page");
        if(redRadioButton.isEnabled() && redRadioButton.isDisplayed()){
            System.out.println("Red radio button is enabled and visible on the page!");
        }else{
            System.out.println("Red radio button is disabled and invisible on the page!");
        }

        System.out.println("Verify that red radio button is not selected before clicking on it");
        if(!redRadioButton.isSelected()){
            System.out.println("Red radio button is not selected on the page!");
            redRadioButton.click();
            System.out.println("Red radio button has been selected on the page!");
        }

        System.out.println("Verify that red radio button is selected on the page");
        if(redRadioButton.isSelected()){
            System.out.println("Red radio button is selected on the page!");
        }else{
            System.out.println("Something is wrong, the red radio button is not selected on the page!");
            redRadioButton.click();
        }
        quitChromeDriver();
    }

    @Test(description = "verify how to select a radio button")
    public void blueRadioButtonTest(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://selenium08.blogspot.com/2019/08/radio-buttons.html");
        WebElement blueRadioButton = chromeDriver.findElement(By.cssSelector("input[name='blue']"));

        System.out.println("Verify that the blue radio button is enabled and visible on the page");
        if(blueRadioButton.isEnabled() && blueRadioButton.isDisplayed()){
            System.out.println("Blue radio button is enabled and visible on the page!");
        }else{
            System.out.println("Blue radio button is disabled and invisible on the page!");
        }

        System.out.println("Verify that the blue radio button is not selected before clicking on it");
        if(!blueRadioButton.isSelected()){
            System.out.println("Blue radio button is not selected!");
            blueRadioButton.click();
            System.out.println("Blue radio button has been selected on the page!");
        }

        System.out.println("Verify that the blue radio button is selected on the page");
        if(blueRadioButton.isSelected()){
            System.out.println("Blue radio button is selected on the page!");
        }else{
            System.out.println("Something is wrong, the blue radio button is not selected on the page!");
        }
        quitChromeDriver();
    }
}