import java.util.Date;
import java.text.SimpleDateFormat;

public class Consumable{

    //Instance Fields
    private String name;
    private String bestBefore;
    private int calories;

    //Constructor
    public Consumable(String name, String bestBefore, int calories){
        this.name = name;
        this.bestBefore = bestBefore;
        this.calories = calories;
    }

    //Methods - Setters:

    public void setName(String newName){
        this.name = newName;
    }

    public void setBestBefore(String newBestBefore){
        this.bestBefore = newBestBefore;
    }

    public void setCalories(int newCalories){
        this.calories = newCalories;
    }
    
    //Methods - Getters:

    public String getName(){
        return this.name;
    }

    public String getBestBefore(){
        return this.bestBefore;
    }

    public int getCalories(){
        return this.calories;
    }

    //Methods - Others:

    public void isEdible(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        try{ 
            Date date = sdf.parse(this.bestBefore);
            long daysExpire = Math.abs((now.getTime() - date.getTime()) / 86_400_000);
            if (now.getTime() > date.getTime()){
                System.out.println(this.name + " is NOT edible!");
                System.out.print(this.name + " was expired by " + String.valueOf(daysExpire) + " day(s) !!!");
            }
            else{
                System.out.println(this.name + " is edible!");
                System.out.print(this.name + " will be expired after " + String.valueOf(daysExpire) + " day(s) !!!");            
            }
            System.out.println(" ( " + bestBefore + " )\n");
        }
        catch (Exception e){ // Need to handle exceptions
            System.out.println(e);
        }
    }
}