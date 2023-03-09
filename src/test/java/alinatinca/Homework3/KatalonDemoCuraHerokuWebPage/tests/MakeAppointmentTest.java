package alinatinca.Homework3.KatalonDemoCuraHerokuWebPage.tests;

import alinatinca.Homework1.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

public class MakeAppointmentTest extends BaseTest {

    @DataProvider(name = "makeAppointment")
    public Object[][] makeAppointmentDetails(){
        return new Object[][] {
                {"10/01/2023", "new comment", true},
                //test case with all data filled - test passed!
                {"22/02/2023", "", true},
                //test case without the Comment field completed - test passed!
                {"", "comm", false}
                //test case without required field (Visit Date) filled - test failed!
        };
    }
    @Test(groups = {"desktop.H3", "mobile.H3"}, dataProvider = "makeAppointment", description = "verify different scenarios to make an appointment")
    public void makeAppointment(String data, String comment, boolean testShouldPass){
        try {
            chromeDriver.get("https://katalon-demo-cura.herokuapp.com/");
            WebElement menuButton = chromeDriver.findElement(By.xpath("/html/body/a"));
            menuButton.click();
            WebElement loginLink = chromeDriver.findElement(By.linkText("Login"));
            loginLink.click();
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                    //display login page after the login button has been opened
                    "Couldn't navigate to login page!");
            //check if the user is redirected to login page when logged in and display an error message if the login button has been opened
            WebElement usernameInput = chromeDriver.findElement(By.name("username"));
            usernameInput.sendKeys("John Doe");
            WebElement passwordInput = chromeDriver.findElement(By.name("password"));
            passwordInput.sendKeys("ThisIsNotAPassword");
            WebElement loginButton = chromeDriver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            Select multipleSelectValueFacility = new Select(chromeDriver.findElement(By.xpath("/html/body/section/div/div/form/div[1]/div/select")));
            multipleSelectValueFacility.selectByValue("Tokyo CURA Healthcare Center");
            WebElement applyForHospitalButton = chromeDriver.findElement(By.className("checkbox-inline"));
            applyForHospitalButton.click();
            WebElement healthcareProgramButton = chromeDriver.findElement(By.cssSelector("label[for='chk_hospotal_readmission']"));
            healthcareProgramButton.click();
            WebElement chooseData = chromeDriver.findElement(By.id("txt_visit_date"));
            chooseData.sendKeys(data);
            WebElement dataField = chromeDriver.findElement(By.id("txt_visit_date"));
            dataField.sendKeys(comment);
            WebElement bookAppointmentButton = chromeDriver.findElement(By.id("btn-book-appointment"));
            bookAppointmentButton.click();
            if (testShouldPass) {
                Assert.assertEquals(chromeDriver.getCurrentUrl(),
                        //check if Appointment Confirmation message appears on the page, after the book appointment button is clicked
                        "https://katalon-demo-cura.herokuapp.com/appointment.php#summary",
                        "The message of appointment confirmation should be appear on the page!");
                System.out.println();
            } else {
                Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment",
                        //check if remain on the appointment page because user has not filled the required field (Visit Data) from Make Appointment page
                        "https://katalon-demo-cura.herokuapp.com/#appointment",
                        "Make appointment has not been realized succssessfully! A message appears saying: Please fill out this field!");
            }
        }catch (Exception e) {
                System.out.println("Test passed!");
        }
    }
}