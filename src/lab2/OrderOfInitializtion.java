package lab2;

public class OrderOfInitializtion {
	static {
		System.out.println("Static is executed");
	}
	
	public OrderOfInitializtion() {
		System.out.println("Constuctor is executed");
	}

	public static void main(String[] args) {
		OrderOfInitializtion obj = new OrderOfInitializtion();
	}
}
