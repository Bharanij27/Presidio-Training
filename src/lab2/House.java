package lab2;

public class House {
	Door door[];
	int doorCount = 0;
	int windowCount = 0;
	Window window[];
	double totalCost;
	
	public House() {
		this.totalCost = 0;
		this.door = new Door[10];
		this.window = new Window[10];
	}
	
	public void addDoor(int width, int height) {
		if(doorCount <10) this.door[doorCount++] = new Door(width, height);
	}
	
	public void addWindow(int width, int height) {
		if(windowCount <10) this.window[windowCount++] = new Window(width, height);
	}
	
	public void calculateTotalCost() {
		for(int i = 0; i < this.doorCount; i++) this.totalCost += door[i].cost;
		for(int i = 0; i < this.windowCount; i++) this.totalCost += window[i].cost;
	}
	
	public static void main(String[] args) {
		House newHouse = new House();
		newHouse.addDoor(20, 10);
		newHouse.addDoor(10, 10);
		newHouse.addWindow(5, 8);
		newHouse.calculateTotalCost();
		System.out.println(newHouse.totalCost);
	}
}


class Door{
	int width;
	int height;
	double cost;
	double priceForWidth = 10;
	double priceForheight = 15;
	
	public Door(int width, int height) {
		this.width = width;
		this.height = height;
		this.cost = costForDoor(width, height);
	}
	
	public double costForDoor(int width, int height){
		return ((width * priceForWidth)  + (height * priceForheight)) ;
	}
}

class Window{
	double priceForWidth = 5;
	double priceForheight = 10;
	int width;
	int height;
	double cost;
	
	public Window(int width, int height) {
		this.width = width;
		this.height = height;
		this.cost = costForWindow(width, height);
	}
	
	public double costForWindow(int width, int height){
		return ((width * priceForWidth)  + (height * priceForheight)) ;
	}
}