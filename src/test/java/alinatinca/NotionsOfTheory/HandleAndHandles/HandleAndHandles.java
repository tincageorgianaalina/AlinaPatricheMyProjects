package alinatinca.NotionsOfTheory.HandleAndHandles;

import alinatinca.NotionsOfTheory.BaseTest;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class HandleAndHandles extends BaseTest {
//Use handle/handles when we want to open a new pupop or alerts or buttons

    @Test(description = "verify how to navigate between tabs using handle/handles")
    public void newTabTest(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/browser-windows");

//        chromeDriver.getWindowHandle();
//        //find and return the id of the parent page element, when it's focused on the parent web page (return String)
//        chromeDriver.getWindowHandles();
//        //find and return the IDs of the child web pages elements, when focused on the child web pages (return Set String)

        //For the parent web page
        String parentWebPage = chromeDriver.getWindowHandle();
        //return the id of the parent web page element!");
        WebElement newTabButton= chromeDriver.findElement(By.id("tabButton"));
        //find the first pupop from the parent web page
        newTabButton.click();
        //click on it

        //For the children web pages
        Set<String> childrenWebPages = chromeDriver.getWindowHandles();
        //return the id of the children web pages element!
        for (String webPages: childrenWebPages){
        //iterates the childrenWebPages set and acces the id element from it -> search in all the new web pages the id element
            if(!webPages.equals(parentWebPage)) {
                //iterates only if the web page is not the same as the parent web page
            chromeDriver.switchTo().window(webPages);
            //change the focus to a child web page
                break;
                //if find an id element in the children web page it stops

                //cauta elementul din intregul set de Stringuri, in toate paginile noi care se deschid, mutand focusul pe paginile noi,
                //si numai daca paginile in care cauta nu sunt aceleasi cu pagina parinte; dupa ce gaseste un element de pe pagina noua se opreste
            }}

        WebElement idElementFromChildWebPage = chromeDriver.findElement(By.id("sampleHeading"));
        //find the id element from the new page opened
        System.out.println(idElementFromChildWebPage.getText());
        //display it


//        //Return to the parent web page
//        chromeDriver.switchTo().window(parentWebPage);
//        WebElement newTa
          //DE REVENIT

    }
}
