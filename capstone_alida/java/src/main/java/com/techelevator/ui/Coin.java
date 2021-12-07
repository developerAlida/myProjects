package com.techelevator.ui;

import java.math.BigDecimal;

import static com.techelevator.ui.Logger.logger;

public class Coin {


    public static void changeCalculation(BigDecimal customerBalance) {
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickel = new BigDecimal("0.05");
        logger.write( Logger.currentFormat() +"\t"+ "GIVE CHANGE" + "\t $" + customerBalance + "\t $0.00" );
        UserOutput.displayMessage("You have $" + customerBalance + " left over!");

        while (!(customerBalance.compareTo(BigDecimal.valueOf(0))==0)) {
            if (customerBalance.compareTo(quarter) >=0) {
                customerBalance = customerBalance.subtract(quarter);
                quarterCount++;
            } else if (customerBalance.compareTo(dime) >=0) {
                customerBalance = customerBalance.subtract(dime);
                dimeCount++;
            } else if (customerBalance.compareTo(nickel)>=0) {
                customerBalance = customerBalance.subtract(nickel);
                nickelCount++;
            }

        }

        System.out.println("Your change is : " + quarterCount + " quarters, \t" + dimeCount + " dimes,\t " + nickelCount + " nickels ");





    }



}