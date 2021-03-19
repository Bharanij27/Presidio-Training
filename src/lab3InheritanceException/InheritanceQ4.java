package lab3InheritanceException;

public class InheritanceQ4 {
	public static void m1(inter1 inter1) { 
		inter1.method1(); 
	}
	
	public static void m2(inter2 inter2) { 
		inter2.method3(); 
	}
	
	public static void m3(inter3 inter3) { 
		inter3.method5(); 
	}
	
	public static void m4(inter4 inter4) { 
		inter4.methodNew(); 
	}
	
	
	public static void main(String[] args) {
		Derived obj = new Derived();
		m1(obj);
		m2(obj);
		m3(obj);
		m4(obj);
	}
}



interface inter1{
	public void method1();
	public void method2();
}


interface inter2{
	public void method3();
	public void method4();
}

interface inter3{
	public void method5();
	public void method6();
}

interface inter4 extends inter1, inter2, inter3{
	public void methodNew();
}

class Base{
	public void classMethod() {}
}


class Derived extends Base implements inter4{
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
	
	@Override
	public void method4() {
		System.out.println("Method 4");
	}
	
	@Override
	public void method5() {
		System.out.println("Method 5");
	}
	
	@Override
	public void method6() {
		System.out.println("Method 6");
	}
	
	@Override
	public void methodNew() {
		System.out.println("Method 7");	
	}
	
}