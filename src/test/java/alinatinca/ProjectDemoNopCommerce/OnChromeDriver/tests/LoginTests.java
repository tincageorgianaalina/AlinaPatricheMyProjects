package alinatinca.ProjectDemoNopCommerce.OnChromeDriver.tests;

public class LoginTests extends BaseTest{

    public void loginDataProvider(){
        chromeDriver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
    }
}
