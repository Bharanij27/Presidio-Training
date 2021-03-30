package day17;

import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXmlFile {
	public static void exploreNode(Node e){
		if(e.getNodeValue() != null && e.getNodeValue().trim().length() != 0) {
			System.out.println(e.getNodeValue());
		}
		if(e.hasChildNodes()) {
			NodeList nl = e.getChildNodes();
			for(int i = 0; i < nl.getLength(); i++) {
				exploreNode(nl.item(i));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		dbf.setIgnoringElementContentWhitespace(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document dom = db.parse(new FileInputStream("copyBook.xml"));
		
		Node e = (Node)dom.getDocumentElement();
		exploreNode(e);
	}
}
