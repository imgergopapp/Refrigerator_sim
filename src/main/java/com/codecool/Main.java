import java.util.ArrayList;

public class Main{
    

    public static void main(String[] args){

        ArrayList<Consumable> fridgeElements = new ArrayList<Consumable>();
        Input Input = new Input();

        Fridge refridgerator = new Fridge();
        fridgeElements.add(refridgerator.apple);
        fridgeElements.add(refridgerator.chocolate);

        Output output = new Output();

        String[] menuTitles = {"Exit","Whats in the fridge"};
        output.printMenu(menuTitles);
        int input = Input.getInputInt("Plase choose a menupoitn", 0, 10); //need to set rangeTo

        switch(input){
            case 1:
            System.out.println("\nThe elements of the fridge currently: ");
            for (Consumable consumables : fridgeElements){
                System.out.println(consumables.getName());
            }
            case 2: //Create Consumable in XML database
            String name = Input.getInputString("Food name: ");
            String bestBefore; //input handling need - mm.dd.yyyy
            int calories = Input.getInputInt("Calories value: ");
            boolean isSpicy; // input handling need - true or false
            //Food food = new Food(name, bestBefore, calories, isSpicy);
            case 3: //Read from XML database
            System.out.println();
            break;
            case 4: //Update in XML database
            System.out.println();
            break;
            case 5: //Delete from database
            System.out.println();
            break;

        }



        

        
        
        

        
    }

}