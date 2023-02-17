package alinatinca.NotionsOfTheory.Alerts;

import alinatinca.NotionsOfTheory.BaseTest;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AlertsFromDemoqaWebPage extends BaseTest {
    @Test(description = "verify handling of the Simple Alert box")
    public void simpleAlertTest() {
        try {
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://demoqa.com/alerts");
            WebElement theFirstAlert = chromeDriver.findElement(By.id("alertButton"));
            theFirstAlert.click();

            Alert firstAlert = chromeDriver.switchTo().alert();
            //switching to the first Alert from webpage

            String getTextAlert = chromeDriver.switchTo().alert().getText();
            //display the text from Alert popup
            System.out.print(getTextAlert);

            if (getTextAlert.equalsIgnoreCase("You clicked a button")) {
                firstAlert.accept();
                //it is not required
                System.out.println("It worked, the expected simple alert was displayed!");
            } else {
                firstAlert.dismiss();
                //it is not required
                System.out.println("Something went wrong, expected simple alert was not displayed!");
            }
        } catch (NullPointerException e) {
            System.out.print("Exception has been caught!");
        } finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to handle Confirmation Alert box")
    public void confirmAlertTest() {
        try {
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://demoqa.com/alerts");
            WebElement theThirdAlert = chromeDriver.findElement(By.id("confirmButton"));
            theThirdAlert.click();

            Alert thirdAlert = chromeDriver.switchTo().alert();
            //switching to the third alert from webpage

            if (thirdAlert.getText().equalsIgnoreCase("Do you confirm action?")) {
                //if alert popup contents the message: Do you confirm action?
                thirdAlert.accept();
                System.out.println("It worked, the expected simple alert was displayed!");
                System.out.println("You accepted alert!");
            } else {
                thirdAlert.dismiss();
                System.out.println("Something went wrong, expected confirm alert was not displayed!");
                System.out.println("You dismissed alert!");
            }
        } catch (Exception e) {
            System.out.print("Exception has been caught!");
        } finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to handle Prompt Alert box")
    public void promptBoxAlertTest() {
        try {
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://demoqa.com/alerts");
            WebElement theFourThAlert = chromeDriver.findElement(By.id("promtButton"));
            theFourThAlert.click();

            Alert fourAlert = chromeDriver.switchTo().alert();
            System.out.println("The text that appears in alert pupop is: " + fourAlert.getText());
            fourAlert.sendKeys("New data");
            System.out.println("You entered new data in alert pupop");
//            fourAlert.accept();
//            System.out.println("Alert has been accepted!");
            WebElement messageDisplay = chromeDriver.findElement(By.id("promptResult"));
//            System.out.println("The message that appears after the alert is accepted is: " + messageDisplay.getText());
            fourAlert.dismiss();

        } catch (Exception | Error e) {
//            System.out.println("Exception has been caught!");
            System.out.println("Alert has been dismissed because you dismissed it!");
        } finally {
            quitChromeDriver();
        }
    }
}