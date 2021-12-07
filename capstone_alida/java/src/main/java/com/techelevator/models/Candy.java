package com.techelevator.models;

public class Candy extends Items{
    public Candy() {
    }

    public Candy(String itemType, String itemSound) {
        super("Candy", "Munch, munch, yum!");
    }

    @Override
    public String getItemType() {
        return super.getItemType();
    }

    @Override
    public String getItemSound() {
        return super.getItemSound();
    }
}
