package day13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class CollectionDemoArrayList {
	public static void main(String[] args) {
		List allValueList = new ArrayList();
		
		for(int i = 0; i < allValueList.size(); i++) {
			System.out.println(allValueList.get(i));
		}
		
		System.out.println("*********************************************");
		for(Object obj : allValueList) {
			System.out.println(obj);
		}

		List<String> list=new ArrayList<>(30);
		
		list.add("hello world");
		list.add("earth");
		list.add(new String("world"));
		
		System.out.println(list);
		
		
		System.out.println("*********************************************");
		Iterator<String> iter=list.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println(iter.hasNext());
		
		System.out.println("************************************************");
		ListIterator<String> liter=list.listIterator();
		while(liter.hasNext()) {
			System.out.println(liter.next());
		}
		
		System.out.println("_______________________________________________");
		while(liter.hasPrevious()) {
			System.out.println(liter.previous());
		}
		
		System.out.println("hai is there....:"+list.contains("hai"));
		list.remove("hai");
		System.out.println("hai is there....:"+list.contains("hai"));
		
		// lsit.sort(new MyComaparator);
		list.sort((o1,o2)->{return o2.compareTo(o1);}); //lambda implementation
		System.out.println(list);
		
		List<String> list2=list.subList(0, 2);
		List<String> list3  = new ArrayList<String>(list.subList(0, 2));
		list3.add("Demo string");
		
		list2.add("new String");
		System.out.println(list2);
		System.out.println("List 3 : " + list3.toString());
		
		System.out.println("After filter  : ");

		Stream<String> stream=list.stream();
		stream.filter((data) -> {
			return !data.equalsIgnoreCase("world");
		}).forEach(el -> {
			System.out.println(el);
		});;
		
		
	}
}
class MyComparator implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
}
class Employee{
	
}
