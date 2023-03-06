package alinatinca.Homework2.HerokuWebPage.Forms.HTML5ElementFormTestPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework2.HerokuWebPage.Forms.HTML5ElementFormTestPage.pageObjects.HTML5FormElementsExamplesPAGE;
import org.testng.annotations.Test;

public class HTML5FormElementsExamplesTest extends BaseTest {

    @Test(description = "verify how to complete a special form")
    public void fillFormWithDataTest(){
        chromeDriver.get("https://testpages.herokuapp.com/styled/html5-form-test.html");
        System.out.println("Navigate to Heroku HTML5 Form page");
        HTML5FormElementsExamplesPAGE html5FormElementsExamplesPAGE = new HTML5FormElementsExamplesPAGE(chromeDriver);
        System.out.println("The paragraph is: " + html5FormElementsExamplesPAGE.getParagraph().getText());
        html5FormElementsExamplesPAGE.setColorPicker();
        html5FormElementsExamplesPAGE.setDatePicker();
        html5FormElementsExamplesPAGE.setDateTimePicker();
        html5FormElementsExamplesPAGE.enterEmail();
        html5FormElementsExamplesPAGE.setMonth();
        html5FormElementsExamplesPAGE.chooseNumber();
        html5FormElementsExamplesPAGE.clickOnSubmitButton();
        System.out.println("Test passed!");
    }
}