package com.codecool.main;

import com.codecool.io.XmlParser;

public class Fridge {

    private Consumable[] fridge;


    public Consumable[] getFridgeItems() {
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

    public Consumable findConsumable(String name) {
        for (Consumable consumable : fridge) {
            if (name.equals(consumable.getName())) {
                return consumable;
            }
        }
        return null;
    }


    public String[] getFridgeItemNames() {
        String[] names = new String[fridge.length];
        for (int i = 0; i < fridge.length; i++) {
            names[i] = fridge[i].getName();
        }
        return names;
    }

    //Method overload
    public String[] getFridgeItemNames(String type) {
        Consumable[] foods = XmlParser.read("food");
        Consumable[] drinks = XmlParser.read("drink");
        int arrayLength = type.equals("food") ? foods.length : drinks.length;
        String[] names = new String[arrayLength];
        for (int i = 0; i < fridge.length; i++) {
            if (fridge[i] instanceof Food && type.equals("food")) {
                names[i] = fridge[i].getName();
            } else if (fridge[i] instanceof Drink && type.equals("drink")) {
                names[i] = fridge[i].getName();
            }
        }
        return names;
    }
}
