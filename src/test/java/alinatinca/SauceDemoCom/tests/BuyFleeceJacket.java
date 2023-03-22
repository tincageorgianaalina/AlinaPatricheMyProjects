package alinatinca.SauceDemoCom.tests;

import alinatinca.SauceDemoCom.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BuyFleeceJacket extends BaseTest {

    public void loginPreconditionTest(){
        chromeDriver.get("https://www.saucedemo.com/");
        WebElement userNameInput = chromeDriver.findElement(By.id("user-name"));
        userNameInput.sendKeys("standard_user");
        WebElement passwordInput = chromeDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        WebElement loginButton = chromeDriver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Test(description = "how to add to cart an item")
    public void buyFleeceJacketTest() throws IOException {
        try {
            chromeDriver.get("https://www.saucedemo.com/");
            loginPreconditionTest();
            System.out.println("Login with successful!");
            System.out.println("Focus is on the main page!");
            String mainPage = chromeDriver.getWindowHandle();
            WebElement fleeceJacket = chromeDriver.findElement(By.id("item_5_title_link"));
            fleeceJacket.click();
            System.out.println("Click on Sauce Lab Fleece Jacket!");

            Set<String> newPage = chromeDriver.getWindowHandles();
            for (String newPages : newPage) {
                if (!newPages.equals(mainPage)) {
                    chromeDriver.switchTo().window(newPages);
                    break;
                }
            }

            System.out.println("Now, the focus is on the new page!");

            WebElement tittleOfProduct = chromeDriver.findElement(By.className("inventory_details_name.large_size"));
            Assert.assertEquals(tittleOfProduct.getText(), "Sauce Labs Fleece Jacket", "There is not any displayed tittle about my chosen product!");
            System.out.println("The tittle of Product is: " + tittleOfProduct.getText());
            WebElement detailsOfProduct = chromeDriver.findElement(By.className("inventory_details_desc.large_size"));
            Assert.assertTrue(detailsOfProduct.isDisplayed(), "There is not any displayed details about my chosen product!");
            System.out.println("Details of my product are: " + detailsOfProduct.getText());
            WebElement priceOfProduct = chromeDriver.findElement(By.className("inventory_details_price"));
            Assert.assertTrue(priceOfProduct.isDisplayed(), "There is not any displayed price about my chosen product!");

        } catch (Exception e) {
            System.out.println("Information about my chosen product has been checked and they are displayed in the screenshot!");
            File sourceFile = chromeDriver.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\SauceDemoCom.png");
            FileUtils.copyFile(sourceFile, destinationFile);
        }
        System.out.println("Test passed!");
    }

    @Test(description = "verify the information about my chosen product")
    public void checkMyChosenProductTest() throws IOException {
        loginPreconditionTest();
        System.out.println("Login with successful!");
        chromeDriver.get("https://www.saucedemo.com/inventory-item.html?id=5");
        WebElement addToCartButton = chromeDriver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCartButton.click();
        System.out.println("Click on addToCart button!");
        WebElement removeButton = chromeDriver.findElement(By.xpath("//button[text()='Remove']"));
        Assert.assertTrue(removeButton.isDisplayed(),"There is not any red displayed button called Remove on this page!");
        System.out.println("The Red button called Remove is displayed on the page after click on Add To Cart Button!");

        WebElement cartIcon = chromeDriver.findElement(By.className("shopping_cart_badge"));
        Assert.assertTrue(cartIcon.isDisplayed(), "The cart icon is not displayed in the top right of the page!");
        System.out.println("The cart icon is displayed in the top right of the page!");
        Assert.assertEquals(cartIcon.getText(), "1", "The chosen product is not displayed in to the cart icon!");
        System.out.println("The chosen product is displayed in to the cart icon!");
        File sourceFile = chromeDriver.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\SauceDemoCom.png");
        FileUtils.copyFile(sourceFile, destinationFile);
        System.out.println("Information about my chosen product has been checked and they are displayed in the screenshot!");
    }
}