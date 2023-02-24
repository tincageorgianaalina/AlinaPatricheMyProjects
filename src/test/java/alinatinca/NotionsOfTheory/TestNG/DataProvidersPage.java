package alinatinca.NotionsOfTheory.TestNG;

import alinatinca.NotionsOfTheory.SeleniumBasic2.BaseTest;
import org.testng.annotations.DataProvider;

public class DataProvidersPage {

    //Verify the links for each domain form the Amazon web page and assert if there is the same image on every page
    @DataProvider(name = "dataProviderAmazonTest2")
    public static Object[][] dataProviderAmazonTest2(){
        return new Object[][]{
                {"/gp/goldbox?ref_=nav_cs_gb"},
                {"/gp/help/customer/display.html?nodeId=508510&ref_=nav_cs_customerservice"},
                {"/registries?ref_=nav_cs_registry"},
                {"/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc"},
                {"/b/?_encoding=UTF8&ld=AZUSSOA-sell&node=12766669011&ref_=nav_cs_sell"}
        };
    }
}