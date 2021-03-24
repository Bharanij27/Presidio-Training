package CollectionTest;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Q3 {
	public static void main(String[] args) {
		// theows runtime error because 
		// we try to string and int to set and runtime it will try to sort integer and string 
		// that will cause ClassCastEXCEPTION
		before();
	}
	
	public static void before() { 
		Set set = new TreeSet(); 
		set.add("2");
		set.add(3);
		set.add("1");
		Iterator it = set.iterator(); 
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
