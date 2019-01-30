import java.util.*;

public class Fridge{

        private boolean isOpen;

        Food paprika = new Food("chili paprika", "01.27.2019", 89, true);
        Food jam = new Food("Strawberry jam", "10.08.2020", 320, false);
        Food apple = new Food("Apple", "02.30.2019", 100, false);
        Food chocolate = new Food("Chocolate", "12.01.2017", 100, false);

        Drink beer = new Drink("Beer", "02.22.2022", 156, true);

        //Methods - Setters:
        public void SetIsOpen(boolean isOpen){
            this.isOpen = isOpen;
        }

         //Methods - Getters:
        public boolean GetIsOpen(){
            return this.isOpen;
        }
}