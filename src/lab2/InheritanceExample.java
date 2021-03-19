package lab2;
import lab3InheritanceException.InterfaceQ5;

public class InheritanceExample implements InterfaceQ5{
	@Override
	public void method1() {
		System.out.println("Method 1");
	}
	
	@Override
	public void method2() {
		System.out.println("Method 2");	
	}
	
	@Override
	public void method3() {
		System.out.println("Method 3");
	}
	
	public static void main(String[] args) {
		InheritanceExample obj = new InheritanceExample();
		obj.method1();
		obj.method2();
		obj.method3();
	}
}
