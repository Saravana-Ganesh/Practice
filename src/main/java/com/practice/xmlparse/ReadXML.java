package com.practice.xmlparse;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;  
public class ReadXML  
{  
	public static void main(String argv[])   
	{ 
			//creating a constructor of file class and parsing an XML file  
			File file = new File("src//main//java//resources//Sample.xml");  
			if(file.exists()) {
				try{
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
				DocumentBuilder db = dbf.newDocumentBuilder();  
				Document doc = db.parse(file);  
				NodeList nodeList = doc.getElementsByTagName("student");  
				for (int itr = 0; itr < nodeList.getLength(); itr++){  
					Node node = nodeList.item(itr);  
					Element eElement = (Element) node;
					System.out.println("\nNode Name :" + node.getNodeName());  
					System.out.println("Student id: "+ eElement.getElementsByTagName("id").item(0).getTextContent());  
					System.out.println("Name: "+ eElement.getElementsByTagName("name").item(0).getTextContent());  				
					System.out.println("Marks: "+ eElement.getElementsByTagName("marks").item(0).getTextContent());
				}  
				NodeList nodeList1= doc.getElementsByTagName("teacher");
				for(int i=0;i<nodeList1.getLength();i++) {
					Node node = nodeList1.item(i);  
					Element eElement = (Element) node;
					System.out.println("\nNode Name :" + node.getNodeName());  
					System.out.println("id: "+ eElement.getElementsByTagName("id").item(0).getTextContent());  
					System.out.println("Name: "+ eElement.getElementsByTagName("name").item(0).getTextContent());  				
					System.out.println("Marks: "+ eElement.getElementsByTagName("marks").item(0).getTextContent());
				}
			}   
			catch (Exception e) {  
				e.printStackTrace();  
			} 
			}else {
				System.out.println("File not found");
			}
			 
	}  
}  