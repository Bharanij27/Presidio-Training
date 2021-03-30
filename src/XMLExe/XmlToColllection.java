package XMLExe;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlToColllection {
	public static void main(String[] args) throws Exception {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		FileInputStream fis = new FileInputStream("invoices.xml");
		MyProcessHandler handler = new MyProcessHandler();
		sp.parse(fis, handler);
		
		for (Iterator iterator = handler.getUsers().iterator(); iterator.hasNext();) {
			Item type = (Item) iterator.next();
			System.out.println(type.toString());
		}
	}
}


class MyProcessHandler extends DefaultHandler{
    //This is the list which shall be populated while parsing the XML.
    private ArrayList itemList = new ArrayList();
 
    //As we read any XML element we will push that in this stack
    private Stack elementStack = new Stack();
 
    //As we complete one user block in XML, we will push the User instance in userList
    private Stack objectStack = new Stack();
 
    public void startDocument() throws SAXException{
        //System.out.println("start of the document   : ");
    }
 
    public void endDocument() throws SAXException{
        //System.out.println("end of the document document     : ");
    }
 
    @SuppressWarnings("unchecked")
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.elementStack.push(qName);
 
        if ("item".equals(qName))
        {
            Item item = new Item();
            if(attributes != null && attributes.getLength() == 1)
            {
            	item.setId(attributes.getValue(0));
            }
            this.objectStack.push(item);
        }
    }
 
    public void endElement(String uri, String localName, String qName) throws SAXException{
        this.elementStack.pop();
 
        if ("item".equals(qName))
        {
            Item object = (Item) this.objectStack.pop();
            this.itemList.add(object);
        }
    }
 

    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String value = new String(ch, start, length).trim();
 
        if (value.length() == 0) return; 
       
        Item item = (Item) this.objectStack.peek();
        if ("description".equals(currentElement()))
        {
        	item.setDescription(value);;
        }
        else if ("qty".equals(currentElement()))
        {
           item.setQty(Integer.parseInt(value));
        }
        else if ("price".equals(currentElement()))
        {
           item.setPrice(Double.parseDouble(value));
        }
    }
 
    private String currentElement()
    {
        return (String) this.elementStack.peek();
    }
 
    public ArrayList getUsers()
    {
        return itemList;
    }
}

class Item{
	String id;
	String description;
	double price;
	int qty;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.description + " " + this.price + " " + this.qty;
	}
}