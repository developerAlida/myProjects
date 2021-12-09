package com.techelevator;


/******************************************************************
 Write a command-line program which prompts a user to enter a
 temperature, and whether it's in degrees (C)elsius or (F)ahrenheit.
 Convert the temperature to the opposite degrees, and display the
 old and new temperatures to the console.

 *****************************************************************/

import java.util.Scanner;

public class TempConverter {

    public static void main(String[] args) {
        Scanner userInput = new Scanner (System.in);
        System.out.print(" Please enter the temperature: ");
        String tempInString = userInput.nextLine ();
        int tempIn = Integer.parseInt(tempInString);

        System.out.print ("Is the temperature in (C)elsius, or (F)ahrenheit? ");
        String tempTypeString = userInput.nextLine();

        double tempOut = 0;

        if (tempTypeString.equals("C") || tempTypeString.equals("c") ){
            tempOut = tempIn * 1.8 + 32;
            System.out.println( tempIn +"C is " + (int)tempOut+ "F.");

        }else if (tempTypeString.equals("F") || tempTypeString.equals("f")){
            tempOut = (tempIn - 32) / 1.8;
            System.out.println( tempIn +"F is " + (int)tempOut+ "C.");

        }

    }
}
