package alinatinca.NotionsOfTheory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
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
        ChromeDriver chromeDriver = null;
        try {
            chromeDriver.get("https://demoqa.com/");
            List<WebElement> card = chromeDriver.findElements(By.cssSelector(".card"));
            WebElement sixthCard = card.get(5);
            //create an object of action class and pass reference od Webdriver as a parameter to its constructor
            Actions actions = new Actions(chromeDriver);
            actions.moveToElement(sixthCard);
            //scroll on the page to the sixth card
            sixthCard.click();

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
}