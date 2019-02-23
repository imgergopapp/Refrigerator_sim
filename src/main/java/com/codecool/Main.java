package com.codecool;

public class Main {

    public static void main(String[] args) {
        Fridge smartFridge = new Fridge();
        boolean notQuit = true;
        while (notQuit) {

            String[] menuTitles = {"[Exit] Close application",
                "[Read] Show whats in the fridge",
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
                    System.out.println("\n- [Find] Is consumable -\n");
                    name = Input.getInputString("Name of the consumable: ", validNames);
                    Consumable consumable = smartFridge.findConsumable(name);
                    consumable.isEdible();
                    break;
                case 3:
                    System.out.println("\n- [Create] Add consumable -\n");
                    String userChoice = Input.getInputString("Choose between food and drink: ", validType);
                    String[] properties = userChoice.equals("food") ? Food.makeConsumable() : Drink.makeConsumable();
                    XmlParser.write(properties, userChoice);
                    break;
                case 4:
                    System.out.println("\n- [Update] Change consumable -\n");
                    userChoice = Input.getInputString("Choose between food and drink: ", validType);
                    validNames = smartFridge.getFridgeItemNames(userChoice);
                    name = Input.getInputString("Name of the consumable: ", validNames);
                    properties = userChoice.equals("food") ? Food.makeConsumable() : Drink.makeConsumable();
                    XmlParser.update(name, properties, userChoice);
                    break;
                case 5:
                    System.out.println("\n- [Remove] Remove consumable -\n");
                    userChoice = Input.getInputString("Choose between food and drink: ", validType);
                    validNames = smartFridge.getFridgeItemNames(userChoice);
                    name = Input.getInputString("Name of the consumable: ", validNames);
                    XmlParser.delete(name, userChoice);
            }
        }
    }
}
