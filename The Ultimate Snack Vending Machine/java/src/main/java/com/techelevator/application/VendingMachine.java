package com.techelevator.application;
import com.techelevator.models.Items;
import com.techelevator.ui.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.techelevator.ui.Coin.changeCalculation;

public class VendingMachine
{
    List<Items> items = readFromFile();
    private static BigDecimal customerBalance = new BigDecimal("0.00");
    private static final Logger logger = new Logger("log.txt");


    public void run()
    {
        UserOutput.displayHomeScreen();
        while(true)
        {

            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                System.out.println();

                System.out.println();

                System.out.println("**SNACK MENU**");
                readFromFile();
                UserOutput.listItems(items);

            }
            if(choice.equals("purchase"))
            {
                System.out.println();
                System.out.println();

                System.out.println("**PURCHASE MENU**");
                purchaseMenu();
            }
            if(choice.equals("exit"))
            {
                exit();
            break;
            }
        }
    }





    /*********************************
     *
     * METHODS
     *
     *********************************/



    public static List<Items> readFromFile() {
        File itemsFile = new File("vendingmachine.csv");
        List<Items> itemsList = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(itemsFile);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|");
                String itemLocation = lineArray[0];
                String itemName = lineArray[1];
                String itemPrice = lineArray[2];
                BigDecimal itemPriceBig = new BigDecimal(itemPrice);
                String itemType = lineArray[3];
                int itemInventory = 5;
                Items item = new Items(itemLocation, itemName, itemPriceBig, itemType, itemInventory);
                itemsList.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemsList;
    }
    public void purchaseMenu() {
    boolean inPurchase = true;
    while (inPurchase){
      String purchaseChoice = UserInput.purchase(customerBalance);
        if (purchaseChoice.equals("feed")) {
            purchaseChoiceEqualsFeed();

        }

        if (purchaseChoice.equals("purchase")){
            purchaseChoiceEqualsPurchase();

        }

        if (purchaseChoice.equals("finish")) {
            inPurchase = false;

        }
    }

    }
    public void purchaseChoiceEqualsPurchase(){
        String itemSlotInput = UserInput.purchaseMethod(items);
        int counter = 0;
        for (Items item : items) {
            if (itemSlotInput.equals(item.getItemLocation())) {
                if (customerBalance.compareTo(item.getItemPrice()) >= 0) {
                    if (item.getItemInventory() >= 1) {
                        UserOutput.candyMessage(item.getItemType());
                        item.subtract();
                        customerBalance = customerBalance.subtract(item.getItemPrice());
                        BigDecimal tempBalance = new BigDecimal("0");
                        tempBalance = customerBalance.add(item.getItemPrice());
                        logger.write(Logger.currentFormat() + "\t" + item.getItemLocation() + "\t" + item.getItemName() +
                                "\t" + "$" + tempBalance + "/$" + customerBalance);
                    } else {
                        UserOutput.soldOut();
                    }
                } else {
                    System.out.println("Insufficient funds- Please add more money");
                }
            } else {
                counter++;
                if (counter == 16) {
                    UserOutput.itemSlotDoesNotExist();

                }
            }
        }

    }
    public void purchaseChoiceEqualsFeed(){
    boolean answer = true;
    Scanner scanner = new Scanner(System.in);
    while (answer) {
        customerBalance = UserInput.feedMoneyMenu(customerBalance);
        System.out.println("Would you like to add more money?");
        String yesNo = scanner.nextLine();
        if ((!yesNo.equalsIgnoreCase("N")) && (!yesNo.equalsIgnoreCase("Y"))){
            UserOutput.displayMessage("Please enter Y or N!");
            System.out.println("Would you like to add more money?");
            yesNo = scanner.nextLine();
        }
        if (yesNo.equalsIgnoreCase("n")) {
            UserOutput.displayMessage("Okay...");
            answer = false;
        }

    }

}
    public void exit(){
        changeCalculation(customerBalance);
        customerBalance = customerBalance.subtract(customerBalance);
        System.out.println("Good Bye!");
    }




}
