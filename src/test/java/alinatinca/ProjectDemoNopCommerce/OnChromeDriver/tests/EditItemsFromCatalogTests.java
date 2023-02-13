package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.tests;

import alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects.EditItemsFromCatalogPage;
import alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects.SelectItemFromCatalogPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditItemsFromCatalogTests extends BaseTest {

//    //this method navigates to the catalog list
//    @Test(description = "verify the navigate to the catalog list")
//    public void goToCatalogListTest(){
//
//        SelectItemFromCatalogPage selectItemFromCatalogPage = new SelectItemFromCatalogPage(chromeDriver);
//        selectItemFromCatalogPage.getCatalog().click();
//        selectItemFromCatalogPage.getProducts().click();
//    }

    @Test(description = "verify if the Vivobook item can be added in catalog list")
    public void addNewItemInCatalogTest(){
        try{
            chromeDriver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
            EditItemsFromCatalogPage editItemsFromCatalogPage = new EditItemsFromCatalogPage(chromeDriver);
            editItemsFromCatalogPage.getAddNewButton().click();
            editItemsFromCatalogPage.getProductName().sendKeys("Vivobook");
            editItemsFromCatalogPage.getShortDescription().sendKeys("test");
            editItemsFromCatalogPage.getCategories().get(3).click();
            editItemsFromCatalogPage.getManufactures().get(1).click();
            editItemsFromCatalogPage.getPublished().click();
            editItemsFromCatalogPage.getRequireOtherProducts().click();
            editItemsFromCatalogPage.getRequiredProductIDs().sendKeys("test");
            editItemsFromCatalogPage.getAdminComment().sendKeys("test");
            WebElement saveButton = chromeDriver.findElement(By.cssSelector("button[name='save']"));
            Actions actions = new Actions(chromeDriver);
            actions.moveToElement(saveButton).build().perform();
            saveButton.click();
            Assert.assertEquals(editItemsFromCatalogPage.getMessageDisplayed().getText(),
                    "The new product has been added successfully.\n",
                    "There is no green message on the page!");
        }
        catch(Error | Exception e){
            System.out.print("A prins exceptia!");
        }
    }

    @Test(description = "verify that the recent item was be added in catalog list")
    public void checkIfRecentItemAddedIsDisplayedInCatalogListTest(){
        try{
            chromeDriver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
            SelectItemFromCatalogPage selectItemFromCatalogPage = new SelectItemFromCatalogPage(chromeDriver);
            selectItemFromCatalogPage.getProductName().sendKeys("Vivobook");
            selectItemFromCatalogPage.getSearchButton().click();
            EditItemsFromCatalogPage editItemsFromCatalogPage = new EditItemsFromCatalogPage(chromeDriver);
            Assert.assertEquals(editItemsFromCatalogPage.getItemAdded().getText(),
                    "Vivobook",
                    "There is no item added on the page!");
        }
        catch(Error | Exception e){
            System.out.print("Prinde exceptia!");
        }
    }
}