package lab;

public class TestClass {
	static int c = 0;
	public static void main(String[] args) {
		final int a = 1;
		//a++;  cant change constant value
		//Demo obj = new Demo();  contructor undefined error
		//new TestClass().nonStatic();
	}
	
	public void nonStatic() {
		c++;
		System.out.println("static member in non static method " + c);
	}
}


class Demo{
	Demo(int num){
		System.out.println("Paramter in constructor" + num);
	}
}
