/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.MedicineDao;
import Entities.Medicine;
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
public class MedicineModel implements MedicineDao{

    private String file;
    private Medicine medicine;
    private List<Medicine> list;

    public MedicineModel() {
        file = "DataFile.xml";
    }

    public MedicineModel(String path) {
        file = path + File.separator + "DataFile.xml";
    }

   
    @Override
    public List<Medicine> getMedicines() {
        list = new ArrayList<>();
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node medicines = doc.getElementsByTagName("medicines").item(0);

            NodeList nList = medicines.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("medicine".equals(eElement.getNodeName())) {
                        medicine = new Medicine(Integer.parseInt(eElement.getAttribute("quantity")),
                                eElement.getAttribute("name"),
                                eElement.getAttribute("type"),
                                eElement.getAttribute("description"));
                        list.add(medicine);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean stockMedicine(Medicine medicine) {
        for(Medicine med : getMedicines()){
            if(med.getName().equals(medicine.getName())){
                medicine.setQuanity(medicine.getQuanity()+ med.getQuanity());
                updateMedicine(medicine);
                break;
            }
        }
        return true;
    }
    
    @Override
    public boolean saveMedicine(Medicine medicine) {
        for(Medicine med : getMedicines()){
            if(med.getName().equals(medicine.getName())){
                return false;
            }
        }
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node medicines = doc.getElementsByTagName("medicines").item(0);

            Element userElement = doc.createElement("medicine");
            Attr attr = doc.createAttribute("quantity");
            attr.setValue(String.valueOf(medicine.getQuanity()));
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("name");
            attr.setValue(medicine.getName());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("type");
            attr.setValue(medicine.getType());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("description");
            attr.setValue(medicine.getDescription());
            userElement.setAttributeNode(attr);

            medicines.appendChild(userElement);
            medicines.appendChild(doc.createTextNode("\n"));

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

    public boolean updateMedicine(Medicine medicine1) {
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node medicines = doc.getElementsByTagName("medicines").item(0);

            NodeList nList = medicines.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("medicine".equals(eElement.getNodeName()) && eElement.getAttribute("name").equals(medicine.getName())) {
                        medicines.removeChild(nNode);
                         medicine = new Medicine(Integer.parseInt(eElement.getAttribute("quantity")),
                                eElement.getAttribute("name"),
                                eElement.getAttribute("type"),
                                eElement.getAttribute("description"));
                    }
                }
            }
            
            Element userElement = doc.createElement("medicine");
            Attr attr = doc.createAttribute("quantity");
            attr.setValue(String.valueOf(medicine1.getQuanity()));
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("name");
            attr.setValue(medicine.getName());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("type");
            attr.setValue(medicine.getType());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("description");
            attr.setValue(medicine.getDescription());
            userElement.setAttributeNode(attr);

            medicines.appendChild(userElement);
            medicines.appendChild(doc.createTextNode("\n"));

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
