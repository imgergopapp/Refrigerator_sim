package com.codecool;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Fridge smartFridge = new Fridge();


        boolean notQuit = true;
        while(notQuit) {
            String[] menuTitles = {"Exit", "Whats in the fridge","Add consumable to fridge"};
            Output.printMenu(menuTitles);
            int input = Input.getInputInt("Please choose a menupoint: ", 0, menuTitles.length);

            switch (input) {
                case 0:
                    notQuit = false;
                    break;
                case 1: //Whats in the fridge
                    System.out.println("Fridge contains: ");
                    Food[] foods = Food.readXml();
                    Drink[] drinks = Drink.readXml();
                    Consumable[] fridgeElements = smartFridge.fillUpFridge(foods, drinks);
                    Output.showFridgeElements(fridgeElements);
                    break;
                case 2: //Add consumable to the fridge
                    String[] validInput = new String[]{"food", "drink"};
                    String userChoice = Input.getInputString("Choose between food and drink: ", validInput);
                    if (userChoice.equals("food")) {
                        String[] foodProperties = Food.makeConsumable();
                        Food.writeXml(foodProperties);
                    } else {
                        String[] drinkProperties = Drink.makeConsumable();
                        Food.writeXml(drinkProperties);
                    }
                case 3: //Update in XML database
                    System.out.println();
                    break;
                case 4: //Delete from database
                    System.out.println();
                    break;
            }
        }
    }
}
