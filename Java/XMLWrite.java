package Assignment;

import javax.xml.*;
import javax.xml.parsers.*; 
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWrite {
	
	public static void main(String arg[]) throws ParserConfigurationException, TransformerException {
		
		//	Creating a Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
			
		//	Creating new Document
		Document document = builder.newDocument();	
			
		//	Creating a Root element
		Element root = document.createElement("ProgrammingLanguages");
		document.appendChild(root);
			
			
			
		//	Creating Language elements 
		Element language1 = document.createElement("Language1");
		language1.appendChild(document.createTextNode("C++"));
		Element language2 = document.createElement("Language2");
		language2.appendChild(document.createTextNode("Java"));
		Element language3 = document.createElement("Language3");
		language3.appendChild(document.createTextNode("Python"));
		Element language4 = document.createElement("Language4");
		language4.appendChild(document.createTextNode("Rust"));
		Element language5 = document.createElement("Language5");
		language5.appendChild(document.createTextNode("C Programming"));
		
		root.appendChild(language1);
		root.appendChild(language2);
		root.appendChild(language3);
		root.appendChild(language4);
		root.appendChild(language5);
		
		//	Writing to XML File
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
			
		//	Specifying the Path
		StreamResult result = new StreamResult("D:\\Eclipse-workspace\\Assignment\\src\\Assignment\\output.xml");
		transformer.transform(source, result);
			
	}

}
