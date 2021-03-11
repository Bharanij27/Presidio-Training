package lab2;

class Parent{
	
	public int pub;
	private int pri;
	protected int pro;
	int nomod;
	
	public void Public() {
		System.out.println("Public method");
	}
	
	private void Private() {
		System.out.println("Private method");
	}
	
	protected void Protected() {
		System.out.println("Protected method");
	}
	
	void display() {
		System.out.println("No modifier method");
	}
}
public class Q9 extends Parent{
	int count = 1;
	
	public void accessParentVariables() {
		System.out.println(pub);
		//System.out.println(pri); cant access
		System.out.println(pro);
		System.out.println(nomod);
	}
	
	public void accessParentMethods() {
		Public();
		//Private(); cant access
		Protected();
		display();
	}
}
