package com.codecool;


public class Drink extends Consumable{

    private boolean isAlcoholic;
    private boolean isFizzy;

    public Drink(String name, String bestBefore, int calories, boolean isAlcoholic, boolean isFizzy){
        super(name, bestBefore, calories);
        this.isAlcoholic = isAlcoholic;
        this.isFizzy = isFizzy;
    }

    //Methods

    
}
