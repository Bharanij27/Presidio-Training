package CollectionTest;

import java.util.*;
public class Q5 {
	public static void main(String[] args) {
		Map<ToDos, String> m = new HashMap<ToDos, String>();
		ToDos t1 = new ToDos("Monday");
		ToDos t2 = new ToDos("Monday");
		ToDos t3 = new ToDos("Tuesday");
		m.put(t1, "doLaundry");
		m.put(t2, "payBills");
		m.put(t3, "cleanAttic");
		System.out.println(m.size()); 
		// returns 3 as three values if hascode un-commented the size will be 2 as t1 and t2 should return true on equals and duplicate is eliminated
	}
}

class ToDos{
	String day;
	ToDos(String d) { day = d; }
	
	public boolean equals(Object o) {
		return ((ToDos)o).day == this.day;
	}
	// public int hashCode() { return 9; }
}