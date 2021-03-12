package funLab6;

public class ConstructorOverloading {
	int sum = 0;
	
	public ConstructorOverloading() {
		this.sum = 0;
	}
	
	public ConstructorOverloading(int a, int b) {
		// TODO Auto-generated constructor stub
		this.sum = a + b;
	}
	
	public ConstructorOverloading(int a, int b, int c) {
		this.sum = a + b + c;
	}
	
	public static void main(String[] args) {
		ConstructorOverloading obj = new ConstructorOverloading();
		ConstructorOverloading obj1 = new ConstructorOverloading(1, 2);
		ConstructorOverloading obj2 = new ConstructorOverloading(1, 2, 3);
		
		System.out.println(obj.sum);
		System.out.println(obj1.sum);
		System.out.println(obj2.sum);
	}
}
