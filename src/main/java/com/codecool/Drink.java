package com.codecool;

public class Drink extends Consumable{

    private boolean isAlcoholic;
    private boolean isFizzy;

    public Drink(String name, String bestBefore, int calories, boolean isAlcoholic, boolean isFizzy){
        super(name, bestBefore, calories);
        this.isAlcoholic = isAlcoholic;
        this.isFizzy = isFizzy;
    }

    public static String[] makeConsumable(){

        String name = Input.getInputString("Drink's name: ");

        String month = String.valueOf(Input.getInputInt("Best before - Month: ",1,12));
        String day = String.valueOf(Input.getInputInt("Best before - Day: ",1,28));
        String year = String.valueOf(Input.getInputInt("Best before - Year: ",2000,2030));
        String bestBefore = month + "." + day + "." + year;

        String calories = String.valueOf(Input.getInputInt("Calories: "));
        String isalcoholic = Input.getInputString("Is alcoholic: ");
        String isfizzy = Input.getInputString("Is fizzy: ");

        return new String[]{name,bestBefore,calories,isalcoholic,isfizzy};
    }

    @Override
    public String toString() {
        return "Drink's name: " + getName() + " | " +
            "Best before: " + getBestBefore() + " | " +
            "Calories: " + getCalories() + " | " +
            "isAlcoholic: " + isAlcoholic + " | " +
            "isFizzy: " + isFizzy;
    }
}
