package com.codecool;

import java.util.Scanner;

public class Input{
    private static Scanner reader = new Scanner(System.in);

    public static int getInputInt(String message,int rangeFrom, int rangeTo){
        int input = 0;
        while(true) {
            System.out.println("\n" + message);
            try {
                Scanner reader = new Scanner(System.in);
                input = reader.nextInt();
                reader.nextLine();
                if (input > rangeFrom && input < rangeTo) {
                    break;
                } else {
                    System.out.println(input + " is not a number between " + rangeFrom + " and " + rangeTo + " !");
                }
            }
            catch (Exception e) { //handle exp
            }
        }
        return input;
    }

    public static String getInputString(String message){
        do{
            System.out.println(message);
            try{
                String input = reader.nextLine();
                if (isAlphabetic(input)){
                    return input;
                }
            }
            catch (Exception e){ //handle exp
            }
            //reader.close();
        } while (true);
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
