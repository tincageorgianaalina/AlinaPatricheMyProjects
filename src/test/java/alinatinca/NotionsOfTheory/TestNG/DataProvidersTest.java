package alinatinca.NotionsOfTheory.TestNG;

import alinatinca.NotionsOfTheory.SeleniumBasic2.BaseTest;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersTest extends DataProvidersPage {
//Data Provider are used in test cases to pass the parameters in the test function whenever is needed

    //Verify the links for each domain form the Demoqa web page  and assert if there is the same image on every page
    @DataProvider(name="dataProviderDemoqaTest1")
    public Object[][] dataProviderDemoqaTest1(){
        return new Object[][]{
                {"/elements"},
                {"/forms"},
                {"/alertsWindows"},
                {"/widgets"},
                {"/interaction"},
                {"/books"}
        };
    }

    @Test(dataProvider = "dataProviderDemoqaTest1")
    public void getDataDemoqaTest1(String path){
        ChromeDriver chromeDriver;
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com" + path);
        WebElement image = chromeDriver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']"));
        //find the common image for every page
        Assert.assertTrue(image.isDisplayed(), "Image is not displayed!");
        //verify if there is the same image on every page
        System.out.println("Test passed!");
        chromeDriver.quit();
    }

    //Verify the links for each domain form the Amazon web page and assert if there is the same image on every page (extends DataProviderPage)
    @Test(dataProvider = "dataProviderAmazonTest2", dataProviderClass = DataProvidersPage.class)
    //it must be specified from which class the method is definited
    public void getDataAmazonTest2(String path){
        ChromeDriver chromeDriver;
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://www.amazon.com" + path);
        WebElement logo = chromeDriver.findElement(By.cssSelector("a[aria-label = 'Amazon']"));
        //search the common logo for every page
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed!");
        //verify if there is the same logo on every page
        System.out.println("Test passed!");
        chromeDriver.quit();
    }
}