package alinatinca.Homework4.SimpleDynamicButtons.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleDynamicButtonsConfirmationPAGE {

    ChromeDriver chromeDriver;
    WebDriverWait wait;

    //Create the constructor that can define the required parameters for this test case
    public SimpleDynamicButtonsConfirmationPAGE(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(6));
        PageFactory.initElements(chromeDriver, this);
    }

    //Find the text on the page
    @FindBy(id ="buttonmessage")
    WebElement text;

    public String displayTextForClickAllButtons() {
        return text.getText();
    }
}