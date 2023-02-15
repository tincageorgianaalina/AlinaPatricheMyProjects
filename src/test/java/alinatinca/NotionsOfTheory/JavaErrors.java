package alinatinca.NotionsOfTheory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaErrors {

    public static void main(String[] args) throws IOException {
        //throw
        //throws
        //try - catch - finally -> Handler

        //throw - use it to throw an error
        //throws - warning that a method or constructor throws an error or exception
        //try-catch-finally - code block where definy any handlers for error or exception
        //try - here is written the method that throws an exception/error
        //catch - here is caught the exception/error of the method
        //finally - this always executes

        //Exceptions - checked - detected only during the compile time / throws
                   //- unchecked - detected only at runtime/ Null pointer exceptions

//        checkedExceptions();
//        System.out.print("Code executed!");
        uncheckedExceptions();
//        recursiveMethod(5);
    }

        //checked exceptions
   public static  void checkedExceptions() throws IOException {
        FileReader file = new FileReader("E:\\Alina work Git\\MyProjects\\src\\test\\java\\alinatinca\\NotionsOfTheory\\fisier.txt");
        BufferedReader fileInput = new BufferedReader(file);
        System.out.print(fileInput.readLine());
        fileInput.close();
   }

        //unchecked exceptions
    public static void uncheckedExceptions(){
        //Null Pointer Exception
//      String word = null;
//      word.length();

        //ArithmeticException
        int a = 10;
        int b = 0;
        int result = a/b;
        System.out.print("Result is: " + result);
    }

        //recursiveMethod
    public static void recursiveMethod(int number, int i) {
        if (number == 0) {
            return;
        }else{
            System.out.print("Number is: " + i);
            i++;
            recursiveMethod(number, i);
        }
    }
}