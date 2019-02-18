package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Food extends Consumable{

    private static File xmlFile = new File("src/data/foods.xml");


    private boolean isSpicy;

    public Food(String name, String bestBefore, int calories, boolean isSpicy){
        super(name, bestBefore, calories);
        this.isSpicy = isSpicy;
    }

    public static String[] makeConsumable(){

        String name = Input.getInputString("Food name: ");

        String month = String.valueOf(Input.getInputInt("Best before - Month: ",1,12));
        String day = String.valueOf(Input.getInputInt("Best before - Day: ",1,28));
        String year = String.valueOf(Input.getInputInt("Best before - Year: ",2000,2030));
        String bestBefore = month + day + year;

        String calories = String.valueOf(Input.getInputInt("Calories: "));
        String isSpicy = Input.getInputString("Is spicy: ");

        return new String[]{name,bestBefore,calories,isSpicy};
    }

    //Xml Methods :
    public static Food[] readXml() throws  Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        NodeList nList = document.getElementsByTagName("Food");
        Food[] foods = new Food[nList.getLength()] ;

        for (int i = 0; i < nList.getLength(); i++){
            String name = document.getElementsByTagName("name").item(i).getTextContent();
            String bestBefore = document.getElementsByTagName("bestbefore").item(i).getTextContent();
            int calories = Integer.valueOf(document.getElementsByTagName("calories").item(i).getTextContent());
            boolean isSpicy = Boolean.parseBoolean (document.getElementsByTagName("isspicy").item(i).getTextContent());
            Food food = new Food(name,bestBefore,calories,isSpicy);
            foods[i] = food;
        }
        return foods;
    }

    public static void writeXml(String[] foodProperties) throws Exception{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(xmlFile);

        Element root = document.getDocumentElement();
        Element food = document.createElement("Food");

        root.appendChild(food);

        Element name = document.createElement("name");
        Element bestbefore = document.createElement("bestbefore");
        Element calories = document.createElement("calories");
        Element isspicy = document.createElement("isspicy");

        name.appendChild(document.createTextNode(foodProperties[0]));
        bestbefore.appendChild(document.createTextNode(foodProperties[1]));
        calories.appendChild(document.createTextNode(foodProperties[2]));
        isspicy.appendChild(document.createTextNode(foodProperties[2]));

        food.appendChild(name);
        food.appendChild(bestbefore);
        food.appendChild(calories);
        food.appendChild(isspicy);

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("src/data/foods.xml"));
        transformer.transform(domSource, streamResult);
    }
}
