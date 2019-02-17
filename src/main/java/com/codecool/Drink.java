package com.codecool;


public class Drink extends Consumable{

    private boolean isAlcoholic;

    public Drink(String name, String bestBefore, int calories, boolean isAlcoholic){
        super(name, bestBefore, calories);
        this.isAlcoholic = isAlcoholic;
    }

    //Methods

    
}
