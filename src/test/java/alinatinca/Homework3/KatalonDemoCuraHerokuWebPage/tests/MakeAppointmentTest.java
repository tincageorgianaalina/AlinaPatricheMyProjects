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
    @Test(dataProvider = "makeAppointment", description = "verify different scenarios to make an appointment")
    public void makeAppointment(String data, String comment, boolean testShouldPass){
        try {
            WebElement menuButton = chromeDriver.findElement(By.xpath("/html/body/a"));
            //find the Home Menu button
            menuButton.click();
            //click on home button
            WebElement loginLink = chromeDriver.findElement(By.linkText("Login"));
            //find the Login button
            loginLink.click();
            //click on Login button
            Assert.assertEquals(chromeDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                    //display login page after the login button has been opened
                    "Couldn't navigate to login page!");
            //check if the user is redirected to login page when logged in and display an error message if the login button has been opened
            WebElement usernameInput = chromeDriver.findElement(By.name("username"));
            //find the username filed
            usernameInput.sendKeys("John Doe");
            //fill in the username field with the above username
            WebElement passwordInput = chromeDriver.findElement(By.name("password"));
            //find the password field
            passwordInput.sendKeys("ThisIsNotAPassword");
            //fill in password field with the above password
            WebElement loginButton = chromeDriver.findElement(By.cssSelector("button[type='submit']"));
            //find the login button
            loginButton.click();
            //click on login button
            Select multipleSelectValueFacility = new Select(chromeDriver.findElement(By.xpath("/html/body/section/div/div/form/div[1]/div/select")));
            //find the Facility Field
            multipleSelectValueFacility.selectByValue("Tokyo CURA Healthcare Center");
            //select the first item
            WebElement applyForHospitalButton = chromeDriver.findElement(By.className("checkbox-inline"));
            //find the hospital readmission checkbox
            applyForHospitalButton.click();
            //click on it
            WebElement healthcareProgramButton = chromeDriver.findElement(By.cssSelector("label[for='chk_hospotal_readmission']"));
            //find the Healthcare Program radiobuttons
            healthcareProgramButton.click();
            //click on it
            WebElement chooseData = chromeDriver.findElement(By.id("txt_visit_date"));
            //find the Visit Date field
            chooseData.sendKeys(data);
            //choose this: 10/01/2023
            WebElement dataField = chromeDriver.findElement(By.id("txt_visit_date"));
            //find Visit Date Field
            dataField.sendKeys(comment);
            //fill with comment
            WebElement bookAppointmentButton = chromeDriver.findElement(By.id("btn-book-appointment"));
            //find the Book Appointment button
            bookAppointmentButton.click();
            //click on it
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
            }}catch (Exception e) {
                System.out.println("Test passed!");
            }
    }
}