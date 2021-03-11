package lab;

public class Q23 {
	protected int data = 10; 
}

class Derived{
	void accessProtected() {
		Q23 obj = new Q23();
		obj.data++;
		System.out.println(obj.data);
	}
}
