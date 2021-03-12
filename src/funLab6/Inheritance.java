package funLab6;

public class Inheritance {
	public static void main(String[] args) {		
		Child newChildObj = new Child();
		newChildObj.getValue();
		
		B newBObj = new B();
		newBObj.printValue();
	}
}


class A{
	char valueOfA = 'a';
}

class B extends A{
	public void printValue(){
		System.out.println("Value of A is " + valueOfA);
	}
}

class GrandParent{
	int grandData = 10;
}

class Parent extends GrandParent{
	int parentData = 10;
}

class Child extends Parent{
	void getValue(){
		System.out.println("GrandParent data " + grandData);
		System.out.println("Parent data " + parentData);		
	}
}