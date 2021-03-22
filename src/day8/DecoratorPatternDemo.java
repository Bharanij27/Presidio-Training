package day8;

public class DecoratorPatternDemo {
	
	public static void main(String[] args) {
		Food thali=new Rice(new Daal(new Chicken(new Rice())));
		System.out.println("Cost of Rice..+Daal..+chicken+rice..:"+thali.cost());
	}
}
//static composition - static composition is achieved through generalization - part whole hierarchy
abstract class Food{
	public abstract int cost();
}
abstract class VegFood extends Food{
	
}
abstract class NonVegFood extends Food{
	
}
//To do static composition we need to use the constructor
class Rice extends VegFood{
	public static Rice instance;
	private Food food;
	
	public Rice() {
		
	}

	public Rice(Food food) {
		this.food=food;
	}
	
//	synchronized public static Rice createObject() throws Exception{
//		if(instance == null) {
//			instance = new Rice();
//		}
//		return instance.createClone();		
//	}
//
//	public  Rice createClone() throws Exception{	
//			return (Rice) super.clone();		
//	}
	
	@Override
	public int cost() {
		if(food != null) {
			return 10 + food.cost();
		}
		else {
				return 10;
			}
	}
}

class Daal extends VegFood{
	private Food food;
	public Daal instance;

	public Daal() {
		
	}
	
	public Daal(Food food) {
		this.food = food;
	}
	
	@Override
	public int cost() {
		if(food != null) {
			return 5 + food.cost();
		}
		else {
				return 5;
			}
	}
}

class Chicken extends NonVegFood{
	private Food food;
	public Chicken instance;
	
	public Chicken() {
		
	}
	
	public Chicken(Food food) {
		this.food = food;
	}
	
	@Override
	public int cost() {
		if(food!=null) {
			return 20 + food.cost();
		}
		else {
			return 20;
		}
	}
}