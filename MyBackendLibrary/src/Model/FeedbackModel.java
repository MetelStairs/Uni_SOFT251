/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.FeedbackDao;
import Entities.Appointment;
import Entities.Feedback;
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
public class FeedbackModel implements FeedbackDao{
    private String file;
    private Feedback feedback;
    private List<Feedback> list;

    public FeedbackModel() {
        file = "DataFile.xml";
    }

    public FeedbackModel(String path) {
        file = path + File.separator + "DataFile.xml";
    }

    @Override
    public List<Feedback> getFeedBack() {
        list = new ArrayList<>();
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node feedbacks = doc.getElementsByTagName("feedbacks").item(0);

            NodeList nList = feedbacks.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("feedback".equals(eElement.getNodeName())) {
                        feedback = new Feedback(eElement.getAttribute("doctor"),
                                eElement.getAttribute("feedback"));

                        list.add(feedback);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean saveFeedBack(Feedback feedback) {
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node feedbacks = doc.getElementsByTagName("feedbacks").item(0);

            Element userElement = doc.createElement("feedback");
            Attr attr =  doc.createAttribute("doctor");
            attr.setValue(feedback.getDoctor());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("feedback");
            attr.setValue(feedback.getFeedback());
            userElement.setAttributeNode(attr);
            
            feedbacks.appendChild(userElement);
            feedbacks.appendChild(doc.createTextNode("\n"));

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
