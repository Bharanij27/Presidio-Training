package lab;


class AccessModifier {	
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


public class Q22 {
	public static void main(String[] args) {
		AccessModifier obj = new AccessModifier();
		System.out.println("public" + obj.pub);
	//	System.out.println("private" + obj.pri);
		System.out.println("protected "+ obj.pro);
		System.out.println("no mod" + obj.nomod);
		
		obj.display();
		obj.Protected();
		obj.Public();
		//obj.Private;
	}
}
