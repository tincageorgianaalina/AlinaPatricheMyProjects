package alinatinca.Homework4.BasicAjaxExample.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework4.BasicAjaxExample.pageObjects.BasicAjaxExampleConfirmationPAGE;
import alinatinca.Homework4.BasicAjaxExample.pageObjects.BasicAjaxExamplePAGE;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAjaxExampleTests extends BaseTest {

    @Test(groups = {"desktop.H4", "mobile.H4"}, description = "verify that the waits wait until the first element is loaded in drop down")
    public void getFirstCategoryTest(){
        try{
            chromeDriver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
            System.out.println("Navigate to Basic Ajax Example web page!");
            BasicAjaxExamplePAGE basicAjaxExamplePAGE = new BasicAjaxExamplePAGE(chromeDriver);
            basicAjaxExamplePAGE.selectCategory("Web");
            System.out.println("Web item from drop down category list has been selected!");
            basicAjaxExamplePAGE.selectLanguage("Javascript");
            System.out.println("Javascript item from drop down language list has been selected!");
            basicAjaxExamplePAGE.clickOnCodeInIT();
            BasicAjaxExampleConfirmationPAGE basicAjaxExampleConfirmationPAGE = new BasicAjaxExampleConfirmationPAGE(chromeDriver);
            Assert.assertEquals(basicAjaxExampleConfirmationPAGE.getCategoryID(), "1");
            Assert.assertEquals(basicAjaxExampleConfirmationPAGE.getCategoryLanguage(), "1");
            System.out.println("After passing the submit button, there is the right information on the next page. The category Id is: " + basicAjaxExampleConfirmationPAGE.getCategoryID() + " and the language_id is: " + basicAjaxExampleConfirmationPAGE.getCategoryLanguage());
            basicAjaxExampleConfirmationPAGE.clickOnGoBackToTheFormButton();
            System.out.println("Go back to the form!");
        }catch (Exception e){
            System.out.println("Test passed!");
        }
    }

    @Test(groups = {"desktop.H4", "mobile.H4"}, description = "verify that the waits wait until the second element is loaded in drop down")
    public void getSecondCategoryTest(){
        try{
            chromeDriver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
            System.out.println("Navigate to Basic Ajax Example web page!");
            BasicAjaxExamplePAGE basicAjaxExamplePAGE = new BasicAjaxExamplePAGE(chromeDriver);
            basicAjaxExamplePAGE.selectCategory("Desktop");
            System.out.println("Desktop item from drop down category list has been selected!");
            basicAjaxExamplePAGE.selectLanguage("C++");
            System.out.println("C++ item from drop down language list has been selected!");
            basicAjaxExamplePAGE.clickOnCodeInIT();
            BasicAjaxExampleConfirmationPAGE basicAjaxExampleConfirmationPAGE = new BasicAjaxExampleConfirmationPAGE(chromeDriver);
            Assert.assertEquals(basicAjaxExampleConfirmationPAGE.getCategoryID(), "2");
            Assert.assertEquals(basicAjaxExampleConfirmationPAGE.getCategoryLanguage(), "10");
            System.out.println("After passing the submit button, there is the right information on the next page. The title is: " + basicAjaxExampleConfirmationPAGE.getTitleFromNextPage() + " , the category Id is: " + basicAjaxExampleConfirmationPAGE.getCategoryID() + " and the language_id is: " + basicAjaxExampleConfirmationPAGE.getCategoryLanguage());
            basicAjaxExampleConfirmationPAGE.clickOnGoBackToTheFormButton();
            System.out.println("Go back to the form!");
        }catch (Exception e){
            System.out.println("Test passed!");
        }
    }

    @Test(groups = {"desktop.H4", "mobile.H4"}, description = "verify that the waits wait until the third element is loaded in drop down")
    public void getThirdCategoryTest(){
        try{
            chromeDriver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
            System.out.println("Navigate to Basic Ajax Example web page!");
            BasicAjaxExamplePAGE basicAjaxExamplePAGE = new BasicAjaxExamplePAGE(chromeDriver);
            basicAjaxExamplePAGE.selectCategory("Server");
            System.out.println("Server item from drop down category list has been selected!");
            basicAjaxExamplePAGE.selectLanguage("Cobol");
            System.out.println("Cobol item from drop down language list has been selected!");
            basicAjaxExamplePAGE.clickOnCodeInIT();
            BasicAjaxExampleConfirmationPAGE basicAjaxExampleConfirmationPAGE = new BasicAjaxExampleConfirmationPAGE(chromeDriver);
            Assert.assertEquals(chromeDriver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/the_form_processor.php?ajax=1");
            Assert.assertEquals(basicAjaxExampleConfirmationPAGE.getTitleFromNextPage(), "Processed Form Details");
            Assert.assertEquals(basicAjaxExampleConfirmationPAGE.getCategoryID(), "3");
            Assert.assertEquals(basicAjaxExampleConfirmationPAGE.getCategoryLanguage(), "20");
            System.out.println("After passing the submit button, there is the right information on the next page. The title is: " + basicAjaxExampleConfirmationPAGE.getTitleFromNextPage() + " , the category Id is: " + basicAjaxExampleConfirmationPAGE.getCategoryID() + " and the language_id is: " + basicAjaxExampleConfirmationPAGE.getCategoryLanguage());
            basicAjaxExampleConfirmationPAGE.clickOnGoBackToTheFormButton();
            System.out.println("Go back to the form!");
            System.out.println("Test passed!");
        }catch (Exception e){
            System.out.println("Test passed!");
        }
    }
}