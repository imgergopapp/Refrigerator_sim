package com.codecool.main;

import com.codecool.io.Input;

public class Food extends Consumable {

    private boolean isSpicy;

    public Food(String name, String bestBefore, int calories, ConsumableType type, boolean isSpicy) {
        super(name, bestBefore, calories, type);
        this.isSpicy = isSpicy;
    }

     static String[] getProperties() {
        String[] validType = new String[]{"true", "false"};
        String name = Input.getInputString("Food's name: ");

        String month = String.valueOf(Input.getInputInt("Best before - Month: ", 1, 12));
        String day = String.valueOf(Input.getInputInt("Best before - Day: ", 1, 28));
        String year = String.valueOf(Input.getInputInt("Best before - Year: ", 2000, 2030));
        String bestBefore = month + "." + day + "." + year;

        String calories = String.valueOf(Input.getInputInt("Calories: "));
        String isSpicy = Input.getInputString("Is spicy: ", validType);

        return new String[]{name, bestBefore, calories, isSpicy};
    }

    @Override
    public String toString() {
        return "Foods's name: " + getName() + " | " +
            "Best before: " + getBestBefore() + " | " +
            "Calories: " + getCalories() + " | " +
            "Is spicy: " + isSpicy;
    }
}
