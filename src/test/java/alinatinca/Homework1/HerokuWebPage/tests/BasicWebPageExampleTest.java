package alinatinca.Homework1.HerokuWebPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework1.HerokuWebPage.pageObjects.BasicWebPageExamplePAGE;
import org.testng.annotations.Test;

public class BasicWebPageExampleTest extends BaseTest {

    String url = "https://testpages.herokuapp.com/styled/index.html";

    @Test(description = "display information on the Basic Web Page Example url")
    public void getDataBasicWebPageExampleTest(){
        chromeDriver.get(url);
        System.out.println("Navigate to Heroku web page");
        BasicWebPageExamplePAGE basicWebPageExamplePAGE = new BasicWebPageExamplePAGE(chromeDriver);
        basicWebPageExamplePAGE.clickOnUrl();
        System.out.println("Go to Basic Web Page Example");
        System.out.println("Title is: " + basicWebPageExamplePAGE.getTitle().getText());
        System.out.println("The paragraph is: " + basicWebPageExamplePAGE.getParagraph().getText());
    }
}