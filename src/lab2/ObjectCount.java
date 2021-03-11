package lab2;

public class ObjectCount {
	static int objCount = 0;
	// we can make increament in constructor as well but in case of multiple constructor use instance block
	{		
		objCount++;
	}
	public ObjectCount() {
		System.out.println("Number of object created till now " + objCount);
	}
	
	public static void main(String[] args) {
		ObjectCount obj1 = new ObjectCount();
		ObjectCount obj2 = new ObjectCount();
		ObjectCount obj3 = new ObjectCount();
	}
}
