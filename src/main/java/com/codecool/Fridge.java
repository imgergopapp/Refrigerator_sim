package com.codecool;

public class Fridge{

    private Consumable[] fridge;

    public Consumable[] fillUpFridge(Consumable[] foods, Consumable[] drinks){
        int fridgeSize = foods.length + drinks.length;
        fridge = new Consumable[fridgeSize];

        for (int i = 0; i < foods.length; i++){
            fridge[i] = foods[i];
        }
        for (int i = foods.length; i < fridgeSize; i++){
            fridge[i] = drinks[i-foods.length];
        }
        return fridge;
    }
}
