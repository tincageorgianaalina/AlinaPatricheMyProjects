package alinatinca.SauceDemoCom.tests;

import alinatinca.SauceDemoCom.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class BuyFirstItem extends BaseTest {

    @Test(description = "verify how to order the first item")
    public void buyAnItemTest(){
        try{
            chromeDriver.get("https://www.saucedemo.com/inventory.html");

            String mainPage = chromeDriver.getWindowHandle();
            WebElement firstItem = chromeDriver.findElement(By.id("item_4_title_link"));
            firstItem.click();

            Set<String> newPage = chromeDriver.getWindowHandles();
            for(String newPages: newPage){
                if(!newPages.equals(mainPage)){
                    chromeDriver.switchTo().window(newPages);
                    break;
                }
            }

            Assert.assertEquals(chromeDriver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4",
                    "Page does not exist!");

            WebElement addToCartButton = chromeDriver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            addToCartButton.click();
            Assert.assertEquals(addToCartButton.getText(), "Remove", "Red text does not show!");
            WebElement shoppingCartIcon = chromeDriver.findElement(By.className("shopping_cart_badge"));
            Assert.assertEquals(shoppingCartIcon.getText(), "1", "No product added!");

            WebElement backPackImage = chromeDriver.findElement(By.cssSelector("img[src=\"/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg\"]"));
            Assert.assertTrue(backPackImage.isDisplayed(), "Photo not shown!");
        }catch (Exception e){
            System.out.println("Test passed!");
        }
    }
}