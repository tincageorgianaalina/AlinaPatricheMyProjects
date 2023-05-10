package alinatinca;

import java.util.Scanner;

public class IfElse {
    /*
    Flow Control
    if else = evalueaza conditii si bifurca codul in functie de rezultat

     if, else if, else
     */

    public static void main(String[] args) {
    //Exercise 1
    /*
    If I like a melody on the radio, then I turn up the radio,
    else I don't like this melody!
    At last, Turn off the radio!
    */
        System.out.println("Turn on the radio!");
        //if i like the melody, turn up the radio!
        boolean melody_beautiful = false;
        if(melody_beautiful == true){
            System.out.println("I turn up the radio and I start to sing!");
        }else{
            System.out.println("I don't like this melody!");
        }
        System.out.println("Turn off the radio!");

    //Exercise 2
        int number = 4;
        if(number % 2 == 0){
            System.out.println("numar par");
        }else {
            System.out.println("numar impar");
        }

    //Exercise 3
        if (number > 3){
            System.out.println("numar pozitiv");
        }else {
            System.out.println("numar negativ!");
        }

    //Exercise 4
    //Cum ne saluta robotelul in functie de ora?

        Scanner inputNumber = new Scanner(System.in);
        System.out.println("Introduce a number: ");
        int hour = inputNumber.nextInt();
        System.out.println("The number filled is: " + hour);
        if(hour < 0){
            System.out.println("Negativ number!");
        }else if(hour<=11){
            System.out.println("Good morning!");
        }else if(hour<=18) {
            System.out.println("Good afternoon!");
        }else if(hour<=21){
            System.out.println("Good evening!");
        }else if(hour<=24){
            System.out.println("Good night!");
        }else{
            System.out.println("Invalid time!");
        }
    }
}