package com.codecool.main;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Consumable {

    private String name;
    private String bestBefore;
    private int calories;
    private ConsumableType type;

    public Consumable(String name, String bestBefore, int calories, ConsumableType type) {
        this.name = name;
        this.bestBefore = bestBefore;
        this.calories = calories;
        this.type = type;
    }

    //Methods - Getters:

    public String getName() {
        return this.name;
    }

    public String getBestBefore() {
        return this.bestBefore;
    }

    public int getCalories() {
        return this.calories;
    }

    public ConsumableType getType() {
        return type;
    }

    //Methods - Others:

    public void isEdible() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        try {
            Date date = sdf.parse(this.bestBefore);
            long daysExpire = Math.abs((now.getTime() - date.getTime()) / 86400000);
            if (now.getTime() > date.getTime()) {
                System.out.println(this.name + " is NOT consumable!");
                System.out.print(this.name + " was expired by " + daysExpire + " day(s) !");
            } else {
                System.out.println(this.name + " is consumable!");
                System.out.print(this.name + " will be expired after " + daysExpire + " day(s) !");
            }
            System.out.println(" ( " + bestBefore + " )");
        } catch (Exception e) { // Need to handle exceptions
            System.out.println("@ isEdible Exception :  ");
            e.printStackTrace();
        }
    }
}
