package funLab6;

public class MethodOverriding {
	public static void main(String[] args) {
		ChildClass obj = new ChildClass();
		obj.display();
	}
}


class ParentClass{
	public void display(){
		System.out.println("Display on Parent");
	}
}


class ChildClass extends ParentClass{
	public void display(){
		super.display();
		System.out.println("Display on Child");
	}
}