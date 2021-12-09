package com.techelevator;


/******************************************************************
 Write a command-line program which prompts the user for an integer
 value and display the Fibonacci sequence leading up to that number:
 *****************************************************************/

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        int num1 = 1;
        int hold =0;

        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        String enteredNumberString = userInput.nextLine();
        int enteredNumber = Integer.parseInt(enteredNumberString);

        if (enteredNumber <= 0) {
            System.out.print(0 + ", " + 1);
        }else{
            System.out.print(0 + ", " + 1);
            for (int num = 1; num <= enteredNumber; ) {
                System.out.print(", " + num);
                hold = num;
                num += num1;
                num1 = hold;

            }
        }

    }
}
