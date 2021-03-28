package day15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerialDemo {
	public static void main(String[] args) throws Exception {
		Employee emp=new Employee(1000);
		
		System.out.println(emp.getSalary());
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("emp.dat"));
		
		oos.writeObject(emp);
		
		emp.setSalary(2000);
		
		System.out.println("new Salary..:"+emp.getSalary());
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("emp.dat"));
		Employee empcopy=(Employee)ois.readObject();
		
		System.out.println("Restored...:"+empcopy.getSalary());
		System.out.println("Old one...:"+emp.getSalary());
	}
}

class Employee implements Serializable{
	int salary;
	
	public Employee(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
}
