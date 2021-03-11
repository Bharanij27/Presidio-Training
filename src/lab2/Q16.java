package lab2;

class X { 
	void do1() {
		System.out.println("Do 1");
	} 
}  

class Y extends X { 
	void do2() { 
		System.out.println("Do 2");
	} 
} 

public class Q16 {  
	public static void main(String [] args) {  
		X x1 = new X();  
		X x2 = new Y(); 
		Y y1 = new Y(); 
		((Y)x2).do2();  
	}  
}