import java.util.Scanner;

public class Input{

    public int getInputInt(String message,int rangeFrom, int rangeTo){

        Scanner reader = new Scanner(System.in);
        boolean invalidInput = true;

        do{
            System.out.println(message);
            try{
                int input = reader.nextInt();
                if (input > rangeFrom && input < rangeTo){
                    invalidInput = false;
                }
            }
            catch (Exception e){ //handle exp
            }
            reader.close();
        } while (invalidInput);
        return input;
    }

    public String getInputInt(String message){

        Scanner reader = new Scanner();
        boolean invalidInput = true;

        do{
            System.out.println(message);
            try{
                String input = reader.nextLine();
                //Need if 
            }
            catch (Exception e){ //handle exp
            }
            reader.close();
        } while (invalidInput);
        return input;
    }
}