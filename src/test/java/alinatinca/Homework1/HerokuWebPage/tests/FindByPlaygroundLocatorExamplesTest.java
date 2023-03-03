package alinatinca.Homework1.HerokuWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.HerokuWebPage.pageObjects.FindByPlaygroundLocatorExamplesPAGE;
import org.testng.annotations.Test;

public class FindByPlaygroundLocatorExamplesTest extends BaseTest {

    String URL = "https://testpages.herokuapp.com/styled/index.html";

    @Test(groups = {"mobile", "desktop"}, description = "display information on the FindByPlaygroundLocatorExamples url ")
    public void getDataFindByPlaygroundTest(){
        chromeDriver.get(URL);
        System.out.println("Navigate to Heroku web page");
        FindByPlaygroundLocatorExamplesPAGE findByPlaygroundLocatorExamplesPAGE = new FindByPlaygroundLocatorExamplesPAGE(chromeDriver);
        findByPlaygroundLocatorExamplesPAGE.clickOnUrl();
        System.out.println("Go to Locators - FindByPlaygroundLocatorExamples");
        System.out.println("Title is: " + findByPlaygroundLocatorExamplesPAGE.getTitle().getText());
        System.out.println("Paragraph is: " + findByPlaygroundLocatorExamplesPAGE.getuParagraph().getText());
        System.out.println(findByPlaygroundLocatorExamplesPAGE.getuParagraph().getText());
        System.out.println("Test passed!");
    }
}