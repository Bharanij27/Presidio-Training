package day2;

import java.time.LocalDate;

public class HelloWorld {
	static int a;
	int b;
	public HelloWorld() {
		System.out.println("a in constructor" + a + " "+ b);
	}
	
	static {
		a  = 10;
		System.out.println("a in static " + a);
	}
	
	public static void main(String[] args) {
		new HelloWorld();
		if(args.length == 2) {			
			System.out.println("Hello World..." + args[0] + args[1]);
		}
		else {
			System.out.println("Hai");
		}
	}
	
	void demo(){
		
	}	
}
