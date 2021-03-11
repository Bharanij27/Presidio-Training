package lab2;

class Wipro{
	public void overrideMethod() {
		System.out.println("In Wipro");
	}
}

class WiproTechnologies extends Wipro{
	public void overrideMethod() {
		System.out.println("In WiproTech");
	}
}

class WiproInfotech extends Wipro{
	public void overrideMethod() {
		System.out.println("In WiproInfotech");
	}
}

class WiproBPO extends Wipro{
	public void overrideMethod() {
		System.out.println("In WiproBPO");
	}
}

public class WiproCompany {
	public static void main(String[] args) {
		Wipro wiproOperations[] = {new WiproTechnologies(), new WiproInfotech(), new WiproBPO()};
		wiproOperations[0].overrideMethod();
		wiproOperations[1].overrideMethod();
		wiproOperations[2].overrideMethod();
	}
}
