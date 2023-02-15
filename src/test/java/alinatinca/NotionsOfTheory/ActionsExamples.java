package alinatinca.NotionsOfTheory;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.PrintStream;
import java.util.List;

public class ActionsExamples extends BaseTest {
    //Actions - simulates user interactions with the mouse or keyboard

    @Test(description = "verify how to move to element and than click on it")
    public void actionsScrollTest() {
        try {
            chromeDriver.get("https://demoqa.com/");
            List<WebElement> card = chromeDriver.findElements(By.cssSelector(".card"));
            WebElement sixthCard = card.get(5);
            //create an object of action class and pass reference od Webdriver as a parameter to its constructor
            Actions actions = new Actions(chromeDriver);
            actions.moveToElement(sixthCard);
            //scroll on the page to the sixth card
            sixthCard.click();
        } catch (Exception | Error e) {
            System.out.print("Exception has been caught!");
        } finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to perform double click action")
    public void actionsDoubleClickTest() {
        try {
            chromeDriver.get("https://demoqa.com/buttons");
            WebElement doubleClickMeButton = chromeDriver.findElement(By.id("doubleClickBtn"));
            Actions actions = new Actions(chromeDriver);
            actions.doubleClick(doubleClickMeButton).build().perform();
            //double click on the button from the page, called double click me}
        } catch (Exception | Error e) {
            System.out.print("Exception has been caught!");
        } finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to right click on web element")
    public void actionsContextClickTest() {
        try {
            chromeDriver.get("https://demoqa.com/buttons");
            WebElement rightClickMeButton = chromeDriver.findElement(By.cssSelector("#rightClickBtn"));
            Actions actions = new Actions(chromeDriver);
            actions.contextClick(rightClickMeButton).build().perform();
            //right click on the button
        } catch (Exception | Error e) {
            System.out.print("Exception has been caught!");
        } finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to click and hold on web element")
    public void actionsClickAndHoldTest() {
        try {
            chromeDriver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
            WebElement wordG = chromeDriver.findElement(By.xpath("//li[text()='G']"));
            Actions actions = new Actions(chromeDriver);
            actions.clickAndHold(wordG).build().perform();
            //click and hold(without releasing) on the wordG web element
        } catch (Exception | Error e) {
            System.out.print("Exception has been caught!");
        } finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify how to perform drag and drop on the page")
    public void actionsDragAndDropTest() {
        try {
            chromeDriver.get("https://selenium08.blogspot.com/2020/01/drag-me.html");
            WebElement src = chromeDriver.findElement(By.id("draggable"));
            WebElement trgt = chromeDriver.findElement(By.id("droppable"));
            Actions actions = new Actions(chromeDriver);
            actions.dragAndDrop(src, trgt).build().perform();
            System.out.println("Drag and drop action has been performed successfully");
        } catch (Exception | Error e) {
            System.out.print("Exception has been caught!");
        } finally {
            quitChromeDriver();
        }
    }

    @Test (description = "verify how to drag and drop on the page ")
    public void actionsDragAndDropByTest() {
        try{
            chromeDriver.get("https://demoqa.com/dragabble");
            WebElement src = chromeDriver.findElement(By.id("dragBox"));
            Actions actions = new Actions(chromeDriver);
            actions.dragAndDropBy(src, 200,150).build().perform();
        }
        catch (Exception | Error e){
            System.out.print("Exception has been caught!");
        }
        finally {
            quitChromeDriver();
        }
    }
}