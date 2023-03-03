package alinatinca.Homework1.DemoqaWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.DemoqaWebPage.pageObjects.CheckBoxPAGE;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    String URL = "https://demoqa.com/elements";

    @Test(groups = {"mobile", "desktop"}, description = "verify how to click on checkbox")
    public void checkBoxTest(){
        chromeDriver.get(URL);
        System.out.println("Navigate to Demoqa Elements web page");
        CheckBoxPAGE checkBoxPAGE = new CheckBoxPAGE(chromeDriver);
        checkBoxPAGE.clickOnUrl();
        Assert.assertTrue(checkBoxPAGE.getTitle().isDisplayed(), "Title is not displayed on the page!");
        System.out.println("Title has been checked, it is displayed on the page!");
//        if(checkBoxPAGE.getTitle().isDisplayed()){
//            System.out.println("Title is displayed on the page!");
//        }else{
//            System.out.println("Title is not displayed on the page!");
//        }
        System.out.println("Go to CheckBox category");
        checkBoxPAGE.clickOnBoxHomeButton();
        System.out.println("Test passed!");
    }
}