public class Consumable{

    //Instance Fields
    private String name;
    private String bestBefore;
    private int calories;
    private boolean isEdible;

    //Constructor
    public Consumable(String name, String bestBefore, int calories, Boolean isEdible){
        this.name = name;
        this.bestBefore = bestBefore;
        this.calories = calories;
        this.isEdible = isEdible;
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

    public void setIsEdible(boolean newIsEdible){
        this.isEdible = newIsEdible;
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

    public boolean getIsEdible(){
        return this.isEdible;
    }
}