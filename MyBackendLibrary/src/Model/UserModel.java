/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.UserDao;
import Entities.User;
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
public class UserModel implements UserDao {

    private String file;
    private User user;
    private List<User> list;

    public UserModel() {
        file = "DataFile.xml";
    }

    public UserModel(String path) {
        file = path + File.separator + "DataFile.xml";
    }

   
    @Override
    public List<User> getUsers() {
        list = new ArrayList<>();
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node users = doc.getElementsByTagName("users").item(0);

            NodeList nList = users.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("user".equals(eElement.getNodeName())) {
                        user = new User(eElement.getAttribute("firstname"),
                                eElement.getAttribute("lastname"),
                                eElement.getAttribute("username"),
                                eElement.getAttribute("type"));
                        user.setPassword(eElement.getAttribute("password"));
                        user.setApproved(eElement.getAttribute("approved"));
                        user.setBy(eElement.getAttribute("by"));
                        user.setTerminate(eElement.getAttribute("terminate"));
                        list.add(user);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User getUser(String username) {
        list = getUsers();
        for (User user1 : list) {
            if (user1.getUsername().equals(username)) {
                return user1;
            }
        }
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        if (getUser(user.getUsername()) != null) {
            return false;
        }
        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node users = doc.getElementsByTagName("users").item(0);

            Element userElement = doc.createElement("user");
            Attr attr = doc.createAttribute("approved");
            attr.setValue("");
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("by");
            attr.setValue("");
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("firstname");
            attr.setValue(user.getFirstName());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("lastname");
            attr.setValue(user.getLastName());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("username");
            attr.setValue(user.getUsername());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("password");
            attr.setValue(user.getPassword());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("type");
            attr.setValue(user.getType());
            userElement.setAttributeNode(attr);

            users.appendChild(userElement);
            users.appendChild(doc.createTextNode("\n"));

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
    public boolean updateUser(User user) {
        if (user == null || getUser(user.getUsername()) == null) {
            return false;
        }

        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node users = doc.getElementsByTagName("users").item(0);

            NodeList nList = users.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println(eElement.getNodeName() + " " + eElement.getAttribute("username"));
                    if ("user".equals(eElement.getNodeName()) && eElement.getAttribute("username").equals(user.getUsername())) {
                        users.removeChild(nNode);
                    }
                }
            }
            Element userElement = doc.createElement("user");
            Attr attr = doc.createAttribute("approved");
            attr.setValue(user.getApproved());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("by");
            attr.setValue(user.getBy());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("firstname");
            attr.setValue(user.getUsername());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("lastname");
            attr.setValue(user.getLastName());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("username");
            attr.setValue(user.getUsername());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("password");
            attr.setValue(user.getPassword());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("type");
            attr.setValue(user.getType());
            userElement.setAttributeNode(attr);

            users.appendChild(userElement);
            users.appendChild(doc.createTextNode("\n"));

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
    public boolean approveUser(String username, String by) {
        User sec = getUser(by);
        User user1 = getUser(username);
        if (sec == null
                || user1 == null
                || user1.getUsername().equals(by)
                || !sec.getType().equals("secretary")) {

            return false;
        }
        user1.setApproved("Y");
        user1.setBy(by);
        updateUser(user1);
        return true;
    }

    @Override
    public boolean deleteUser(String username) {
        if (getUser(username) == null) {
            return false;
        }

        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node users = doc.getElementsByTagName("users").item(0);

            NodeList nList = users.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if ("user".equals(eElement.getNodeName()) && eElement.getAttribute("username").equals(username)) {
                        users.removeChild(nNode);
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

    @Override
    public User loginUser(String username, String password) {
        list = getUsers();
        for (User user1 : list) {
            if (user1.getUsername().equals(username)
                    && user1.getPassword().equals(password)) {
                return user1;
            }
        }
        return null;
    }

    public void terminateAccount(User user) {
        if (user == null || getUser(user.getUsername()) == null) {
            return;
        }

        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node users = doc.getElementsByTagName("users").item(0);

            NodeList nList = users.getChildNodes();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println(eElement.getNodeName() + " " + eElement.getAttribute("username"));
                    if ("user".equals(eElement.getNodeName()) && eElement.getAttribute("username").equals(user.getUsername())) {
                        users.removeChild(nNode);
                        break;
                    }
                }
            }
            Element userElement = doc.createElement("user");
            Attr attr = doc.createAttribute("approved");
            attr.setValue(user.getApproved());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("terminate");
            attr.setValue("Y");
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("by");
            attr.setValue(user.getBy());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("firstname");
            attr.setValue(user.getUsername());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("lastname");
            attr.setValue(user.getLastName());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("username");
            attr.setValue(user.getUsername());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("password");
            attr.setValue(user.getPassword());
            userElement.setAttributeNode(attr);

            attr = doc.createAttribute("type");
            attr.setValue(user.getType());
            userElement.setAttributeNode(attr);

            users.appendChild(userElement);
            users.appendChild(doc.createTextNode("\n"));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(file));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
