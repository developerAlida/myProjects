package com.techelevator.ui;
import com.techelevator.models.Items;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static com.techelevator.ui.BigDollar.*;
import static com.techelevator.ui.BigDollar.getTenDollar;
import static com.techelevator.ui.Logger.*;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);



    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit & Get Change!");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        switch (option) {
            case "1":
                return "display";
            case "2":
                return "purchase";
            case "3":
                return "exit";
            default:
                return "";
        }

    }

    public static String purchase(BigDecimal customerBalance){
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Return to Main Menu");

        System.out.println();
        System.out.print("Current Money Provided : $"+ customerBalance);

        System.out.println();
        System.out.print("Please select an option: ");
        System.out.println();
        System.out.println();
        String selectedOption = scanner.nextLine();

        switch (selectedOption) {
            case "1":
                return "feed";
            case "2":
                return "purchase";
            default:
                return "finish";
        }

    }
    public static BigDecimal feedMoneyMenu(BigDecimal customerBalance) {
        UserOutput.rapidFeedMenu(customerBalance);
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        switch (option) {

            case "1":
                customerBalance = customerBalance.add(oneDollar);
                feedLoggerOneDollar(customerBalance);
                return customerBalance;

            case "2":
                customerBalance = customerBalance.add(twoDollar);
                feedLoggerTwoDollar(customerBalance);
                return customerBalance;

            case "3":
                customerBalance = customerBalance.add(fiveDollar);
                feedLoggerFiveDollar(customerBalance);
                return customerBalance;
            case "4":
                customerBalance = customerBalance.add(tenDollar);
                feedLoggerTenDollar(customerBalance);
                return  customerBalance;

            default:
                UserOutput.displayMessage("Invalid Selection! Please try again.");
                return   customerBalance;

        }



    }




    public static String purchaseMethod(List<Items> items) {

        UserOutput.listItems(items);
        String itemSlotInput;

        System.out.println("Please select the item slot of the item you would like to purchase:");
        itemSlotInput = scanner.nextLine();
        return itemSlotInput.toUpperCase();
    }
    public static void feedLoggerOneDollar(BigDecimal customerBalance){
        logger.write( Logger.currentFormat() +"\t"+ "FEED MONEY" + "\t $" + getOneDollar()+ "\t $"  + customerBalance +"\t");

    }
    public static void feedLoggerTwoDollar(BigDecimal customerBalance){
        logger.write( Logger.currentFormat() +"\t"+ "FEED MONEY" + "\t $" + getTwoDollar()+ "\t $"  + customerBalance +"\t");

    }
    public static void feedLoggerFiveDollar(BigDecimal customerBalance){
        logger.write( Logger.currentFormat() +"\t"+ "FEED MONEY" + "\t $" + getFiveDollar()+ "\t $"  + customerBalance +"\t");

    }
    public static void feedLoggerTenDollar(BigDecimal customerBalance){
        logger.write( Logger.currentFormat() +"\t"+ "FEED MONEY" + "\t $" + getTenDollar()+ "\t $"  + customerBalance +"\t");

    }







}