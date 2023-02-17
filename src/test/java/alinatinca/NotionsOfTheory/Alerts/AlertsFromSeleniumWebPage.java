package alinatinca.NotionsOfTheory.Alerts;

import alinatinca.NotionsOfTheory.BaseTest;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AlertsFromSeleniumWebPage extends BaseTest {
//how to handle alert
    //Use Alert Class when want to display an important notification on the screen
    // (to give users a certian kind of information) or ask for permision (to perform a certian kind of info.) when click on alert popup

    @Test(description = "verify handling of the Simple Alert box")
    public void simpleAlertTest() {
        try {
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
            WebElement theFirstAlert = chromeDriver.findElement(By.id("simple"));
            theFirstAlert.click();
            System.out.println("Click on the first alert!");

            Alert firstAlert = chromeDriver.switchTo().alert();

            System.out.println("The text from alert pupop is: " + firstAlert.getText());
            //text displayed from alert popup
            firstAlert.accept();
            System.out.println("You accepted alert!");

        } catch (Exception e) {
            System.out.println("Exception has been caught!");
        } finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to handle the Confirmation Alert box")
    public void confirmationAlertTest(){
        try{
            chromeDriver  = BrowserManager.createChromeDriver();
            chromeDriver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
            WebElement theSecondAlert = chromeDriver.findElement(By.id("confirm"));
            theSecondAlert.click();
            System.out.println("The second alert has been clicked!");

            Alert secondAlert = chromeDriver.switchTo().alert();
            System.out.println("The text from alert pupop is: " + secondAlert.getText());
            WebElement messageDisplay = chromeDriver.findElement(By.id("demo"));

            if(secondAlert.getText().equalsIgnoreCase("This is a confirm alert. Do you want to accept or cancel?")){
                secondAlert.accept();
                System.out.println("Alert has been accepted!");
                System.out.println("The message that appears after the alert is accepted is: " + messageDisplay.getText());
            }else{
                secondAlert.dismiss();
                System.out.println("Alert has been dismissed!");
                System.out.println("The message that appears the alert is dismissed is: " + messageDisplay.getText());
        }}catch (Exception | Error e) {
//            System.out.println("Exception has been caught!");
            System.out.println("If alert has been accepted, it will appear the message: You Accepted Alert!");
            System.out.println("If alert has been dismmised, it will appear the message: You Dismissed Alert!");
        }finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to handle Confirmation Alert box - private case")
    public void Teo() {
        try {
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://demoqa.com/alerts");
            WebElement thirdAlertButton = chromeDriver.findElement(By.id("confirmButton"));
            thirdAlertButton.click();
            Thread.sleep(2000);
            Alert alert = chromeDriver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("Am intrat in catch");
        } finally {
            quitChromeDriver();
        }
    }
    @Test(description = "verify to handle Prompt Alert box")
    public void promptAlertTest(){
        try{
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
            WebElement theThirdAlert = chromeDriver.findElement(By.id("prompt"));
            theThirdAlert.click();
            Alert firstAlert = chromeDriver.switchTo().alert();
            System.out.println("The text from alert pupop is: " + firstAlert.getText());
            firstAlert.sendKeys("John");
            System.out.println("You enter John");
            firstAlert.accept();
            System.out.println("You accepted the alert!");
            WebElement messageDisplay = chromeDriver.findElement(By.id("prompt_demo"));
            System.out.println("The message that appear after the alert has been accepted is: " + messageDisplay.getText());
//            firstAlert.dismiss();
        }
        catch (Exception e){

        }finally {
            quitChromeDriver();
        }
    }
}