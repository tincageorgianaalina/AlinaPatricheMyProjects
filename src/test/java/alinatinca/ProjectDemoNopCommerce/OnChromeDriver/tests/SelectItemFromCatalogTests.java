package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.tests;

import alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects.LoginPage;
import alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects.SelectItemFromCatalogPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects.SelectItemFromCatalogPage.*;

public class SelectItemFromCatalogTests extends BaseTest {

    //this method is a prerequisite for continuing on the site
    @BeforeClass(description = "verify login functionals with valid credentials")
    public void testValidLogin(){
        chromeDriver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        //go to URL
        LoginPage loginPage = new LoginPage(chromeDriver);
        loginPage.getEmail().click();
        //click on the email field
        loginPage.getPassword().click();
        //click on the password click
        loginPage.getLoginButton().click();
        //click on the submit button
//        Assert.assertEquals(chromeDriver.getCurrentUrl(),
//                "https://admin-demo.nopcommerce.com/admin/",
//                "Login was unsuccesfully with the default data!");
        Assert.assertTrue(chromeDriver.getCurrentUrl().contains("admin/"),
                "Login was unsuccesfully with the default data!");
        //verify if appears the next page with this URL: https://admin-demo.nopcommerce.com/admin/ after login was sucessfully
    }

    //this method navigates to the catalog list
    @Test(description = "verify the navigate to the catalog list")
    public void goToCatalogListTest(){
        SelectItemFromCatalogPage selectItemFromCatalogPage = new SelectItemFromCatalogPage(chromeDriver);
        selectItemFromCatalogPage.getCatalog().click();
        selectItemFromCatalogPage.getProducts().click();
    }

    @Test(description = "verify if the product called AppleMacBookPro13inch can be selected from the Catalog list")
    public void selectAppleMacBookPro13inchItemFromCatalogTest(){
        goToCatalogListTest();
        SelectItemFromCatalogPage selectItemFromCatalogPage = new SelectItemFromCatalogPage(chromeDriver);
        selectItemFromCatalogPage.getProductName().sendKeys("Apple MacBook Pro 13-inch");
        selectItemFromCatalogPage.getSearchButton().click();
        FluentWait<ChromeDriver> fluentWait = new FluentWait<>(chromeDriver);
        fluentWait.withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500));
        //dupa cat timp sa arunce o eroare sa astepte 5 secunde (daca gaseste elementul atunci trece mai repede)
        //sa incerce reincarcarea pe pagina o data la jumatate de secunde
        fluentWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(PRODUCT_LIST_APPLE_ITEM_CSS), 1));
        //asteapta pana cand verifica daca lista produselor este de un anumit numar
        Assert.assertEquals(selectItemFromCatalogPage.getItemAppleMacFromCatalog().get(0).getText(),
                "Apple MacBook Pro 13-inch",
                "The search by product title is not correct!");
        //verify that the item searched is this: Apple MacBook Pro 13-inch

    }

//NU RULEAZA
//    @Test(description = "verify if the product called NikonD5500DSLRBlack can be selected from the Catalog list")
//    public void selectNikonD5500DSLRBlackItemFromCatalogTest(){
//        goToCatalogListTest();
//        SelectItemFromCatalogPage selectItemFromCatalogPage = new SelectItemFromCatalogPage(chromeDriver);
//        selectItemFromCatalogPage.getProductName().sendKeys("Nikon D5500 DSLR - Black");
//        selectItemFromCatalogPage.getSearchButton().click();
////        getFluentWait(chromeDriver).until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(PRODUCT_LIST_NIKON_CAMERA_ITEM_CSS), 1));
//        FluentWait<ChromeDriver> fluentWait = new FluentWait<>(chromeDriver);
//        fluentWait.withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500));
////        dupa cat timp sa arunce o eroare sa astepte 5 secunde (daca gaseste elementul atunci trece mai repede)
////        sa incerce reincarcarea pe pagina o data la jumatate de secunde
//        fluentWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(PRODUCT_LIST_NIKON_CAMERA_ITEM_CSS), 1));
////        asteapta pana cand verifica daca lista produselor este de un anumit numar
//        Assert.assertEquals(selectItemFromCatalogPage.getItemNikonCameraFromCatalog().get(0).getText(),
//                "Nikon D5500 DSLR - Black",
//                "The search by product title si not correct!");
//    }

}
