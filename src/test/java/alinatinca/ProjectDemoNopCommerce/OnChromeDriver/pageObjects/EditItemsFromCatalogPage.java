package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EditItemsFromCatalogPage {

    ChromeDriver chromeDriver = null;

    //create the constructor
    public EditItemsFromCatalogPage(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    //identify all the useful elements from the page
    @FindBy(css = ".float-right a")
    WebElement addNewButton;

    @FindBy(css = "#Name")
    WebElement productName;

    @FindBy(id = "ShortDescription")
    WebElement shortDescription;

    @FindBy(id = "SelectedCategoryIds_taglist")
    List<WebElement> categories;

    @FindBy(id = "#SelectedManufacturerIds_taglist")
    List<WebElement> manufactures;

    @FindBy(id = "Published")
    WebElement published;

    @FindBy(id = "RequireOtherProducts")
    WebElement requireOtherProducts;

    @FindBy(id = "RequiredProductIds")
    WebElement requiredProductIDs;

    @FindBy(id = "AdminComment")
    WebElement adminComment;

//    @FindBy(css = "button[name='save']")
//    WebElement saveButton;

    @FindBy(css = ".alert.alert-success.alert-dismissable")
    WebElement messageDisplayed;

    @FindBy(css = ".odd td:nth-child(3)")
    WebElement itemAdded;

    //define and assign methods to each element from the page
    public WebElement getAddNewButton() {
        return addNewButton;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getShortDescription() {
        return shortDescription;
    }

    public List<WebElement> getCategories() {
        return categories;
    }

    public List<WebElement> getManufactures() {
        return manufactures;
    }

    public WebElement getPublished() {
        return published;
    }

    public WebElement getRequireOtherProducts() {
        return requireOtherProducts;
    }

    public WebElement getRequiredProductIDs() {
        return requiredProductIDs;
    }

    public WebElement getAdminComment() {
        return adminComment;
    }

//    public WebElement getSaveButton() {
//        return saveButton;
//    }

    public WebElement getMessageDisplayed() {
        return messageDisplayed;
    }

    public WebElement getItemAdded() {
        return itemAdded;
    }
}