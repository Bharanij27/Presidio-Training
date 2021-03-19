package lab3InheritanceException;

import vehicle.FourWheeler;

public class InheritanceQ7 {
	public static void main(String[] args) {
		Car obj = new Car();
	}
}


class Car extends FourWheeler{
	public Car() {
		System.out.println("Car cons.....");
	}
}