package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectItemFromCatalogPage {

    //create the useful attributes
    protected ChromeDriver chromeDriver;
    public static final String PRODUCT_LIST_APPLE_ITEM_CSS = "#products-grid tbody tr";
    public static final String PRODUCT_LIST_NIKON_CAMERA_ITEM_CSS = "#products-grid tbody tr:nth-child(14)";

    //create the LoginPage constructor
    public SelectItemFromCatalogPage(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    //identify all the useful elements from the page
    @FindBy(css = "nav.mt-2 .nav-item.has-treeview:nth-child(2)")
    private WebElement catalog;

    @FindBy(xpath = "//a[@href='/Admin/Product/List']")
    private WebElement products;

    @FindBy(css = "input[id='SearchProductName']")
    private WebElement productName;

    @FindBy(id = "search-products")
    private WebElement searchButton;

    @FindBy(css = "#products-grid tbody tr")
    private List<WebElement> productsListForAppleMacItem;

    @FindBy(css ="#products-grid tbody tr:nth-child(14)")
    private List<WebElement> productsListForNikonCameraItem;

    @FindBy(css = "#products-grid tbody tr td:nth-child(3)")
    private List<WebElement> itemAppleMacFromCatalog;

    @FindBy(css = "#products-grid tbody tr:nth-child(14) td:nth-child(3)")
    private List<WebElement> itemNikonCameraFromCatalog;

    //define and assign methods to each element from the page
    public WebElement getCatalog() {
        return catalog;
    }

    public WebElement getProducts() {
        return products;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public List<WebElement> getProductsListForAppleMacItem() {
        return productsListForAppleMacItem;
    }

    public List<WebElement> getProductsListForNikonCameraItem() {
        return productsListForNikonCameraItem;
    }

    public List<WebElement> getItemAppleMacFromCatalog() {
        return itemAppleMacFromCatalog;
    }

    public List<WebElement> getItemNikonCameraFromCatalog() {
        return itemNikonCameraFromCatalog;
    }
}