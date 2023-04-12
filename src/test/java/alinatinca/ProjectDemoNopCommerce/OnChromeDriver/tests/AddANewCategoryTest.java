package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.tests;

import alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects.AddANewCategoryPage;
import alinatinca.ProjectDemoNopCommerce.OnChromeDriver.pageObjects.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddANewCategoryTest extends BaseTest {

    //this method is a prerequisite for continuing on the site
    @BeforeClass(description = "verify login functionals with valid credentials")
    public void testValidLogin(){
        chromeDriver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        //go to URL
        LoginPage loginPage = new LoginPage(chromeDriver);
        loginPage.getEmail().click();
        //click on the email field
        loginPage.getPassword().click();
        //click on the password click
        loginPage.getLoginButton().click();
        //click on the submit button
//        Assert.assertEquals(chromeDriver.getCurrentUrl(),
//                "https://admin-demo.nopcommerce.com/admin/",
//                "Login was unsuccesfully with the default data!");
        Assert.assertTrue(chromeDriver.getCurrentUrl().contains("admin/"),
                "Login was unsuccesfully with the default data!");
        //verify if appears the next page with this URL: https://admin-demo.nopcommerce.com/admin/ after login was sucessfully
    }

    @Test(description = "check if the user is able to navigate to Categories section on web page")
    public void navigateToCategorySection(){
        AddANewCategoryPage addANewCategoryPage = new AddANewCategoryPage(chromeDriver);
        addANewCategoryPage.getCatalogSection();
        System.out.println("Click on Catalog section!");
        addANewCategoryPage.getCategoriesSection();
        System.out.println("Click on Categories section!");
    }

//DE REVENIT
    @Test(description = "check if the user is able to create a new category")
    public void addANewCategory(){
        navigateToCategorySection();
        AddANewCategoryPage addANewCategoryPage = new AddANewCategoryPage(chromeDriver);
        addANewCategoryPage.getAddNewButton();
        System.out.println("Add a new category!");
        addANewCategoryPage.getNameField();
        System.out.println("Enter TEST Laptop Asus Vivobook to Name field!");
        addANewCategoryPage.getDescriptionField();
        System.out.println("Enter This is a short description to Description field!");
//        addANewCategoryPage.getUploadFile();
//        System.out.println("Upload the photo to Upload field!");
        addANewCategoryPage.getSeoSection();
        System.out.println("Click on SEO section!");
        addANewCategoryPage.getMetaDescriptionField();
        System.out.println("Enter TEST to Meta description field!");
        addANewCategoryPage.getSaveButton();
        System.out.println("Click on Save button!");
//        Assert.assertTrue(addANewCategoryPage.getMessageConfirmation().isDisplayed(),
//                "There is not any warning message!");
        Assert.assertEquals(addANewCategoryPage.getMessageConfirmation(),
                "The new category has been added successfully.", "There is not any warning message!");
    }
}