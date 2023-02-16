package alinatinca.NotionsOfTheory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Screenshots extends BaseTest {
    //Use screenshots class when any test cases doesn't run

    @Test(description = "verify how to move to element and than click on it")
    public void actionsScrollTest()  {

        try {
            chromeDriver.get("https://demoqa.com/");
            List<WebElement> card = chromeDriver.findElements(By.cssSelector(".card"));
            WebElement sixthCard = card.get(5);
            //create an object of action class and pass reference od Webdriver as a parameter to its constructor
            Actions actions = new Actions(chromeDriver);
            actions.moveToElement(sixthCard);
            //scroll on the page to the sixth card
            sixthCard.click();
            File screenshot = chromeDriver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("C:\\Users\\Home\\IdeaProjects\\Screenshot.png"));


//            File file = chromeDriver.getScreenshotAs(OutputType.FILE);
//            File destFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\NotionsOfTheory\\Screenshot1.png.png");
////            File destFile = new File("C:\\Users\\Home\\IdeaProjects\\poza.png");
//            FileUtils.copyFile(file,destFile);
//            System.out.print("The screenshot has been created for this test case!");
//            //take a screenshot
        } catch (Exception | Error e) {
            System.out.print("Exception has been caught!");
        } finally {
            quitChromeDriver();
        }
    }

//    public static void main(String[] args) {
////        //set the location of chrome browser
////        System.setProperty("user.dir", "C:\\Users\\Home\\IdeaProjects")
//        ChromeDriver chromeDriver = new ChromeDriver();
////        chromeDriver.get("https://demoqa.com");
//        File screenshot = chromeDriver.getScreenshotAs(OutputType.FILE);
//        try{
//            FileUtils.copyFile(screenshot, new File("C:\\Users\\Home\\IdeaProjects\\Photos.png"));
//        }
//        catch(IOException e){
//            System.out.print(e.getMessage());
//        }
//        chromeDriver.close();
//    }
}