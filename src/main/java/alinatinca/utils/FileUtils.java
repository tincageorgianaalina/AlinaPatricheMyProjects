package alinatinca.utils;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class FileUtils {

//    public static void takeScreenshot(ChromeDriver chromeDriver, String fileName){
//        File source = chromeDriver.getScreenshotAs(OutputType.FILE);
////        String destinationFile = System.getProperty("user.dir")+ ""
//        File destinationFile = new File(System.getProperty("user.dir") + "C:\\Users\\Home\\IdeaProjects");
//        try{
//            org.apache.commons.io.FileUtils.copyFile(source,destinationFile);
//        }
//        catch (Error | NoSuchSessionException, IOException e){
//            System.out.print("The screenshot could not done!");
//            e.printStackTrace();
//        }
//    }
//
//    public static void takeScreenshot(ChromeDriver chromeDriver, String fileName){
//        File screenshot = chromeDriver.getScreenshotAs(OutputType.FILE);
//        try{
//            org.apache.commons.io.FileUtils.copyFile(screenshot, new File("C:\\Users\\Home\\IdeaProjects\\Screenshots.png"));
//        }
//        catch (IOException e){
//            System.out.print("The exception has been caught and the screenshot has been taken!");
//        }
//    }
}