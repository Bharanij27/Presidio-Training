package day6;

public class Lambda {
	public static void main(String[] args) {
		Inter inter = () -> {
			System.out.println("Basic");
		};		
		inter.func();
	}
}

@FunctionalInterface
interface Inter{
	void func();
}