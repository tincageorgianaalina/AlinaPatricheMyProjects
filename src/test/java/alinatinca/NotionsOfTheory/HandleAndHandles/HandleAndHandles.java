package alinatinca.NotionsOfTheory.HandleAndHandles;

import alinatinca.NotionsOfTheory.BaseTest;
import alinatinca.driver.BrowserManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class HandleAndHandles extends BaseTest {
//Use handle and handles when we want to interaction between more many web pages (or to open a new pupop or alerts or buttons)

//      chromeDriver.getWindowHandle();
//      find and return the id of the parent page element, when it's focused on the parent web page (return String)
//      chromeDriver.getWindowHandles();
//      find and return the idS of the children page elements, when focused on the child web pages (return Set String)

    @Test(description = "verify how to navigate between the parent web page and a new tab")
    public void newTabTest() {
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/browser-windows");
        System.out.println("Navigate to Demoqa web page!");

        //From the parent web page
        String parentWebPage = chromeDriver.getWindowHandle();
        //return the id of the parent web page element!; call this method
        System.out.println("Call getWindowHandle() method!");

        WebElement newTabPupop = chromeDriver.findElement(By.id("tabButton"));
        //find the first pupop from the parent web page
        System.out.println("Find the first pupop from tha parent web page!");
        newTabPupop.click();
        //click on it
        System.out.println("Click on this pupop!");
        System.out.println("The new tab has been opened but the focus remained on the parent web page!");


        //To the children web pages
        Set<String> childrenWebPages = chromeDriver.getWindowHandles();
        //return the id of the children web pages element!; call this method
        System.out.println("Call getWindowHandles() method!");
        for (String webPages : childrenWebPages) {
            //iterates the childrenWebPages set and acces the id element from it -> search in all the new web pages the id element
            if (!webPages.equals(parentWebPage)) {
                //iterates only if the web page is not the same as the parent web page
                chromeDriver.switchTo().window(webPages);
                //change the focus to a child web page
                break;
                //if find an id element in the children web page it stops

                //cauta elementul din intregul set de Stringuri, in toate paginile noi care se deschid, mutand focusul pe paginile noi,
                //si numai daca paginile in care cauta nu sunt aceleasi cu pagina parinte; dupa ce gaseste un element de pe pagina noua se opreste
            }
        }

        WebElement paragraphFromNewPage = chromeDriver.findElement(By.id("sampleHeading"));
        //find the id element from the new page opened (from child web page)
        System.out.println("The paragraph finded from the new web page is: " + paragraphFromNewPage.getText());
        //display it

        //Return to the parent web page
        chromeDriver.switchTo().window(parentWebPage);
        //move the focus on the parent web page
        System.out.println("The focus has been mouved on the parent web page!");

        quitChromeDriver();
        System.out.println("All instances of the Chrome browser have been closed!");
    }

    @Test(description = "verify how to navigate between the parent window and a new window")
    public void newWindowTest(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/browser-windows");
        System.out.println("Navigate to Demoqa web page");

        //From the parent window
        String parentWindow = chromeDriver.getWindowHandle();
        System.out.println("Call getWindowHandle() method!");

        WebElement newWindowPupop = chromeDriver.findElement(By.id("windowButton"));
        //find the second pupop from the parent web page
        System.out.println("Find the second pupop from the parent web page!");
        newWindowPupop.click();
        //click on it
        System.out.println("Click on this pupop!");
        System.out.println("The new window has been opened but the focus remaind on the parent window!");

        //To the new window
        Set<String> childrenWindows = chromeDriver.getWindowHandles();
        System.out.println("Call getWindowHandles() method!");
        for (String windows: childrenWindows){
            if(!windows.equals(parentWindow)){
                chromeDriver.switchTo().window(windows);
                break;
            }
        }
        WebElement paragraphFromNewWindow = chromeDriver.findElement(By.id("sampleHeading"));
        System.out.println("The paragraph finded from the new window is: " + paragraphFromNewWindow.getText());

        //Return to the parent window
        chromeDriver.switchTo().window(parentWindow);
        System.out.println("The focus has been mouved on the parent window!");

        quitChromeDriver();
        System.out.println("All instances of the Chrome browser have been closed!");
    }

    //NU RULEAZA
    @Test(description = "verify how to navigate between a parent tab and a new tab")
    public void newWindowMessageTest() throws IOException {
        try{
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://demoqa.com/browser-windows");

            //From the parent tab
            String parentTab = chromeDriver.getWindowHandle();
            WebElement newWindowMessage = chromeDriver.findElement(By.id("messageWindowButton"));
            newWindowMessage.click();

            //To the new tab
            Set<String> newTabs = chromeDriver.getWindowHandles();
            System.out.println("Call getWindowHandles() method!");
            for(String tabs: newTabs){
                if(!tabs.equals(parentTab)){
                    chromeDriver.switchTo().window(tabs);
                    break;
                }
            }

            WebElement paragraphFromNewTab = chromeDriver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']"));
            System.out.println("The paragraph finded from the new window is: " + paragraphFromNewTab.getText());

            //Return to the parent tab
            chromeDriver.switchTo().window(parentTab);
            System.out.println("The focus has been mouved on the parent tab!");

            chromeDriver.close();

        }catch (NoSuchElementException e){
            File sourceFile = chromeDriver.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\NotionsOfTheory\\HandleAndHandles.png");
            FileUtils.copyFile(sourceFile, destinationFile);
        }finally {
            quitChromeDriver();
            System.out.println("All instances of the Chrome browser have been closed!");
        }
    }
}