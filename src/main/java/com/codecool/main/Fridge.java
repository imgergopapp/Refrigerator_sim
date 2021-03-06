package com.codecool.main;

import com.codecool.io.XmlParser;

class Fridge {

    private Consumable[] fridge;


    Consumable[] getFridgeItems() {
        Consumable[] foods = XmlParser.read("food");
        Consumable[] drinks = XmlParser.read("drink");

        int fridgeSize = foods.length + drinks.length;
        fridge = new Consumable[fridgeSize];

        for (int i = 0; i < foods.length; i++) {
            fridge[i] = foods[i];
        }
        for (int i = foods.length; i < fridgeSize; i++) {
            fridge[i] = drinks[i - foods.length];
        }
        return fridge;
    }

    Consumable findConsumable(String name) {
        for (Consumable consumable : fridge) {
            if (name.equals(consumable.getName())) {
                return consumable;
            }
        }
        return null;
    }


    String[] getFridgeItemNames() {
        String[] names = new String[fridge.length];
        for (int i = 0; i < fridge.length; i++) {
            names[i] = fridge[i].getName();
        }
        return names;
    }

    //Method overload
    String[] getFridgeItemNames(String type) {
        Consumable[] foods = XmlParser.read("food");
        Consumable[] drinks = XmlParser.read("drink");
        int arrayLength = type.equals("food") ? foods.length : drinks.length;
        String[] names = new String[arrayLength];
        int foodIndex = 0;
        int drinkIndex = 0;
        for (int i = 0; i < fridge.length; i++) {
            if (fridge[i] instanceof Food && type.equals("food")) {
                names[foodIndex] = fridge[i].getName();
                foodIndex++;
            } else if (fridge[i] instanceof Drink && type.equals("drink")) {
                names[drinkIndex] = fridge[i].getName();
                drinkIndex++;
            }
        }
        return names;
    }
}
