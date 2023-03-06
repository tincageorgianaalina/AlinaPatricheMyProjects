package alinatinca.Homework2.HerokuWebPage.Forms.HTMLFormExample.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.HerokuWebPage.Forms.HTMLFormExample.pageObjects.BasicHTMLFormExamplePAGE;
import org.testng.annotations.Test;

public class BasicHTMLForExampleTest extends BaseTest {

    @Test(description = "verify how to complete a form with data")
    public void fillDataInToTheFormTest(){
        chromeDriver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        System.out.println("Navigate to Heroku HTML Form page");
        BasicHTMLFormExamplePAGE basicHTMLFormExamplePAGE = new BasicHTMLFormExamplePAGE(chromeDriver);
        System.out.println("The paragraph on the page is: " + basicHTMLFormExamplePAGE.getParagraph().getText());
        basicHTMLFormExamplePAGE.fillUserName();
        basicHTMLFormExamplePAGE.fillPassword();
        basicHTMLFormExamplePAGE.fillComment();
        basicHTMLFormExamplePAGE.uploadFile();
        basicHTMLFormExamplePAGE.deselectCheckBox3();
        basicHTMLFormExamplePAGE.selectCheckBox1();
        basicHTMLFormExamplePAGE.selectRadioButton1();
        basicHTMLFormExamplePAGE.chooseMultipleSelectValue();
        basicHTMLFormExamplePAGE.getDropDown();
        basicHTMLFormExamplePAGE.clickOnSubmitButton();
        System.out.println("Test passed!");
    }
}