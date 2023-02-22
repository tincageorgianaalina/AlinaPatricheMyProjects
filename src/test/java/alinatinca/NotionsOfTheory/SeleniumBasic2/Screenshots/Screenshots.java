package alinatinca.NotionsOfTheory.SeleniumBasic2.Screenshots;

import alinatinca.NotionsOfTheory.SeleniumBasic2.BaseTest;
import alinatinca.driver.BrowserManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Screenshots extends BaseTest {
    //Use screenshots class when any test cases doesn't run

    @Test(description = "verify how to take a screenshot for a test case")
    public void screenshotTest1() throws IOException {
        try{
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://demoqa.com/");
            //Navigate to Demoqa web page
            System.out.println("Navigate to Demoqa web page");
            List<WebElement> card = chromeDriver.findElements(By.cssSelector(".card"));
            WebElement sixThCard = card.get(5);
            //Acces from list the sixth card
            System.out.println("Find the sixth card");
            Actions action = new Actions(chromeDriver);
            action.moveToElement(sixThCard).build().perform();
            //scroll on the page to the sixth card
            System.out.println("Scroll on the page to the sixth card");
            sixThCard.click();
            System.out.println("Click on the sixth card");

            System.out.println("Intentionally throw an exception to catch it below (For screenshot!)");
            throw new NoSuchElementException("Custom exception");
        }
        catch (NoSuchElementException e) {
            if (chromeDriver != null) {
                File sourceFile = chromeDriver.getScreenshotAs(OutputType.FILE);
                //call getScreenshotAs method to create image file
                File destinationFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\NotionsOfTheory\\Screenshots.png.png");
                //move image file to new destination
//                File destFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\NotionsOfTheory\\Screenshots1.png.png");
                FileUtils.copyFile(sourceFile, destinationFile);
                //copy file at destination
                System.out.println("It takes a screenshot for this test case");
                System.out.println("Exception has been caught!");
            }
        }finally {
            quitChromeDriver();
        }
        System.out.println("Test is passed!");
    }

    @Test(description = "verify how to make a screenshot for a test case with a fake alert")
    public void screenshotTest2() throws IOException {
        try{
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
            System.out.println("Navigate to Heroku web page");
            WebElement theFirstAlert = chromeDriver.findElement(By.id("fakealert"));
            theFirstAlert.click();
            System.out.println("Click on the first alert");
            Alert firstAlert = chromeDriver.switchTo().alert();
            System.out.println("The text from alert box is: " + firstAlert.getText());
            firstAlert.accept();
            System.out.println("Alert has been accepted!");

            System.out.println("Intentionally throw an exception to catch below");
            throw new NoSuchElementException("Custom exception");

        }catch (Exception e){
//            System.out.println("Exception has been caught!");
            System.out.println("Alert has been accepted!");

            File sourceFile = chromeDriver.getScreenshotAs(OutputType.FILE);
            File destFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\NotionsOfTheory\\ScreenshotForFakeAlert.png");
            FileUtils.copyFile(sourceFile, destFile);
            System.out.println("Screenshot has been taken!");
        }finally {
            quitChromeDriver();
        }
        System.out.println("Test is passed!");
    }
}