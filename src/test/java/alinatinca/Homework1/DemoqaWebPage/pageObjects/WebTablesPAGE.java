package alinatinca.Homework1.DemoqaWebPage.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPAGE {

    ChromeDriver chromeDriver;

    public WebTablesPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    //for test case 1
    @FindBy(css = ".menu-list >li:nth-child(4)")
    WebElement URL;

    @FindBy(id = "searchBox")
    WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div")
    WebElement cierraRow;

    public void clickOnUrl(){
        URL.click();
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getCierraRow() {
        return cierraRow;
    }


    //for test case 2

//    @FindBy(css = "mr-2")
//    WebElement editButton;
//
//    @FindBy(css = ".modal-header")
//    WebElement confirmationForRegistrationForm;
//
//    @FindBy(css = ".col-md-9.col-sm-12 > input[placeholder ='Salary']")
//    WebElement editSalaryField;
//
//    @FindBy(id = "submit")
//    WebElement submitButton;
//
//    @FindBy(css = "#delete-record-2")
//    WebElement deleteButton;
//
//    public WebElement getConfirmationForRegistrationForm() {
//        return confirmationForRegistrationForm;
//    }
//
//    public WebElement getEditSalaryField() {
//        return editSalaryField;
//    }
//
//    public WebElement getSubmitButton() {
//        return submitButton;
//    }
//
//    public WebElement getDeleteButton() {
//        return deleteButton;
//    }
}