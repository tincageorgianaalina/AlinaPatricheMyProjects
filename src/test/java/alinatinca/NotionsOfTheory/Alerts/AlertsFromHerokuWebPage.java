package alinatinca.NotionsOfTheory.Alerts;

import alinatinca.NotionsOfTheory.BaseTest;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.swing.*;
import java.net.FileNameMap;

public class AlertsFromHerokuWebPage extends BaseTest {

    @Test(description = "verify how to handle Simple Alert box")
    public void simpleAlertTest1() {
        try {
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
            WebElement theFirstAlert = chromeDriver.findElement(By.id("alertexamples"));
            theFirstAlert.click();
            Alert firstAlert = chromeDriver.switchTo().alert();
            System.out.println("The text from the simple alert box is: " + firstAlert.getText());
            firstAlert.accept();
            System.out.println("The alert is accepted!");
            isAlertOpened(chromeDriver);
        } finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to handle Confirmation Alert box")
    public void confirmAlertTest2() {
        try {
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
            WebElement secondAlert = chromeDriver.findElement(By.id("confirmexample"));
            secondAlert.click();
            isAlertAcceptedForConfirmAlertTest2(chromeDriver);
            isAlertOpened(chromeDriver);
        } finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to handle Prompt Alert box")
    public void promptAlertTest3() {
        try {
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
            WebElement thirdAlert = chromeDriver.findElement(By.id("promptexample"));
            thirdAlert.click();
            isAlertAcceptedForPromptAlertTest3(chromeDriver);
        } catch (Exception | Error e) {
            System.out.println("Exception has been caught!");
            System.out.println("Alert has been accepted!");
        } finally {
            quitChromeDriver();
        }
    }

    //methods for checking
    //this method describle if the alert remained opend after it closed
    public static boolean isAlertOpened(ChromeDriver chromeDriver) {
        try {
            chromeDriver.switchTo().alert();
            System.out.println("Alert remained opened!");
            return true;
        } catch (Exception | Error e) {
            return false;
        }
    }

    //this method verify the specific messages that could be displayed after the alert is accept or dismiss
    public static boolean isAlertAcceptedForConfirmAlertTest2(ChromeDriver chromeDriver) {
        Alert secondAlert = chromeDriver.switchTo().alert();
        System.out.println("The text from alert box is: " + secondAlert.getText());
        if (secondAlert.getText().equalsIgnoreCase("I am a confirm alert")) {
            secondAlert.accept();
            System.out.println("You accepted alert");
            return true;
        } else {
            secondAlert.dismiss();
            System.out.println("You dismissed alert");
            return false;
        }
    }

    //this method verify the specific messages that could be displayed after the alert is accept or dismiss
    public static boolean isAlertAcceptedForPromptAlertTest3(ChromeDriver chromeDriver) {
        Alert thirdAlert = chromeDriver.switchTo().alert();
        System.out.println("The text from alert box is: " + thirdAlert.getText());
        thirdAlert.sendKeys("John");
        System.out.println("You enter John in alert box");
        WebElement messageDisplay = chromeDriver.findElement(By.id("promptexplanation"));

        if (thirdAlert.getText().equalsIgnoreCase("I prompt you")) {
            thirdAlert.accept();
            System.out.println("You accepted alert");
            System.out.println("The message that appear after the alert is accepted is: " + messageDisplay.getText());
            return true;
        } else {
            thirdAlert.dismiss();
            System.out.println("You dismissed alert");
            System.out.println("The message that appear after the alert is dismissed is: " + messageDisplay.getText());
            return false;
        }
    }

    @Test(description = "verify a fake alert ")
    public void fakeAlertTest4(){
        try{
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
            WebElement theFirstAlert = chromeDriver.findElement(By.id("fakealert"));
            theFirstAlert.click();
            Alert firstAlert = chromeDriver.switchTo().alert();
            System.out.println("The text from alert box is: " + firstAlert.getText());
            firstAlert.accept();
            System.out.println("Alert has been accepted!");
        }
        catch (Exception e){
            System.out.println("Exception has been caught!");
            System.out.println("Alert has been accepted!");
        }finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify a fake alert")
    public void fakeAlertTest5(){
        try{
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
            WebElement theSecondAlert = chromeDriver.findElement(By.id("modaldialog"));
            theSecondAlert.click();
            Alert secondAlert = chromeDriver.switchTo().alert();
            System.out.println("The text from alert box is: " + secondAlert.getText());
            secondAlert.accept();
            System.out.println("Alert has been accepted!");
        }catch (Exception e){
            System.out.println("Exception has been caught!");
            System.out.println("Alert has been accepted!");
        }finally {
            quitChromeDriver();
        }
    }
}