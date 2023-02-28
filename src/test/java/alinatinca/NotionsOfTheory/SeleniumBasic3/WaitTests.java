package alinatinca.NotionsOfTheory.SeleniumBasic3;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTests {
//Waits are used to run test cases that involves a period of time until the actions on the web page it could be executed

//implicit wait - used always for any searching
//explicit wait - used only we need by wait on the web page

    //Implicit wait
    @Test(description = "verify how to run with implicit wait")
    public void implicitWaitTestEmagWebPage(){
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsForDesktop();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //waiting for 5 seconds until the button to be showed on the page
        chromeDriver.get("https://www.emag.ro/?captcha_status=ok");
        WebElement acceptButton = chromeDriver.findElement(By.cssSelector(".btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block"));
        acceptButton.click();
        chromeDriver.quit();
    }

    //Explicit wait
    @Test(description = "verify how to run with explicit wait on Emag web page")
    public void explicitWaitTestEmagWebPage(){
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsForDesktop();
        chromeDriver.get("https://www.emag.ro/?captcha_status=ok");
        //Navigate to Emag web page
        System.out.println("Navigate to Emag web page!");

        WebDriverWait explicittWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        //Wait for 5 seconds until the page to be loaded
        System.out.println("Wait for 5 seconds until the page to be loaded!");

        explicittWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='close']")));
        //Wait until the close button to be located and visible. <This is used for ElementClickInterceptedException!>
        System.out.println("Wait until the close button to be located and visible!");
        WebElement closeButton = chromeDriver.findElement(By.cssSelector("button[class='close']"));
        //Find the close button
        System.out.println("Find the close button!");
        closeButton.click();
        //Click on it
        System.out.println("Click on it!");

        explicittWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block")));
        //Wait until the accept button to be located and visible.
        System.out.println("Wait until the accept button to be located and visible!");
        WebElement acceptButton = chromeDriver.findElement(By.cssSelector(".btn.btn-primary.js-accept.gtm_h76e8zjgoo.btn-block"));
        //Find the accept button on the page
        System.out.println("Find the accept button on the page!");
        explicittWait.until(ExpectedConditions.elementToBeClickable(acceptButton));
        //Wait until the accept button to be clickable
        System.out.println("Wait until the accept button to be clickable!");
        acceptButton.click();
        System.out.println("Click on it!");

        explicittWait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='https://auth.emag.ro/user/login?ref=jy0z2o9t']"))));
        //Wait until the login button to be located and visible.
        System.out.println("Wait until the login button to be located and visible!");
        WebElement loginButton = chromeDriver.findElement(By.cssSelector("a[href='https://auth.emag.ro/user/login?ref=jy0z2o9t']"));
        //Find the login button on the page
        System.out.println("Find the login button on the page!");
        loginButton.click();
        System.out.println("Click on it!");

//        Assert.assertTrue(chromeDriver.getCurrentUrl().contains("user/login?ref=jy0z2o9t"), "Login page did not open!");
        //verify that next url contains this: user/login?ref=jy0z2o9t
        System.out.println("Verify that next url contains this: user/login?ref=jy0z2o9t!");
        WebElement message = chromeDriver.findElement(By.cssSelector(".auth-panel-header"));
        //find the message on the next page
        System.out.println("Find the message on the next page!");
        Assert.assertTrue(message.isDisplayed(), "Any message did not show!");
        //verify that message is displayed after passed to next page
        System.out.println("Verify that message is displayed after passed to next page!");

        chromeDriver.quit();
    }

    //Explciit Wait and Fluent Wait
    @Test(description = "verify how to use explicit wait")
    public void explicitWaitTestHerokuAppWebPage(){
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsForDesktop();
        chromeDriver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        //Navigate to Heroku Web Page
        WebDriverWait explicitWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        //Wait for 5 seconds that the page to be loaded
        WebElement firstButton = chromeDriver.findElement(By.id("delaygotobasic"));
        //Find the first button on the page
//        org.openqa.selenium.support.ui.Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(chromeDriver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

        WebElement messageBefore = chromeDriver.findElement(By.cssSelector(".explanation"));
        //find the message on the page
//        Assert.assertTrue(messageBefore.isDisplayed(), "Message is not displayed!");
        Assert.assertEquals(messageBefore.getText(), "The items below, when clicked, will trigger a redirect.",
                "Message is not correct!");
        //verify the message that shows on the page, before press on the first button
        firstButton.click();
        //click on this button

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated((By.id("goback"))));
        //wait until the goBack button is located and visible on the page (wait it shows on the page)
        WebElement goBack = chromeDriver.findElement(By.id("goback"));
        //Find the goBack button
        goBack.click();
        //click on goBack button

        WebElement messageAfter = chromeDriver.findElement(By.cssSelector(".explanation"));
        //find the message that appears on the page after the goBack button is clicked
        Assert.assertTrue(messageAfter.isDisplayed(), "Message is not correct!");
        //verify the message that shows on the page, after press on the goBack button
    }

    @Test(description = "verify how to use fluent wait")
    public void fluentWaitTestSephoraWebPage(){
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsForDesktop();
        chromeDriver.get("https://www.sephora.fr/");

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(chromeDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5));
//                .ignoring(NoSuchElementException.class);
        WebElement acceptButton = chromeDriver.findElement(By.cssSelector("button[id='footer_tc_privacy_button_3']"));
        acceptButton.click();
    }
}