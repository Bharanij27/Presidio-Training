package lab3InheritanceException;

import java.io.IOException;

public class Q6 {
	public static void main(String[] args) {
		
	}
}

class base{
	public base() throws IOException{
		throw new IOException();
	}
}

class derived extends base{
	public derived() throws IOException {
		try {
			// super has to be first of constructor so it is not possible to catch exception
			// if an exception is thrown from base constructor
			// super();			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}