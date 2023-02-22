package alinatinca.NotionsOfTheory.TestNG;

import alinatinca.NotionsOfTheory.SeleniumBasic2.BaseTest;
import alinatinca.driver.BrowserManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AssertsExamples extends BaseTest {
    //Asserts are used for verify of methods

    @Test(description = "verify if there are 6 cards on Demoqa web page")
    public void assertBasicTest(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/");
        //Navigate to Demoqa web page

        List<WebElement> cards = chromeDriver.findElements(By.className("card"));

        Assert.assertEquals(cards.size(), 6, "Wrong card size");
        //verify that there are 6 cards on this web page

        //first parameter is the value found on the web page (actual value);
        //the second parameter is the value we expect
        //optional, the third parameter is a message used when this test is fail
    }

    @Test(description = "verify if the messages are displayed after the buttons are clicked")
    public void assertEqualsForMessageOfButtonTest() throws IOException {
        try{
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://demoqa.com/buttons");
            //Navigate to Demoqa web page
            WebElement doubleClickMeButton = chromeDriver.findElement(By.id("doubleClickBtn"));
            Actions actions = new Actions(chromeDriver);
            //create an object of action class and pass reference of Webdriver as a parameter to its constructor
            actions.doubleClick(doubleClickMeButton).build().perform();
            //double click on the button from the page, called double click me
            WebElement messageDisplayed = chromeDriver.findElement(By.id("doubleClickMessage"));
            Assert.assertEquals(messageDisplayed.getText(),
                    "You have done a double click",
                    "Double click was unsuccessful!");

            System.out.println("Intentionally throw an exception to catch below (For screenshot!)");
            throw new NoSuchElementException("Custom exception");

        }catch (Exception e){
            if(chromeDriver !=null){
                File sourceFile = chromeDriver.getScreenshotAs(OutputType.FILE);
                File destinationFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\NotionsOfTheory\\TestNG\\ScreenshotForFirstButton.png");
                FileUtils.copyFile(sourceFile, destinationFile);
            }
        }finally {
            quitChromeDriver();
        }
    }

    @Test(description = "demonstration of AssertNotEquals - verify that url after login is not equals with url before login")
    public void assertNotEqualsForLoginTest() throws IOException {
        try{

            String urlAfterLogin = "https://katalon-demo-cura.herokuapp.com/#appointment";
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.manage().window().maximize();
            chromeDriver.get("https://katalon-demo-cura.herokuapp.com/");
            System.out.println("Navigate to Cura Healthcare Service web page");

            //Login Steps
            WebElement homeButton = chromeDriver.findElement(By.id("menu-toggle"));
            homeButton.click();
            WebElement loginButton = chromeDriver.findElement(By.cssSelector("a[href = 'profile.php#login']"));
            loginButton.click();
            WebElement username = chromeDriver.findElement(By.cssSelector("#txt-username"));
            username.sendKeys("John Doe");
            WebElement password = chromeDriver.findElement(By.cssSelector("#txt-password"));
            password.sendKeys("ThisIsNotAPassword");
            WebElement login = chromeDriver.findElement(By.cssSelector("#btn-login"));
            login.click();

            //verify that url after login is not equals with url before login
            Assert.assertNotEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/",
                    "Login was unsuccessfuly!");
            //or
//            Assert.assertTrue(chromeDriver.getCurrentUrl().equals(urlAfterLogin),
//                    "URL does not match!");

            //Intentionally throw an exception to catch it below! (for screenshot)
            throw new Exception("Custom exception");

        }catch (Exception e){

            File sourceFile = chromeDriver.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\NotionsOfTheory\\TestNG\\ScreenshotForLoginTest.png");
            FileUtils.copyFile(sourceFile, destinationFile);
            System.out.println("Exception has been caught!");
            System.out.println("AssertNotEquals Test passed!");
//            System.out.println("AssertTrue Test passed!");
        }finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify that is displayed some elements")
    public void isDisplayedTest() {
        try{
            chromeDriver = BrowserManager.createChromeDriver();
            chromeDriver.get("https://www.google.com");

            // Check that “Google Search box” is displayed or not. If Search box is displayed, it will return true.
            WebElement searchBox = chromeDriver.findElement(By.cssSelector("input[class ='gLFyf']"));
            if (searchBox.isDisplayed()) {
                System.out.println("Search box is visible. Return: " + searchBox.isDisplayed());
            } else {
                System.out.println("Search box is not visible. Return: " + searchBox.isDisplayed());
            }

//            // Check that "Google Search button" is displayed or not.
//            WebElement searchButton = chromeDriver. findElement(By.cssSelector("input[data-ved ='0ahUKEwjzqKfJrKn9AhVNtqQKHQ6XCmoQ4dUDCAk']"));
//            if (searchButton.isDisplayed()) {
//                System.out.println("Search button is visible. Return: " + searchButton.isDisplayed());
//            }else{
//                System.out.println("Search button is not visible. Return: " +searchButton.isDisplayed());
//            }
        }catch (Exception e){
            System.out.println("AssertFalse Test passed!");
        }finally {
            quitChromeDriver();
        }
    }

    @Test(description = "verify if a checkbox button is displayed on the web page")
    public void assertTrue(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");

        WebElement redCheckBox = chromeDriver.findElement(By.cssSelector("input[value = 'red']"));

        Assert.assertTrue(redCheckBox.isDisplayed());
        System.out.println("Red checkbox is displayed!");
    }

    @Test(description = "verify if a radio button is selected on the web page")
    public void assertIsSelectedTest(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
        WebElement ieRadioButton = chromeDriver.findElement(By.cssSelector("input[value = 'IE']"));

        Assert.assertTrue(ieRadioButton.isSelected());
        System.out.println("Red checkbox is selected!");
    }

    @Test(description = "verify the tittle on the web page")
    public void assertFalseTest(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://www.browserstack.com/");

        Boolean titleOnTheWebPage = chromeDriver.getTitle().equalsIgnoreCase("App & Browser Testing Made Not Easy");
        //verify in a boolean variabile if the title on the web page is the above
        Assert.assertFalse(titleOnTheWebPage);
        //it is false because on the page the tittle is: App & Browser Testing Made Easy
        System.out.println("AssertFalse Test passed!");
    }

    @Test(description = "verify if an element on the web page is enabled")
    public void assertIsEnabledTest(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://www.google.com");

        // Compare expected title of the page with actual title of the page and print the result.
        String expectedTitle = "Google";
        String actualTittle = chromeDriver.getTitle();

        if(expectedTitle.equals(actualTittle)){
            System.out.println("Verication Successfull - Correct title is displayed on the home webpage!");
        }else{
            System.out.println("Verification Failed - Incorrect title is displayed on the home webpage!");
        }
    }

    @Test(description = "verify if the accessed url is the same")
    public void assertFalseTest2(){
        chromeDriver = BrowserManager.createChromeDriver();
        String mainUrl = "https://www.browserstack.com/";
        chromeDriver.get(mainUrl);

        Boolean url = chromeDriver.getPageSource().equalsIgnoreCase("https://demoqa.com/buttons");
        Assert.assertFalse(url.equals(chromeDriver.getCurrentUrl()), "Wrong Url");
    }

    @Test(description = "verify if a message is not displayed if the button has not been clicked before")
    public void assertFalseTest3(){
        chromeDriver = BrowserManager.createChromeDriver();
        chromeDriver.get("https://demoqa.com/buttons");
        //Navigate to Demoqa web page

        WebElement rightClickMeButton = chromeDriver.findElement(By.id("rightClickBtn"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(rightClickMeButton.isDisplayed(), "Right button is not displayed!");
    }
}