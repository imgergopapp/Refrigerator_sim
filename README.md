# Refrigerator_sim
Simulation of a (Smart)Refrigerator.

## Classes
  * ### Consumable
    Superclass of **Food** & **Drink**. Constructs **Consumable** (**Food** and **Drink**).  
    **isEdible** method prints the consumable's best before date is expired or not (*compared to today*).  
  * ### Drink
    Subclass of **Consumable**. Constructs **Drink**.  
    **makeConsumable** method (***Overload***) returns an array of **Drink**'s properties.  
    **toString** method (***Overload***) prints out **Drink**'s properties.  
  * ### Food
    Subclass of **Consumable**. Constructs **Food**.  
    **makeConsumable** method (***Overload***) returns an array of **Food**'s properties.  
    **toString** method (***Overload***) prints out **Food**'s properties.   
  * ### Fridge   
    Stores **Consumable**s.
    **getFridgeItems** method returns an array of **Drink**s and **Food**s.  
    **findConsumable** method returns **Consumable** which has the same name in arguments.  
    **getFridgeItemNames** method returns an array of **Consumable**'s names.  
    **getFridgeItemNames** method (***Overload***) returns an array of **Food**'s or **Drink**'s names.  
  * ### Input
    Contains only ***static*** methods. Uses **try-cath** to get the correct input type.  
    **getInputInt** method returns an **int** *in a specified range*.  
    **getInputInt** method (***Overload***) returns an **int**.  
    **getInputString** method returns a **String** *from a specified array*.  
    **getInputString** method (***Overload***) returns a **String**.   
    **isAlphabetic** method returns **boolean**, checks if the **String** contains only letters.  
  * ### Output 
    Prints out to the console.  
    **printMenu** method prints out menu's options and it's indexes.  
    **showFridgeElements** method prints out **Consumable**s.  
  * ### XmlParser
    Contains ***C.R.U.D*** ***static*** methods for **Xml**s.  
    **createDocument** method returns a **Document**.  
    **save** method *saves/writes* the *modified* **Document** to the **Xml**.  
    **delete** method deletes the *selected* **Consumable** from the **Xml**.  
    **update** method updates the *selected* **Consumable** in the **Xml**.  
    **read** method reads *all* **Consumable** from the **Xml**.  
    **write** method appends the **Xml** with a **Consumable**.
  * ### Main
    Handles menu navigation and *creates* **Fridge**.
    
  
    
    
    
   
    
    
    
