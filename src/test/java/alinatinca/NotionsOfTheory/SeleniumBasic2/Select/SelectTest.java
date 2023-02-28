package alinatinca.NotionsOfTheory.SeleniumBasic2.Select;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.management.Descriptor;
import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SelectTest {

    @Test(description = "verify how to select dropdown value in Selenium WebDriver")
    public void selectDropdownTest() {
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsForDesktop();
        chromeDriver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
        //Navigate to Selenium Web Page
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Wait for some time to load the whole web page.

        WebElement dropdown = chromeDriver.findElement(By.cssSelector("select[name = 'country']"));
        //locate dropdown element on web page

        //Verify the dropdown is enabled and visible on the page
//        Assert.assertTrue(dropdown.isDisplayed(), "Dropdown is not visible on the page!");
        //or
        if (dropdown.isDisplayed() && dropdown.isEnabled()) {
            System.out.println("Dropdown is visible and enabled!");
        } else {
            System.out.println("Dropdown is not visible on the page!");
        }

        Select select = new Select(dropdown);
        //crate an object of Select class and pass the dropdown of type WebElement as an argument

        //Verify that dropdown does not allow the multiple selections
        if (select.isMultiple()) {
            System.out.println("Dropdown list accepts multiple choices!");
        } else {
            System.out.println("Dropdown list does not accepts multiple choices!");
        }

        //How to get the size of the list
        int listSizeDropdown = select.getOptions().size();
        //call getOptions() method to get all options of list.  size() method is used to get size of list
        System.out.println("List size: " + listSizeDropdown);

        //Verify that "Category" is selected as an option or not
        String getTextForCategory = select.getFirstSelectedOption().getText();

        //Show all elements from list
        String getTextAllElement = select.getWrappedElement().getText();
        System.out.println("Option chosen is: " + getTextAllElement);

        //Display the 5th element from list
        String getTextAndorra = select.getOptions().get(5).getText();
        System.out.println("Option chosen is: " + getTextAndorra);
    }

    @Test(description = "verify how to handle dropdown in selenium by value or index")
    public void handleDropdownTest() {
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsForDesktop();
        chromeDriver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
        //Navigate to Selenium web page

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait for some time to load the whole web page

        WebElement dropdown = chromeDriver.findElement(By.cssSelector("select[name = 'country']"));
        //Locate dropdown element on web page

        Select select = new Select(dropdown);
        //Crate an object of Select class and pass the dropdown of type WebElement as an argument

        //Select the option "USA" by sending its value attribute
        select.selectByValue("US");
        System.out.println("Option is successfully selected");

        //Select the option "United Kingdom" by sending its value attribute
        select.selectByValue("GB");
        System.out.println("Option is successfully selected");
    }

    @Test(description = "verify how to select multiple values in dropdown using selenium Webdriver")
    public void selectMultipleValueDropdownTest() {
        ChromeDriver chromeDriver = BrowserManager.getChromeDriverWithOptionsForDesktop();
        chromeDriver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Wait for some time to load the whole web page

        // Locate dropdown element on web page by By.xpath.
        WebElement dropdown = chromeDriver.findElement(By.xpath("//select[@name='Month']"));

        // Create an object of Select class and pass the dropdown of type WebElement as an argument.
        Select multiplechoicelist = new Select(dropdown);

        // Verify that dropdown allows the multiple-choice list or not
        if (multiplechoicelist.isMultiple()) {
            System.out.println("Dropdown allows multiple-choice list");
        } else {
            System.out.println("Dropdown does not allow multiple-choice");
        }

        // Now select the different choice by using visible text.
        multiplechoicelist.selectByVisibleText("July");
        multiplechoicelist.selectByVisibleText("May");
        multiplechoicelist.selectByVisibleText("March");
    }
}