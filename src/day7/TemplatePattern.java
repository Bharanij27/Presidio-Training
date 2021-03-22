package day7;

public class TemplatePattern {
	public static void main(String[] args) {
		Dominos newShop = new DominosFranchise();
		newShop.dominosProcess();
	}
}


abstract class Dominos{
	final public static void cookingProcess(){	//  Template methods - parts
		System.out.println("domino chief cook has defined the process...");
	}
	
	final public static void addIngredient(){
		System.out.println("domino chief cook has defined the ingredients... ");
	}
	
	final public static void packingProcess(){
		System.out.println("domino chief cook has defined the Packing");
	}
	
	final public static void collectionProcess(){
		System.out.println("domino chief cook has defined the Collection process");
	}
	
	public abstract void cookPizza();
	public abstract void deliverPizza();
	
	final public void dominosProcess(){ 	// Template Method - whole
		cookPizza();
		deliverPizza();
		collectionProcess();
	}
}


class DominosFranchise extends Dominos{
	@Override
	public void cookPizza() {
		System.out.println("pizza cooking  started...");
		cookingProcess();
		addIngredient();
		System.out.println("pizza ready......");
	}
	
	@Override
	public void deliverPizza() {
		packingProcess();
		System.out.println("Delivering Pizza...");
	}
}
