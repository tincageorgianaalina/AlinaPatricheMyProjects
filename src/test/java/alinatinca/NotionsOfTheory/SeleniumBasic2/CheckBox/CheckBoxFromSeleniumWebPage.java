package alinatinca.NotionsOfTheory.SeleniumBasic2.CheckBox;

import alinatinca.NotionsOfTheory.SeleniumBasic2.BaseTest;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckBoxFromSeleniumWebPage extends BaseTest {
    //CheckBoxes are used when the user needs to choose one or more available options

    @Test(description = "verify how to select checkobox")
    public void orangeCheckBoxTest(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
        System.out.println("Navigate to Selenium web page!");

        WebElement redCheckBox = chromeDriver.findElement(By.cssSelector("#post-body-7702345506409447484 input:nth-child(3)"));

            System.out.println("Verify that the orange checkbox is enabled and visible on the page");
            if(redCheckBox.isEnabled() && redCheckBox.isDisplayed()){
                System.out.println("Orange checkbox is enabled and visible on the page!");
            }else{
                System.out.println("Orange checkbox is disabled and invisible on the page!");
            }

            System.out.println("Verify that the orange checkbox is not selected before clicking on it");
            if(!redCheckBox.isSelected()){
                System.out.println("Orange checkbox is not selected on the page!");
                redCheckBox.click();
                System.out.println("Orange checkbox has been selected on the page!");
            }else{
                System.out.println("Orange checkbox is selected on the page!");
            }

            System.out.println("Verify that the orange checkbox is selected on the page");
            if(redCheckBox.isSelected()){
                System.out.println("Orange checkbox is selected on the page!");
                redCheckBox.click();
                System.out.println("Orange checkbox has been deselected!");
            }else{
                System.out.println("Something is wrong, the orange radio button is not selected on the page!");
            }
            quitChromeDriver();
    }
}