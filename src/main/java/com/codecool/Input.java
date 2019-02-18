package com.codecool;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input{

    public static int getInputInt(String message,int rangeFrom, int rangeTo){

        int input = 0;
        while(true) {
            Scanner reader = new Scanner(System.in);
            System.out.print("\n" + message);
            try {
                input = reader.nextInt();
                reader.nextLine();
                if (input > rangeFrom && input < rangeTo) {
                    break;
                } else {
                    System.out.println(input + " is not a number between " + rangeFrom + " and " + rangeTo + " !");
                }
            }
            catch (InputMismatchException e) { //handle exp
                System.out.println("Input MUST only contain numbers!");
            }
        }
        return input;
    }

    //Method overload
    public static int getInputInt(String message){
        int input = 0;
        while(true) {
            Scanner reader = new Scanner(System.in);
            System.out.print("\n" + message);
            try {
                input = reader.nextInt();
                reader.nextLine();
                break;
            }
            catch (InputMismatchException e) { //handle exp
                System.out.println("Input MUST only contain numbers!");
            }
        }
        return input;
    }

    public static String getInputString(String message, String[] expectedInput){

        String input = null;
        while(true){
            Scanner reader = new Scanner(System.in);
            System.out.println(message);
            input = reader.nextLine();

            if(isAlphabetic(input)) {
                for(String word : expectedInput){
                    if (word.toLowerCase().equals(input.toLowerCase())){
                        return input.toLowerCase();
                    }
                }
            }
            else {
                System.out.println("Input MUST contain only letters!");
            }
        }
    }

    //Method overload :
    public static String getInputString(String message){

        String input = null;
        while(true){
            Scanner reader = new Scanner(System.in);
            System.out.println(message);
            input = reader.nextLine();

            if(isAlphabetic(input)) {
                return input.toLowerCase();
            }
            else {
                System.out.println("Input MUST contain only letters!");
            }
        }
    }

    private static boolean isAlphabetic(String word){
        char[] charArray = word.toCharArray();
        for (char charachters : charArray){
            if (!Character.isLetter(charachters)){
                return false;
            }
        }
        return true;
    }
}
