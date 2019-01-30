/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.AppointmentDao;
import Entities.Appointment;
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
public class AppointmentModel implements AppointmentDao {

    private String file;
    private Appointment appointment;
    private List<Appointment> list;

    public AppointmentModel() {
        file = "DataFile.xml";
    }

    public AppointmentModel(String path) {
        file = path + File.separator + "DataFile.xml";
    }

    @Override
    public List<Appointment> getAppointments() {
        list = new ArrayList<>();
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node appointments = doc.getElementsByTagName("appointments").item(0);

            NodeList nList = appointments.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("appointment".equals(eElement.getNodeName())) {
                        appointment = new Appointment(eElement.getAttribute("user"),
                                eElement.getAttribute("doctor"),
                                eElement.getAttribute("date"),
                                eElement.getAttribute("created"),
                                eElement.getAttribute("attended"));

                        list.add(appointment);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean saveAppointment(Appointment appointment) {
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node appointments = doc.getElementsByTagName("appointments").item(0);

            Element userElement = doc.createElement("appointment");
            Attr attr =  doc.createAttribute("user");
            attr.setValue(appointment.getUser());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("doctor");
            attr.setValue(appointment.getDoctor());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("date");
            attr.setValue(appointment.getDate());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("created");
            attr.setValue(appointment.getCreated());
            userElement.setAttributeNode(attr);

            appointments.appendChild(userElement);
            appointments.appendChild(doc.createTextNode("\n"));

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
    public boolean createAppointment(String user, String date, String doctor) {
        list = getAppointments();
        for (Appointment a : list) {
            if (a.getUser().equals(user) && a.getDate().equals(date)) {
                appointment = a;
                break;
            }
        }
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node appointments = doc.getElementsByTagName("appointments").item(0);

            NodeList nList = appointments.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("appointment".equals(eElement.getNodeName())
                            && eElement.getAttribute("user").equals(user)
                            && eElement.getAttribute("date").equals(date)) {
                        appointments.removeChild(nNode);
                    }
                }
            }
            Element userElement = doc.createElement("appointment");
            Attr attr = doc.createAttribute("user");
            attr.setValue(appointment.getUser());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("doctor");
            attr.setValue(doctor);
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("date");
            attr.setValue(appointment.getDate());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("created");
            attr.setValue("Y");
            userElement.setAttributeNode(attr);

            appointments.appendChild(userElement);
            appointments.appendChild(doc.createTextNode("\n"));

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
    public boolean attendAppointment(String user, String date, String doctor) {
        list = getAppointments();
        for (Appointment a : list) {
            if (a.getUser().equals(user) && a.getDate().equals(date)) {
                appointment = a;
                break;
            }
        }
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node appointments = doc.getElementsByTagName("appointments").item(0);

            NodeList nList = appointments.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("appointment".equals(eElement.getNodeName())
                            && eElement.getAttribute("user").equals(user)
                            && eElement.getAttribute("date").equals(date)) {
                        appointments.removeChild(nNode);
                    }
                }
            }
            Element userElement = doc.createElement("appointment");
            Attr attr = doc.createAttribute("user");
            attr.setValue(appointment.getUser());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("doctor");
            attr.setValue(doctor);
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("date");
            attr.setValue(appointment.getDate());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("created");
            attr.setValue("Y");
            userElement.setAttributeNode(attr);
            
            attr = doc.createAttribute("attended");
            attr.setValue("Y");
            userElement.setAttributeNode(attr);

            appointments.appendChild(userElement);
            appointments.appendChild(doc.createTextNode("\n"));

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
    public boolean deletAppointment(String user, String doctor) {
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node appointments = doc.getElementsByTagName("appointments").item(0);

            NodeList nList = appointments.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("appointment".equals(eElement.getNodeName())
                            && eElement.getAttribute("user").equals(user)
                            && eElement.getAttribute("doctor").equals(doctor)) {
                        appointments.removeChild(nNode);
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
