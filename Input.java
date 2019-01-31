import java.util.Scanner;

public class Input{
    Scanner reader = new Scanner(System.in);

    public int getInputInt(String message,int rangeFrom, int rangeTo){
        do{
            System.out.println(message);
            try{
                int input = reader.nextInt();
                reader.nextLine();
                if (input > rangeFrom && input < rangeTo){
                    return input;
                }
            }
            catch (Exception e){ //handle exp
            }
            finally{
                //reader.close();
            }
        } while (true);
    }

    public int getInputInt(String message){
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

    public String getInputString(String message){
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

    public boolean isAlphabetic(String word){
        char[] charArray = word.toCharArray();
        for (char charachters : charArray){
            if (!Character.isLetter(charachters)){
                return false;
            }
        }
        return true;
    }
}