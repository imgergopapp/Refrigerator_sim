package com.codecool;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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

    public static String[] makeConsumable(){

        String name = Input.getInputString("Drink's name: ");

        String month = String.valueOf(Input.getInputInt("Best before - Month: ",1,12));
        String day = String.valueOf(Input.getInputInt("Best before - Day: ",1,28));
        String year = String.valueOf(Input.getInputInt("Best before - Year: ",2000,2030));
        String bestBefore = month + day + year;

        String calories = String.valueOf(Input.getInputInt("Calories: "));
        String isalcoholic = Input.getInputString("Is alcoholic: ");
        String isfizzy = Input.getInputString("Is fizzy: ");

        return new String[]{name,bestBefore,calories,isalcoholic,isfizzy};
    }

    @Override
    public String toString() {
        return "Drink's name: " + getName() + " | " +
            "Best before: " + getBestBefore() + " | " +
            "Calories: " + getCalories() + " | " +
            "isAlcoholic: " + isAlcoholic + " | " +
            "isFizzy: " + isFizzy;
    }

    //Xml Methods :
    public static Drink[] readXml(){
        Document document = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(xmlFile);
        }
        catch (Exception e){

        }
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



    public static void writeXml(String[] drinkProperties){
        Document document = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(xmlFile);
        }
        catch (Exception e){

        }

        Element root = document.getDocumentElement();
        Element drink = document.createElement("Drink");

        root.appendChild(drink);

        Element name = document.createElement("name");
        Element bestbefore = document.createElement("bestbefore");
        Element calories = document.createElement("calories");
        Element isAlcoholic = document.createElement("isalcoholic");
        Element isFizzy = document.createElement("isfizzy");

        name.appendChild(document.createTextNode(drinkProperties[0]));
        bestbefore.appendChild(document.createTextNode(drinkProperties[1]));
        calories.appendChild(document.createTextNode(drinkProperties[2]));
        isAlcoholic.appendChild(document.createTextNode(drinkProperties[3]));
        isFizzy.appendChild(document.createTextNode(drinkProperties[4]));

        drink.appendChild(name);
        drink.appendChild(bestbefore);
        drink.appendChild(calories);
        drink.appendChild(isAlcoholic);
        drink.appendChild(isFizzy);

        TransformerFactory factory = TransformerFactory.newInstance();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("src/data/drinks.xml"));
        try{
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(domSource, streamResult);

        }
        catch (Exception e){

        }

    }

    
}
