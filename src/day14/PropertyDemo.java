package day14;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropertyDemo {
	public static void main(String[] args) throws Exception{
		Properties prop = new Properties();
		
		//prop.put("key1", "value 1");
		//prop.put("key2", "value 2");
		
		prop.load(new FileInputStream("abc.properties"));
		
		Enumeration e = prop.elements();
		while(e.hasMoreElements()) {
			String value = (String)e.nextElement();
			System.out.println(value);
		}
		
		System.out.println(prop.getProperty("key1"));
	}
}
