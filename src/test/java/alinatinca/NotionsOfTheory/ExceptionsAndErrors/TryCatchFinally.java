package alinatinca.NotionsOfTheory.ExceptionsAndErrors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchFinally {

    public static void main(String[] args) {
        //when the code block doesn't execute ok (from try) and catch an exception
        try{
            String word = null;
            String result = word.toLowerCase();
            System.out.print("Result is: " + result);
        } catch (NullPointerException e){   //this can also be written as: catch(Exception | Error e){}
            System.out.print("Exception has been caught!");
        }finally{
            System.out.print("It always execute!");
        }

        // when the code block executes ok (from try)
        try{
            String word = "random word";
            String result = word.toLowerCase();
            System.out.print("Result is: " + result);
        }
        catch(NullPointerException e){
            System.out.print("Exception has been caught!");
        } finally {
            System.out.print("It always execute!");
        }

        //when the code block doesn't execute ok (from try) and catch an exception
        try{
            checkedExceptions();
            System.out.print("This method caught an IOException!");
        }
        catch (IOException e){
            System.out.print("Exception has been caught!");
        }finally{
            System.out.print("It always execute!");
        }
        System.out.print("The main method is over!");
    }

    //this is a method of exemplifying the third case
    public static  void checkedExceptions() throws IOException {
        FileReader file = new FileReader(""); //it was wrong on purpose to catch the exception; otherwise it wouldn't have entered in catch block!
        BufferedReader fileInput = new BufferedReader(file);
        System.out.print(fileInput.readLine());
        fileInput.close();
    }
}