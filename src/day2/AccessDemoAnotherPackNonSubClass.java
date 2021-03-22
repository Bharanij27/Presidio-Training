package day2;

import day3.AccessDemo;

public class AccessDemoAnotherPackNonSubClass {
	AccessDemo obj = new AccessDemo();
	
	public void display() {
		System.out.println(obj.pub);
		// System.out.println(obj.pri); -> not in same class
		// System.out.println(obj.pro); -> not having a relation
		// System.out.println(obj.nomod); -> not in package
	}
}
