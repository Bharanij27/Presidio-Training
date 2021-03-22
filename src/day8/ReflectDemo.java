package day8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		Politician p = new Politician();
		PoliceStation ps = new PoliceStation();
		//Doctor doc = new Doctor();
		//ps.arrest(doc);
		ps.arrest(p);
	}
}


class PoliceStation{
	public void arrest(Object p) throws Exception {
		//Politician pol=(Politician)p;
		//System.out.println(pol.name);
		//pol.doWork();
		//interrogation
		
		Class criminal = p.getClass();
		Field criminalName = criminal.getField("name");
		System.out.println(criminalName.get(p));
		
		Method m=criminal.getMethod("doWork");
		m.invoke(p);
		
		// Torture -> getting private data
		
		criminalName = criminal.getDeclaredField("secretName");
		criminalName.setAccessible(true);
		
		Method work = criminal.getDeclaredMethod("secretWork");
		work.setAccessible(true);
		work.invoke(p);
	}
}

class Politician{
	public String name = "Good man";
	private String secretName = "Thief";
	
	public void doWork(){
		System.out.println("Social Work.........");
	}
	
	private void secretWork(){
		System.out.println("Steal Money.........");
	}
}

class Doctor{
}