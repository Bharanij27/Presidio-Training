package day13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(10, 5);
		v.add("aaaa");
		v.add("bbb");
		v.add("ccc");
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Enumeration e = v.elements();
		v.add("efff");
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
}
