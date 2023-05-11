package alinatinca;

import java.util.Scanner;

public class SwitchStatement {
    public static void main(String[] args) {
        //Exercise 1
        //Phone Robot
        System.out.println("Choose an option: ");
        Scanner inputOption = new Scanner(System.in);
        int option = inputOption.nextInt();
        switch (option) {
            case 0:
                System.out.println("Back to menu!");
                break;
            case 1:
                System.out.println("For Romanian press key one");
                break;
            case 2:
                System.out.println("For English press key two!");
                break;
            case 3:
                System.out.println("For French press key three");
                break;
            default:
                System.out.println("Invalid option, please try again!");
        }
    }
}