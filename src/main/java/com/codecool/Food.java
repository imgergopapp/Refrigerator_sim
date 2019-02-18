package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Food extends Consumable{

    private static File xmlFile = new File("src/data/foods.xml");


    private boolean isSpicy;

    public Food(String name, String bestBefore, int calories, boolean isSpicy){
        super(name, bestBefore, calories);
        this.isSpicy = isSpicy;
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


}
