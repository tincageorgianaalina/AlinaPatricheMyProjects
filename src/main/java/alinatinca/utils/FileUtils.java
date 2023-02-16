package alinatinca.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void takeScreenshot(ChromeDriver chromeDriver, String fileName){
        File source = chromeDriver.getScreenshotAs(OutputType.FILE);
        String destinatiionFile = System.getProperty("user.dir") + String.format("Logs/%s.png", fileName);
        try{
            org.apache.commons.io.FileUtils.copyFile(source, new File(destinatiionFile));
        }
        catch (IOException e){
            System.out.print("The screenshot could not done!");
            e.printStackTrace();
        }
    }
}