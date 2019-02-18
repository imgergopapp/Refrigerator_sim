package com.codecool;

import java.util.*;

public class Fridge{

    private Consumable[] Fridge;
    private boolean isOpen;


    //public Consumable[] initializeFridge(){


    //Methods - Setters:
    public void SetIsOpen(boolean isOpen){
        this.isOpen = isOpen;
    }

     //Methods - Getters:
    public boolean GetIsOpen(){
        return this.isOpen;
    }

    public Consumable[] fillUpFridge(Food[] foods, Drink[] drinks){
        int fridgeSize = foods.length + drinks.length;
        Consumable[] fridge = new Consumable[fridgeSize];

        for (int i = 0; i < foods.length; i++){
            fridge[i] = foods[i];
        }
        for (int i = foods.length; i < fridgeSize; i++){
            fridge[i] = drinks[i-foods.length];
        }
        return fridge;
    }
}
