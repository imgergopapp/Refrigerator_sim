package com.codecool.io;

import com.codecool.main.Consumable;

public class Output {

    public static void printMenu(String[] menuOptions) {
        System.out.println();
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println(i + ". " + menuOptions[i]);
        }
    }

    public static void showFridgeElements(Consumable[] fridge) {
        for (Consumable consumable : fridge) {
            System.out.println(consumable.toString());
        }
    }
}
