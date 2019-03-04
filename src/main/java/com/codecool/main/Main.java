package com.codecool.main;

import com.codecool.io.Input;
import com.codecool.io.Output;
import com.codecool.io.XmlParser;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Fridge smartFridge = new Fridge();
        boolean notQuit = true;
        while (notQuit) {

            String[] menuTitles = {"[Exit] Close application",
                "[Read] Show whats in the fridge",
                "[Compare] Order items by Date (and Name)",
                "[Find] Is consumable",
                "[Create] Add consumable",
                "[Update] Change consumable",
                "[Remove] Remove consumable"};
            Output.printMenu(menuTitles);
            int input = Input.getInputInt("Please choose a menupoint: ", 0, menuTitles.length);


            Consumable[] fridgeElements = smartFridge.getFridgeItems();

            String[] validType = new String[]{"food", "drink"};
            String[] validNames = smartFridge.getFridgeItemNames();
            String name;

            switch (input) {
                case 0:
                    System.out.println("\n- [Exit] Close application -\n0");
                    notQuit = false;
                    break;
                case 1:
                    System.out.println("\n- [Read] Show whats in the fridge -\n");
                    Output.showFridgeElements(fridgeElements);
                    break;
                case 2:
                    System.out.println("\n- [Compare] Sort items by Date (and Name) -\n");
                    Arrays.sort(fridgeElements,new DateSort());
                    Output.showFridgeElements(fridgeElements);
                    break;
                case 3:
                    System.out.println("\n- [Find] Is consumable -\n");
                    name = Input.getInputString("Name of the consumable: ", validNames);
                    Consumable consumable = smartFridge.findConsumable(name);
                    consumable.isEdible();
                    break;
                case 4:
                    System.out.println("\n- [Create] Add consumable -\n");
                    String userChoice = Input.getInputString("Choose between food and drink: ", validType);
                    String[] properties = userChoice.equals("food") ? Food.getProperties() : Drink.getProperties();
                    XmlParser.write(properties, userChoice);
                    break;
                case 5:
                    System.out.println("\n- [Update] Change consumable -\n");
                    userChoice = Input.getInputString("Choose between food and drink: ", validType);
                    validNames = smartFridge.getFridgeItemNames(userChoice);
                    name = Input.getInputString("Name of the consumable: ", validNames);
                    properties = userChoice.equals("food") ? Food.getProperties() : Drink.getProperties();
                    XmlParser.update(name, properties, userChoice);
                    break;
                case 6:
                    System.out.println("\n- [Remove] Remove consumable -\n");
                    userChoice = Input.getInputString("Choose between food and drink: ", validType);
                    validNames = smartFridge.getFridgeItemNames(userChoice);
                    name = Input.getInputString("Name of the consumable: ", validNames);
                    XmlParser.delete(name, userChoice);
            }
        }
    }
}
