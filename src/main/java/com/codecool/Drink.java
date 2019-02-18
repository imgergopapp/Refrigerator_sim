package com.codecool;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Drink extends Consumable{

    private static File xmlFile = new File("src/data/drinks.xml");

    private boolean isAlcoholic;
    private boolean isFizzy;

    public Drink(String name, String bestBefore, int calories, boolean isAlcoholic, boolean isFizzy){
        super(name, bestBefore, calories);
        this.isAlcoholic = isAlcoholic;
        this.isFizzy = isFizzy;
    }

    //Xml Methods :
    public static Drink[] readXml() throws  Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        NodeList nList = document.getElementsByTagName("Drink");
        Drink[] drinks = new Drink[nList.getLength()] ;

        for (int i = 0; i < nList.getLength(); i++){
            String name = document.getElementsByTagName("name").item(i).getTextContent();
            String bestBefore = document.getElementsByTagName("bestbefore").item(i).getTextContent();
            int calories = Integer.valueOf(document.getElementsByTagName("calories").item(i).getTextContent());
            boolean isalcoholic = Boolean.parseBoolean (document.getElementsByTagName("isalcoholic").item(i).getTextContent());
            boolean isFizzy = Boolean.parseBoolean (document.getElementsByTagName("isfizzy").item(i).getTextContent());
            Drink drink = new Drink(name,bestBefore,calories,isalcoholic,isFizzy);
            drinks[i] = drink;
        }
        return drinks;
    }

    
}
