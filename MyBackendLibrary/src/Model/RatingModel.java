/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.RatingDao;
import Entities.Rating;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Elis Roberts
 */
public class RatingModel implements RatingDao{

    private String file;
    private Rating rating;
    private List<Rating> list;

    public RatingModel() {
        file = "DataFile.xml";
    }

    public RatingModel(String path) {
        file = path + File.separator + "DataFile.xml";
    }
    @Override
    public List<Rating> getRatings() {
        list = new ArrayList<>();
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node ratings = doc.getElementsByTagName("ratings").item(0);

            NodeList nList = ratings.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("rating".equals(eElement.getNodeName())) {
                        rating = new Rating(Integer.parseInt(eElement.getAttribute("rate")),
                                eElement.getAttribute("message"),
                                eElement.getAttribute("user"),
                                eElement.getAttribute("doctor"));
                        
                        list.add(rating);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean saveRating(Rating rating) {
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node ratings = doc.getElementsByTagName("ratings").item(0);

            Element userElement = doc.createElement("rating");
            Attr attr =  doc.createAttribute("rate");
            attr.setValue(String.valueOf(rating.getRate()));
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("message");
            attr.setValue(rating.getMessage());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("user");
            attr.setValue(rating.getUser());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("doctor");
            attr.setValue(rating.getDoctor());
            userElement.setAttributeNode(attr);

            ratings.appendChild(userElement);
            ratings.appendChild(doc.createTextNode("\n"));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(file));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deletRating(String user, String doctor) {
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node ratings = doc.getElementsByTagName("ratings").item(0);

            NodeList nList = ratings.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("rating".equals(eElement.getNodeName()) && 
                            eElement.getAttribute("user").equals(user) && 
                            eElement.getAttribute("doctor").equals(doctor)) {
                        ratings.removeChild(nNode);
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(file));
            transformer.transform(source, result);
            } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
}
