package Assignment;

import java.io.File;

import javax.xml.*;
import javax.xml.parsers.*; 
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLRead {
	
	public static void main(String arg[]) throws Exception{
		
		File xmlFile = new File("D:\\Eclipse-workspace\\Assignment\\src\\Assignment\\output.xml");
		
		
		// Create a DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// Parse the XML File
		Document document = builder.parse(xmlFile);
		
		// Accessing the Element by tag name
		NodeList nodeList = document.getElementsByTagName("ProgrammingLanguages");
		for(int i = 0;i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println("Element Content : " +node.getTextContent());
		}

		
	}

}
