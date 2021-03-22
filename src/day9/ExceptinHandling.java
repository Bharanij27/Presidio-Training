package day9;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ExceptinHandling {
	public static void main(String[] args) throws Exception {
		Dog dog=new Dog();
		Child child=new Child();
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter the item class..:");
		String itemClass=scan.next();
		Item ic= (Item)Class.forName(itemClass).getConstructor().newInstance();
		System.out.println(ic);
		child.playWithDog(dog, ic);
	}
}


abstract class DogException extends Exception{
	public abstract void visit(Handler911 handler911);
}

class DogBiteException extends DogException{
	public String mesg;
	
	public DogBiteException(String mesg) {
		this.mesg = mesg;
	}
	
	public void visit(Handler911 handler911) {
		handler911.handle(this);
	}
	
	@Override
	public String toString() {
		return mesg.toString();
	}
}

class DogBarkException extends DogException{
	public String mesg;
	
	public DogBarkException(String mesg) {
		this.mesg = mesg;
	}
	
	public void visit(Handler911 handler911) {
		handler911.handle(this);
	}

	@Override
	public String toString() {
		return mesg.toString();
	}
}


class DogHappyException extends DogException{
	public String mesg;
	
	public DogHappyException(String mesg) {
		this.mesg = mesg;
	}
	
	public void visit(Handler911 handler911) {
		handler911.handle(this);
	}
	
	@Override
	public String toString() {
		return mesg.toString();
	}
}

abstract class Item{
	public abstract void execute() throws DogException;
}


class Biscuit extends Item{
	
	public Biscuit() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() throws DogException{
		throw new DogHappyException("Dog is happy for feeding it....");
	}
}

class Stone extends Item{
	public Stone() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() throws DogException{
		throw new DogBiteException("Dog bite for throwing a stone at it....");
	}
}

class Stick extends Item{
	public Stick() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() throws DogException{
		throw new DogBarkException("Dog bark for throwing a stick at it....");
	}
}


class Dog{
	public void play(Item item) throws DogException{
		item.execute();
	}
}

class Child{
	public void playWithDog(Dog dog, Item item){
		try {
			dog.play(item);
		} catch (DogException e) {
			e.visit(new Handler911Impl());
		}
	}
}

interface Handler911{
	public void handle(DogBiteException dbe);
	public void handle(DogBarkException dre);
	public void handle(DogHappyException dre);
}

class Handler911Impl implements Handler911{
	
	@Override
	public void handle(DogBarkException dre) {
		System.out.println("handling logic is written....dont worry...it is just barking......");
	}
	
	@Override
	public void handle(DogBiteException dbe) {
		System.out.println("ambulance is on the way...........dont be panic..........");
	}
	
	@Override
	public void handle(DogHappyException dre) {
		System.out.println("the dog is happy,, enjoying the biscuits......");
	}
}