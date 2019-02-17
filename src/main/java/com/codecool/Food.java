package com.codecool;

public class Food extends Consumable{

    private boolean isSpicy;

    public Food(String name, String bestBefore, int calories, boolean isSpicy){
        super(name, bestBefore, calories);
        this.isSpicy = isSpicy;
    }

}
