package alinatinca.ProjectDemoNopCommerce.OnEdgeDriver.tests;

import alinatinca.driver.BrowserManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected EdgeDriver edgeDriver;

    @BeforeMethod
    public void createEdgeDriverForDesktop(){
        edgeDriver = BrowserManager.createEdgeDriverForDesktop();
    }

    @BeforeMethod
    public void createEdgeDriverForMobile(){
        edgeDriver = BrowserManager.createEdgeDriverForMobile();
    }

    @AfterMethod
    public void quitDriver(){
        edgeDriver.quit();
    }
}