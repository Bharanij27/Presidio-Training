package funLab6;


interface NewInterface{
	int a = 10;
	public void printValue();
}

public class InterfaceReference implements NewInterface {
	
	@Override
	public void printValue() {
		// TODO Auto-generated method stub
		System.out.println("Accessing Interface value a in class : " + NewInterface.a);
	}
	
	public static void main(String[] args) {
		NewInterface obj = new InterfaceReference();
		obj.printValue();
	}
}
