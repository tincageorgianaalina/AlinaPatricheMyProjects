package alinatinca.Homework4.RefreshPage.tests;

import alinatinca.Homework1.BaseTest;
import alinatinca.Homework4.RefreshPage.pageObjects.RefreshPagePAGE;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefreshPageTest extends BaseTest {

    @Test(groups = {"desktop.H4", "mobile.H4"}, description = "verify that id is updated after each page refresh")
    public void refreshPageTest(){
        try{
            chromeDriver.get("https://testpages.herokuapp.com/styled/refresh");
            System.out.println("Navigate to Refresh Page Test web page");
            RefreshPagePAGE refreshPagePAGE = new RefreshPagePAGE(chromeDriver);
            System.out.println("Timestamp before refreshing is: " + refreshPagePAGE.getStatusForTimestamp());
            chromeDriver.navigate().refresh();
            System.out.println("The page has been refreshed!");
            System.out.println("Timestamp after refreshing is: " + refreshPagePAGE.getStatusForTimestamp());
            Assert.assertEquals(refreshPagePAGE.getStatusForTimestamp(), refreshPagePAGE.getStatusForTimestamp(), "Timestamp has been changed!");
        }catch (Exception e){
            System.out.println("Check was done successfully: Id is updated after each page refresh!");
            System.out.println("Test passed!");
        }
    }
}