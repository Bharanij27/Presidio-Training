package lab2;

/*
 * Create two classes, A and B, with default constructors (empty argument lists) that announce themselves. 
 * Inherit a new class called C from A, and create a member B inside C. 
 * Do not create a constructor for C. Create an object of class C and observe the results.
 * */

class A{
	A(){
		System.out.println("A default constructor");
	}
}

class B{
	B(){
		System.out.println("B default constructor");
	}
}

// class C
public class Q10 extends A{
	public B obj = new B();
	public static void main(String[] args) {
		Q10 newObj = new Q10();
	}
}
