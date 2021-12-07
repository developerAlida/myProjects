package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Items {
    private String itemLocation;
    private String itemName;
    private BigDecimal itemPriceBig;
    private String itemType;
    private int itemInventory = 5;
    private String itemSound;

    public Items() {
    }

    public Items(String itemLocation, String itemName, BigDecimal itemPriceBig, String itemType, int itemInventory) {
        this.itemLocation = itemLocation;
        this.itemName = itemName;
        this.itemPriceBig = itemPriceBig;
        this.itemType = itemType;
        this.itemInventory = itemInventory;
    }

    public Items(String itemType,  String itemSound) {
        this.itemType = itemType;
        this.itemSound = itemSound;
    }

    public String getItemLocation() {
        return itemLocation;
    }


    public String getItemName() {
        return itemName;
    }


    public BigDecimal getItemPrice() {
        return itemPriceBig;
    }


    public String getItemType() {
        return itemType;
    }


    public int getItemInventory() { return itemInventory; }

    public String getItemSound() {
        return itemSound;
    }


    public void subtract(){
        itemInventory --;
    }
//

}
