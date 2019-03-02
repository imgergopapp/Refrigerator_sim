package com.codecool.io;

import com.codecool.main.Consumable;
import com.codecool.main.ConsumableType;
import com.codecool.main.Drink;
import com.codecool.main.Food;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class XmlParser {

    private static File xmlFile;

    // Creating Document type obj.
    private static Document createDocument(String category) {
        xmlFile = new File("src/data/" + category + "s.xml");
        Document document = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(xmlFile);
        } catch (Exception e) {

        }
        return document;
    }

    // Write the document to the XMl
    private static void save(Document document, String category) {
        TransformerFactory factory = TransformerFactory.newInstance();

        Document documentClean = removeEmptyNodes(document);
        DOMSource domSource = new DOMSource(documentClean);
        StreamResult streamResult = new StreamResult(new File("src/data/" + category + "s.xml"));
        try {
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(domSource, streamResult);
        } catch (Exception e) {

        }
    }

    //Delete from the Xml
    public static void delete(String consumableName, String category) {
        Document document = createDocument(category);
        String node = category.equals("food") ? "Food" : "Drink";

        NodeList nList = document.getElementsByTagName(node);
        for (int i = 0; i < nList.getLength(); i++) {
            Element consumable = (Element) nList.item(i);
            Element name = (Element) consumable.getElementsByTagName("name").item(0);
            String currentName = name.getTextContent();
            if (currentName.equals(consumableName)) {

                consumable.getParentNode().removeChild(consumable);
                break;
            }
        }
        save(document, category);
    }

    //Update
    public static void update(String originalName, String[] newProperties, String category) {
        Document document = createDocument(category);
        String node = category.equals("food") ? "Food" : "Drink";

        NodeList nList = document.getElementsByTagName(node);
        for (int i = 0; i < nList.getLength(); i++) {
            Element consumable = (Element) nList.item(i);
            Element name = (Element) consumable.getElementsByTagName("name").item(0);
            String currentName = name.getTextContent();
            if (currentName.equals(originalName)) {

                consumable.getElementsByTagName("name").item(0).setTextContent(newProperties[0]);
                consumable.getElementsByTagName("bestbefore").item(0).setTextContent(newProperties[1]);
                consumable.getElementsByTagName("calories").item(0).setTextContent(newProperties[2]);

                if (category.equals("food")) {
                    consumable.getElementsByTagName("isspicy").item(0).setTextContent(newProperties[3]);
                } else {
                    consumable.getElementsByTagName("isalcoholic").item(0).setTextContent(newProperties[3]);
                    consumable.getElementsByTagName("isfizzy").item(0).setTextContent(newProperties[4]);
                }
            }
        }
        save(document, category);
    }

    //Read Xml & return with it's items
    public static Consumable[] read(String category) {
        Document document = createDocument(category);
        String node = category.equals("food") ? "Food" : "Drink";
        ConsumableType type = category.equals("food") ? ConsumableType.FOOD : ConsumableType.DRINK;
        NodeList nList = document.getElementsByTagName(node);
        Consumable[] consumables = new Consumable[nList.getLength()];

        for (int i = 0; i < nList.getLength(); i++) {
            String name = document.getElementsByTagName("name").item(i).getTextContent();
            String bestBefore = document.getElementsByTagName("bestbefore").item(i).getTextContent();
            int calories = Integer.valueOf(document.getElementsByTagName("calories").item(i).getTextContent());
            if (node.equals("Food")) {
                boolean isSpicy = Boolean.parseBoolean(document.getElementsByTagName("isspicy").item(i).getTextContent());
                Food food = new Food(name, bestBefore, calories, type, isSpicy);
                consumables[i] = food;
            } else {
                boolean isalcoholic = Boolean.parseBoolean(document.getElementsByTagName("isalcoholic").item(i).getTextContent());
                boolean isFizzy = Boolean.parseBoolean(document.getElementsByTagName("isfizzy").item(i).getTextContent());
                Drink drink = new Drink(name, bestBefore, calories, type, isalcoholic, isFizzy);
                consumables[i] = drink;
            }
        }
        return consumables;
    }

    //Write to Xml
    public static void write(String[] properties, String category) {
        Document document = createDocument(category);

        Element root = document.getDocumentElement();
        String node = category.equals("food") ? "Food" : "Drink";
        Element consumable = document.createElement(node);

        root.appendChild(consumable);

        Element name = document.createElement("name");
        Element bestbefore = document.createElement("bestbefore");
        Element calories = document.createElement("calories");

        name.appendChild(document.createTextNode(properties[0]));
        bestbefore.appendChild(document.createTextNode(properties[1]));
        calories.appendChild(document.createTextNode(properties[2]));

        consumable.appendChild(name);
        consumable.appendChild(bestbefore);
        consumable.appendChild(calories);

        if (node.equals("Food")) {
            Element isspicy = document.createElement("isspicy");
            isspicy.appendChild(document.createTextNode(properties[3]));
            consumable.appendChild(isspicy);
        } else {
            Element isAlcoholic = document.createElement("isalcoholic");
            Element isFizzy = document.createElement("isfizzy");
            isAlcoholic.appendChild(document.createTextNode(properties[3]));
            isFizzy.appendChild(document.createTextNode(properties[4]));
            consumable.appendChild(isAlcoholic);
            consumable.appendChild(isFizzy);
        }
        save(document, category);
    }

    private static Document removeEmptyNodes(Document document) {
        XPath xp = XPathFactory.newInstance().newXPath();
        NodeList nl = null;
        try {
            nl = (NodeList) xp.evaluate("//text()[normalize-space(.)='']", document, XPathConstants.NODESET);
        } catch (Exception e) {

        }

        for (int i = 0; i < nl.getLength(); ++i) {
            Node node = nl.item(i);
            node.getParentNode().removeChild(node);
        }
        return document;
    }
}
