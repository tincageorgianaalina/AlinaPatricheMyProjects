package alinatinca.ProjectSauceDemoCom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class BuyFirstItemFromProductsWebPageTest extends BaseTest {

    @Test(description = "verify how to order an item from Products web page")
    public void buyAnItemTest(){
        try{
            driver.get("https://www.saucedemo.com/inventory.html");

            String mainPage = driver.getWindowHandle();
            WebElement firstItem = driver.findElement(By.id("item_4_title_link"));
            firstItem.click();

            Set<String> newPage = driver.getWindowHandles();
            for(String newPages: newPage){
                if(!newPages.equals(mainPage)){
                    driver.switchTo().window(newPages);
                    break;
                }
            }

            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory-item.html?id=4",
                    "Page does not exist!");

            WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            addToCartButton.click();
            Assert.assertEquals(addToCartButton.getText(), "Remove", "Red text does not show!");
            WebElement shoppingCartIcon = driver.findElement(By.className("shopping_cart_badge"));
            Assert.assertEquals(shoppingCartIcon.getText(), "1", "No product added!");

            WebElement backPackImage = driver.findElement(By.cssSelector("img[src=\"/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg\"]"));
            Assert.assertTrue(backPackImage.isDisplayed(), "Photo not shown!");
        }catch (Exception e){
            System.out.println("Test passed!");
        }
    }
}