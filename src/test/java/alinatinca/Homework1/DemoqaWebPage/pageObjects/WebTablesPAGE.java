package alinatinca.Homework1.DemoqaWebPage.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WebTablesPAGE {

    ChromeDriver chromeDriver;

    public WebTablesPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }
    //Create the constructor that can define the required parameters for this test case

    //for test case 1
    //Find the elements on the web page
    @FindBy(css = ".menu-list >li:nth-child(4)")
    WebElement URL;

    @FindBy(id = "searchBox")
    WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div")
    WebElement cierraRow;

    //Create methods for these elements
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
    //Find the elements on the web page
    @FindBy(css = "#edit-record-3")
    WebElement editButton;

    @FindBy(css = "#salary")
    WebElement editSalaryField;

    @FindBy(css = "#submit")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[3]/div/div[5]")
    WebElement confirmationEditSalaryField;

    //Create methods for these elements
    public WebElement getEditButton() {
        return editButton;
    }

    public WebElement getEditSalaryField() {
        return editSalaryField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void getConfirmationForRegistrationForm() {
        Alert alert = chromeDriver.switchTo().alert();
        alert.getText();
        WebElement confirmationForRegistrationForm = chromeDriver.findElement(By.cssSelector(".modal-content"));
        Assert.assertTrue(confirmationForRegistrationForm.isDisplayed(), "Registration form is not displayed");
    }

    public WebElement getConfirmationEditSalaryField() {
        return confirmationEditSalaryField;
    }
}