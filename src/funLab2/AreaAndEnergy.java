package funLab2;

public class AreaAndEnergy {
	public static void main(String[] args) {
		int r = 10, h = 5;
		double area = (Math.PI * r) + (2 * Math.PI * r * h);
		
		int mass = 100, accelaration = 5, height = 7, velocity = 20;
		double energy = mass * ((accelaration * height * (velocity * velocity)) / 2);
		
		System.out.println("Area is " + area + " and Energy  is " + energy);
	}
}
