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

    public Consumable findConsumable(String name){
        for( Consumable consumable : fridge){
            if (name.equals(consumable.getName())) {
                return consumable;
            }
        }
        return null;
    }

    public String[] getFridgeItemNames(Consumable[] consumables){
        String[] names = new String[consumables.length];
        for (int i = 0; i < consumables.length; i++){
            names[i] = consumables[i].getName();
        }
        return names;
    }
}
