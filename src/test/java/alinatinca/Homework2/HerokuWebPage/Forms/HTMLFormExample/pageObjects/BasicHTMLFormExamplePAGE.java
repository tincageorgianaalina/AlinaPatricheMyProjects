package alinatinca.Homework2.HerokuWebPage.Forms.HTMLFormExample.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;

public class BasicHTMLFormExamplePAGE {

    ChromeDriver chromeDriver;

    public BasicHTMLFormExamplePAGE(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(className = "explanation")
    WebElement paragraph;

    @FindBy(css = "input[name = 'username']")
    WebElement userName;

    @FindBy(css = "input[name = 'password']")
    WebElement password;

    @FindBy(css = "textarea[name = 'comments']")
    WebElement comment;

    @FindBy(css = "input[name = 'filename']")
    WebElement fileNameUpload;

    @FindBy(name = "checkboxes[]")
    List<WebElement> selectCheckBoxes;

    @FindBy(name = "radioval")
    List<WebElement> selectRadioButton;

    @FindBy(css = "input[value= 'submit']")
    WebElement submitButton;

    public WebElement getParagraph() {
        return paragraph;
    }

    public void fillUserName() {
        userName.sendKeys("Alina");
        System.out.println("Enter Alina in to the userName field");
    }

    public void fillPassword() {
        password.sendKeys("asD?!4");
        System.out.println("Enter asD?!4 in to the password field");
    }

    public void fillComment() {
        comment.sendKeys("Thank you!");
        System.out.println("Enter Thank you! in to the comment field");
    }

    public void uploadFile() {
        fileNameUpload.sendKeys(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\Homework2\\HerokuWebPage\\Forms\\HTMLFormExample\\forUpload.txt");
        Assert.assertTrue(fileNameUpload.isDisplayed(), "The message is not displayed!");
        System.out.println("The upload message is checked and the ForUpload.txt file is uploaded!");
    }

    public void deselectCheckBox3() {
        selectCheckBoxes.get(2).click();
        System.out.println("Deselect the third checkbox!");
    }

    public void selectCheckBox1() {
        selectCheckBoxes.get(0).click();
        System.out.println("Select the first checkbox!");
    }

    public void selectRadioButton1() {
        selectRadioButton.get(0).click();
        System.out.println("Select the first radio button!");
    }

    public void chooseMultipleSelectValue() {
        Select multipleSelectValue = new Select(chromeDriver.findElement(By.name("multipleselect[]")));
        multipleSelectValue.deselectAll();
        System.out.println("Deselect all values from dropdown multipleSelectValues!");
        multipleSelectValue.selectByValue("ms1");
        System.out.println("Select the first value!");
        multipleSelectValue.selectByVisibleText("Selection Item 3");
        System.out.println("Select the third value!");
    }

    public void getDropDown() {
        Select dropdown = new Select(chromeDriver.findElement(By.name("dropdown")));
        dropdown.selectByValue("dd1");
        System.out.println("Select the first value in drop down!");
        dropdown.selectByVisibleText("Drop Down Item 4");
        System.out.println("Select the 4th value!");
        dropdown.selectByValue("dd6");
        System.out.println("Select the 6th value!");
    }

    public void clickOnSubmitButton() {
        submitButton.click();
        System.out.println("Click on submit button!");
    }
}