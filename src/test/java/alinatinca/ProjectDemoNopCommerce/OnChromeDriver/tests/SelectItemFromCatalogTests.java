package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.tests;

import alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects.SelectItemFromCatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectItemFromCatalogTests extends BaseTest {

    @Test(description = "verify if can select some products from the catalog")
    public void selectItemFromCatalogTest(){
//        chromeDriver.get("https://admin-demo.nopcommerce.com/Admin/Product/List");
        SelectItemFromCatalogPage selectItemFromCatalogPage = new SelectItemFromCatalogPage(chromeDriver);
        selectItemFromCatalogPage.getCatalog().click();
        selectItemFromCatalogPage.getProducts().click();
        selectItemFromCatalogPage.getProductName().sendKeys("Apple MacBook Pro 13-inch");
        selectItemFromCatalogPage.getSearchButton().click();
        Assert.assertEquals(selectItemFromCatalogPage.getItemSelectedFromList().size(),
                "4",
                "Search did not return the expected products!");
        Assert.assertEquals(selectItemFromCatalogPage.getProductsList().size(),
                "4", "Search did not return the expected product title size!");
    }

}
