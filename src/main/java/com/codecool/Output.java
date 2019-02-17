package com.codecool;

public class Output{
    
    public void printMenu(String[] menuOptions){
        for (int i = 0; i < menuOptions.length; i++){
            System.out.println(Integer.toString(i) + ". - " + menuOptions[i]);
        }

    }
}
