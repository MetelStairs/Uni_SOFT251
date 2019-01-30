/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.PrescriptionDao;
import Entities.Prescription;
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
public class PrescriptionModel implements PrescriptionDao {

    private String file;
    private Prescription prescription;
    private List<Prescription> list;

    public PrescriptionModel() {
        file = "DataFile.xml";
    }

    public PrescriptionModel(String path) {
        file = path + File.separator + "DataFile.xml";
    }

    @Override
    public List<Prescription> getPrescriptions() {
        list = new ArrayList<>();
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node prescriptions = doc.getElementsByTagName("prescriptions").item(0);

            NodeList nList = prescriptions.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("prescription".equals(eElement.getNodeName())) {
                        prescription = new Prescription(eElement.getAttribute("user"),
                                eElement.getAttribute("doctor"),
                                eElement.getAttribute("date"),
                                eElement.getAttribute("medicine"),
                                eElement.getAttribute("quantity"),
                                eElement.getAttribute("dose"),
                                eElement.getAttribute("notes"));

                        list.add(prescription);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean savePrescription(Prescription prescription) {
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node prescriptions = doc.getElementsByTagName("prescriptions").item(0);
            
            Element userElement = doc.createElement("prescription");
            Attr attr = doc.createAttribute("user");
            attr.setValue(prescription.getUser());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("doctor");
            attr.setValue(prescription.getDoctor());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("date");
            attr.setValue(prescription.getDate());
            userElement.setAttributeNode(attr);


            attr = doc.createAttribute("medicine");
            attr.setValue(prescription.getMedicine());
            userElement.setAttributeNode(attr);


            attr = doc.createAttribute("quantity");
            attr.setValue(prescription.getQuantity());
            userElement.setAttributeNode(attr);


            attr = doc.createAttribute("dose");
            attr.setValue(prescription.getDose());
            userElement.setAttributeNode(attr);


            attr = doc.createAttribute("notes");
            attr.setValue(prescription.getNotes());
            userElement.setAttributeNode(attr);

            prescriptions.appendChild(userElement);
            prescriptions.appendChild(doc.createTextNode("\n"));

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
