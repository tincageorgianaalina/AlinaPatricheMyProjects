package alinatinca.UITestingPlayground.tests;

import alinatinca.UITestingPlayground.BaseTest;
import alinatinca.UITestingPlayground.pageObjects.ClassAttributeLinkPage;
import org.testng.annotations.Test;

public class ClassAttributeLinkPageTest extends BaseTest {
    @Test(description = "verify that scenario from Class Attribute web page is working")
    public void goToClassAttributeLinkTest(){
        chromeDriver.get("http://uitestingplayground.com/");
        ClassAttributeLinkPage classAttributePage = new ClassAttributeLinkPage(chromeDriver);
        classAttributePage.clickOnClassAttribute();
        System.out.println("Navigate to Class Attribute link!");
        System.out.println("Scenario is: " + classAttributePage.getScenarioText().getText());
        classAttributePage.clickOnBlueButtonAndGetAlert();
        System.out.println("Test passed!");
    }
}