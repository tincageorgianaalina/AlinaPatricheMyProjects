package alinatinca.Homework2.HerokuWebPage.Forms.HTML5ElementFormTestPage.pageObjects;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HTML5FormElementsExamplesPAGE {

    ChromeDriver chromeDriver;

    public HTML5FormElementsExamplesPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver, this);
    }

    @FindBy(className = "explanation")
    WebElement paragraph;

    @FindBy(id = "colour-picker")
    WebElement colorPicker;

    @FindBy(id = "date-picker")
    WebElement datePicker;

    @FindBy(id = "date-time-picker")
    WebElement dateTimePicker;

    @FindBy(id = "email-field")
    WebElement email;

    @FindBy(id = "month-field")
    WebElement month;

    @FindBy(id = "number-field")
    WebElement number;

    @FindBy(name = "submitbutton")
    WebElement submitButton;

    public WebElement getParagraph() {
        return paragraph;
    }

    public void setColorPicker() {
        colorPicker.sendKeys("#861C06");
        System.out.println("Set this color with the hex: #861C06 in color picker!");

    }

    public void setDatePicker() {
        datePicker.sendKeys("02/04/2023");
        System.out.println("Enter this date: 02/04/2023 in data picker!");
    }

    public void setDateTimePicker() {
        dateTimePicker.click();
        JavascriptExecutor jse=(JavascriptExecutor)chromeDriver;
        jse.executeScript("document.getElementById('date-time-picker').value='2016-03-03T02:02'");
        System.out.println("Enter this date: 2016-03-03T02:02 in Local Data Time picker!");
    }

    public void enterEmail() {
        email.click();
        email.clear();
        email.sendKeys("test@test.com");
        System.out.println("Enter test@test.com in email field");
    }

    public void setMonth() {
       month.click();
       month.sendKeys("July 2023");
       System.out.println("Enter this date: July 2023 in Month data picker");
    }

    public void chooseNumber() {
        number.click();
        for (int i=0; i<5; i++ ){
            number.sendKeys(Keys.UP);
        }
        for( int i=0; i<5; i++){
            number.sendKeys(Keys.UP);
        }
    }

    public void clickOnSubmitButton() {
        submitButton.click();
        System.out.println("Click on submit button!");
    }
}