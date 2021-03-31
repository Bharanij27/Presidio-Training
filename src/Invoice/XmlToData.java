package Invoice;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlToData {
	
	public  Map<Integer, Object> toCollection() throws Exception {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		FileInputStream fis = new FileInputStream("XMLData.xml");
		MyProcessHandler handler = new MyProcessHandler();
		sp.parse(fis, handler);
		
		Map<Integer, Object> data = new TreeMap<Integer, Object>();
		
		int orderCount = 0;
		
		for (Iterator iterator = handler.getUsers().iterator(); iterator.hasNext();) {
			Order product = (Order) iterator.next();
			data.put(orderCount++, product.toObject());
		}
		
		return data;
	}
}


class MyProcessHandler extends DefaultHandler{
    //This is the list which shall be populated while parsing the XML.
    private ArrayList orderList = new ArrayList();
 
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
 
        if ("Package".equals(qName))
        {
            Order order = new Order();
            if(attributes != null && attributes.getLength() == 1)
            {
            	order.setId(attributes.getValue(0));
            }
            this.objectStack.push(order);
        }
    }
 
    public void endElement(String uri, String localName, String qName) throws SAXException{
        this.elementStack.pop();
 
        if ("Package".equals(qName))
        {
            Order object = (Order) this.objectStack.pop();
            this.orderList.add(object);
        }
    }
 

    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String value = new String(ch, start, length).trim();
 
        if (value.length() == 0) return; 
       
        Order order = (Order) this.objectStack.peek();
        if ("day".equals(currentElement()))
        {
        	order.setDay(Integer.parseInt(value));
        }
        else if ("month".equals(currentElement()))
        {
        	order.setMonth(Integer.parseInt(value));
        }
        else if ("year".equals(currentElement()))
        {
        	order.setYear(Integer.parseInt(value));
        	order.setOrderDate(LocalDate.of(order.year, order.month, order.day));
        }
        else if ("workHour".equals(currentElement()))
        {
        	order.setWorkHour(Integer.parseInt(value));
        }
        else if ("speed".equals(currentElement()))
        {
        	order.setSpeed(Double.parseDouble(value));
        }
        else if ("distance".equals(currentElement()))
        {
        	order.setDistance(Double.parseDouble(value));
        }
    }
 
    private String currentElement()
    {
        return (String) this.elementStack.peek();
    }
 
    public ArrayList getUsers()
    {
        return orderList;
    }
}

class Order{
	int day, month, year;
	LocalDate orderDate;
	double distance;
	double speed;
	int workHour;
	String id;
	
	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	
	
	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getWorkHour() {
		return workHour;
	}

	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}

	@Override
	public String toString() {
		return this.orderDate.toString() + " " + this.distance + " " + this.speed + " " + this.workHour;
	}
	
	public Order toObject(){
		return this;
 	}
}