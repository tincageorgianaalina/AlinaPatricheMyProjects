package alinatinca.NotionsOfTheory;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerts extends BaseTest{
//how to handle alert
    //Use Alert Class when want to display an important notification on the screen
    // (to give users a certian kind of information) or ask for permision (to perform a certian kind of info.) when click on alert popup

    @Test(description = "verify handling of the Simple Alert box")
    public void simpleAlertTest1(){
        try{
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://demoqa.com/alerts");
            WebElement theFirstAlert = chromeDriver.findElement(By.id("alertButton"));
            theFirstAlert.click();

            Alert firstAlert = chromeDriver.switchTo().alert();
            //switching to the first Alert from webpage

            String getTextAlert = chromeDriver.switchTo().alert().getText();
            //display the text from Alert popup
            System.out.print(getTextAlert);

            if(getTextAlert.equalsIgnoreCase("You clicked a button")){
                firstAlert.accept();
                //it is not required
                System.out.print("It worked, the expected simple alert was displayed!");
                System.out.print("You accepted alert!");
            }else{
                firstAlert.dismiss();
                //it is not required
                System.out.print("Something went wrong, expected simple alert was not displayed!");
                System.out.print("You dismiss alert!");
            }
        }
        catch (NullPointerException e){
            System.out.print("Exception has been caught!");
        }finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to handle Confirmation Alert box")
    public void confirmAlertTest(){
        try {
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://demoqa.com/alerts");
            WebElement theThirdAlert = chromeDriver.findElement(By.id("confirmButton"));
            theThirdAlert.click();

            Alert thirdAlert = chromeDriver.switchTo().alert();
            //switching to the third alert from webpage

            String getTextAlert = chromeDriver.switchTo().alert().getText();
            //display the text from Alert popup
            System.out.print(getTextAlert);

            WebElement messageDisplay = chromeDriver.findElement(By.id("confirmResult"));
            //DE REVENIT

            if (getTextAlert.equalsIgnoreCase("Do you confirm action?")) {
                //if alert popup contents the message: Do you confirm action?
                thirdAlert.accept();
                //it is required
                System.out.print("It worked, the expected simple alert was displayed!");
                System.out.print("You accepted alert!");
            } else {
                thirdAlert.dismiss();
                //it is required
                System.out.print("Something went wrong, expected confirm alert was not displayed!");
                System.out.print("You dismissed alert!");
            }
        }catch (Exception e){
            System.out.print("Exception has been caught!");
        }finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to handle Prompt Alert box")
    public void promptBoxAlert(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/alerts");
        WebElement theFourThAlert = chromeDriver.findElement(By.id("promtButton"));
        theFourThAlert.click();
        theFourThAlert.sendKeys("Test");

        Alert fourThAlert = chromeDriver.switchTo().alert();
        fourThAlert.accept();

        WebElement displayMessage = chromeDriver.findElement(By.id("promptResult"));
        //find the message that appears after enter the message in alert popup
        String getTextAlert = displayMessage.getText();
        //display the meesage that appears after enter the message in alert popup
        System.out.print(getTextAlert);

        if(getTextAlert.equalsIgnoreCase("You entered Test")){
            System.out.print("Exact matched!");
        }else {
            System.out.print("Something went wrong!");
            System.out.print("Not displays any message!");
        }
    }

    @Test(description = "verify handling of the Simple Alert box")
    public void simpleAlertTest2(){
        try{
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
            WebElement theFirstAlert = chromeDriver.findElement(By.id("simple"));
            theFirstAlert.click();

            Alert firstAlert = chromeDriver.switchTo().alert();
            firstAlert.accept();

            String getTextAlert = chromeDriver.switchTo().alert().getText();
            //text displayed from alert popup
            System.out.print(getTextAlert);
        }
        catch(Exception e){
            System.out.println("Exception has been caught!");
        }finally {
            quitChromeDriver();
        }
    }

}



