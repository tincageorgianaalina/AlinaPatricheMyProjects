package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.html.CSS;

public class AddANewCategoryPage {

    protected ChromeDriver chromeDriver;

    public AddANewCategoryPage(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(css = "nav.mt-2.nav-item.has-treeview:nth-child(2)")
    private WebElement catalogSection;

    public void getCatalogSection() {
        catalogSection.click();
    }

    @FindBy(css = "a[href=/Admin/Category/List]")
    private WebElement categoriesSection;

    public void getCategoriesSection() {
        categoriesSection.click();
    }

    @FindBy(css = "a[href=/Admin/Category/Create]")
    private WebElement addNewButton;

    public void getAddNewButton() {
        addNewButton.click();
    }

    @FindBy(id = "Name")
    private WebElement nameField;

    public void getNameField() {
        nameField.sendKeys("TEST Laptop Asus Vivobook");
    }

    @FindBy(xpath = "//textarea[@id=\"Description\"]")
    private WebElement descriptionField;

    public void getDescriptionField() {
        descriptionField.sendKeys("This is a short description!");
    }

    @FindBy(css = "input[title='file input']")
    private WebElement uploadFile;

    public void getUploadFile() {
        uploadFile.click();
    }

    @FindBy(className = "fas fa-search-plus")
    private WebElement seoSection;

    public void getSeoSection() {
        seoSection.click();
    }

    @FindBy(id = "MetaDescription")
    private WebElement metaDescriptionField;

    public void getMetaDescriptionField() {
        metaDescriptionField.sendKeys("TEST");
    }

    @FindBy(css = "button[name=\"save\"]")
    private WebElement saveButton;

    public void getSaveButton() {
        saveButton.click();
    }

    @FindBy(css = ".alert-dismissable")
    private WebElement messageConfirmation;

    public WebElement getMessageConfirmation() {
        return messageConfirmation;
    }
}