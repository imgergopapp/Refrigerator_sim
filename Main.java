import java.util.ArrayList;

public class Main{
    

    public static void main(String[] args){

        ArrayList<Consumable> fridgeElements = new ArrayList<Consumable>();
        Fridge refridgerator = new Fridge();

        
        fridgeElements.add(refridgerator.apple);
        fridgeElements.add(refridgerator.chocolate);
        

        for (Consumable consumables : fridgeElements){
            System.out.println(consumables.getName());
        }
    }

}