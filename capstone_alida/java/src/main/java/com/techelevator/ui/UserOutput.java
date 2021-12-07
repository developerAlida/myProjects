package com.techelevator.ui;

import com.techelevator.models.Items;

import java.math.BigDecimal;
import java.util.List;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 *
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("             THE ULTIMATE SNACK MACHINE");
        System.out.println("***************************************************");
        System.out.println();
    }
    public static void listItems(List<Items> itemsList){
        for (Items item: itemsList){
            System.out.println(item.getItemLocation() + "\t" + item.getItemName() + "\t" + item.getItemPrice() + "\t" + item.getItemType() + "\t" + item.getItemInventory());
        }
        System.out.println();
    }
    public static void rapidFeedMenu(BigDecimal customerBalance) {

        System.out.println("What bill would you like to insert? ");
        System.out.println();

        System.out.println("1) $1");
        System.out.println("2) $2");
        System.out.println("3) $5");
        System.out.println("4) $10");
        System.out.println();

        System.out.println();
        System.out.println("Current money provided: $" + customerBalance);
        System.out.print("Please select an option: ");



    }
    public static void candyMessage(String itemType){
        String message;
        if(itemType.equals("Candy")){
            message = "Munch, munch, yum!";
            System.out.println(message);
        }else if (itemType.equals("Chip")){
            message = "Crunch, crunch, yum!";
            System.out.println(message);
        }else if(itemType.equals("Drink")){
            message = "Glug, glug, yum!";
            System.out.println(message);
        }else if(itemType.equals("Gum")){
            message = "Chew, chew, yum!";
            System.out.println(message);
        }
    }



    public static void soldOut() {

        System.out.println("This item is sold out.");
    }
    public static void itemSlotDoesNotExist() {

        System.out.println("This item does not exist");
    }

}
