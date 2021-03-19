package lab3InheritanceException;

public class AreaAndVolume {
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		circle.computeArea();
		
		Square square = new Square(8);
		square.computeArea();
		
		Triangle triangle = new Triangle(7, 6, 5);
		triangle.computeArea();
		
		Sphere sphere = new Sphere(9);
		sphere.computeArea();
		sphere.computeVolume();

		Cuboid cuboid = new Cuboid(10);
		cuboid.computeArea();
		cuboid.computeVolume();
	}
}

interface Area{
	public void computeArea();
}

interface Volume{	
	public void computeVolume();
}

class Circle implements Area{
	public int radius;
	public Circle(int r) {
		this.radius = r;
	}
	@Override
	public void computeArea() {
		System.out.println("Area of Circle " + Math.PI * radius * radius);
	}
}


class Square implements Area{
	public int radius;
	public Square(int r) {
		radius = r;
	}
	@Override
	public void computeArea() {
		System.out.println("Area of Square " + radius * radius);
	}
}


class Triangle implements Area{
	public int a, b, c;
	public Triangle(int x, int y, int z) {
		a = x;
		b = y;
		c = z;
	}
	@Override
	public void computeArea() {
		int s = (a + b + c) / 2;
		System.out.println("Area of Triangle " + Math.sqrt(s * (s - a) * (s-b) * (s - c)));
	}
}

class Cuboid implements Area, Volume{
	public int radius;
	public Cuboid(int r) {
		radius = r;
	}
	@Override
	public void computeArea() {
		System.out.println("Area of Cuboid " + radius * radius);
	}
	
	@Override
	public void computeVolume() {
		System.out.println("Volume of Cuboid " + radius * radius * radius);
	}
}

class Sphere implements Area, Volume{
	public int radius;
	public Sphere(int r) {
		radius = r;
	}
	@Override
	public void computeArea() {
		System.out.println("Area of Sphere " + Math.PI * radius * radius);
	}
	
	@Override
	public void computeVolume() {
		System.out.println("Volume of Sphere " + 4 * 3.14 * Math.pow(radius, 3) /3);
	}
}