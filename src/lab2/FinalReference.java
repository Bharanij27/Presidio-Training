package lab2;

public class FinalReference {
	public static void main(String args[]){
		final Demo obj = new Demo(10);
		System.out.println("Before Change : " + obj.value);
		obj.value = 20;
		System.out.println("After Change : " + obj.value);
	}
}


class Demo{
	int value;
	Demo(int value) {
		this.value = value;
	}
}
