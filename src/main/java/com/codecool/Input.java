package com.codecool;

import java.util.Scanner;

public class Input{
    private static Scanner reader = new Scanner(System.in);

    public static int getInputInt(String message,int rangeFrom, int rangeTo){
        do{
            System.out.println(message);
            try{
                int input = reader.nextInt();
                if (input > rangeFrom && input < rangeTo){
                    return input;
                }
                else {
                    System.out.println(input + " is not a number between " + rangeFrom + " and " + rangeTo + " !");
                }
            }
            catch (Exception e){ //handle exp
            }
        } while (true);
    }

    public static int getInputInt(String message){
        do{
            System.out.println(message);
            try{
                int input = reader.nextInt();
                reader.nextLine();
                return input;
            }
            catch (Exception e){ //handle exp
            }
            finally{
                //reader.close();
            }
        } while (true);
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

    public static boolean isAlphabetic(String word){
        char[] charArray = word.toCharArray();
        for (char charachters : charArray){
            if (!Character.isLetter(charachters)){
                return false;
            }
        }
        return true;
    }
}
