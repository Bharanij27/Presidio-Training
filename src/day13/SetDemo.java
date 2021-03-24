package day13;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		Set<Student> set = new TreeSet<Student>((o1, o2) ->  {
			return o1.compareTo(o2);
		});
		
		set.add(new Student(100));
		set.add(new Student(400));
		set.add(new Student(120));
		set.add(new Student(290));
		
		System.err.println(set);
	}
}

class Student implements Comparable<Student>{
	Integer mark;
	public Student(Integer mark) {
		this.mark = mark;
	}
	
	@Override
	public int compareTo(Student o) {
		return mark.compareTo(o.mark);
		//return o.mark.compareTo(mark); // descending
	}
	
	@Override
	public String toString() {
		return mark.toString();
	}
	
}
