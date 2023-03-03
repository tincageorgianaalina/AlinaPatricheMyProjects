package alinatinca.Homework1.HerokuWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.HerokuWebPage.pageObjects.ElementAttributesExamplesPAGE;
import org.testng.annotations.Test;

public class ElementAttributesExamplesTest extends BaseTest {
    String url = "https://testpages.herokuapp.com/styled/index.html";

    @Test(groups = {"mobile", "desktop"}, description = "display the information on the ElementAttributesExamples url")
    public void getDataElementAttributesExamplesTest(){
        chromeDriver.get(url);
        System.out.println("Navigate to Heroku web page");
        ElementAttributesExamplesPAGE elementAttributesExamplesPAGE = new ElementAttributesExamplesPAGE(chromeDriver);
        elementAttributesExamplesPAGE.clickOnUrl();
        System.out.println("Go to Element Attributes Examples");
        System.out.println("The main title is: " + elementAttributesExamplesPAGE.getTitle().getText());
        System.out.println("The first paragraph is: " + elementAttributesExamplesPAGE.getParagraph1().getText());
        System.out.println("The second title is: " + elementAttributesExamplesPAGE.getTitle2().getText());
        System.out.println("The second paragraph is: " + elementAttributesExamplesPAGE.getParagraph2().getText());
        System.out.println("The third title is: " + elementAttributesExamplesPAGE.getTitle3().getText());
        System.out.println("The third paragraph is: " + elementAttributesExamplesPAGE.getParagraph3().getText());
        System.out.println("Test passed!");
    }
}