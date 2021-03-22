package day11;

public class TwoThreadDemo {

	public static void main(String[] args){
		System.out.println("first line.....");
		//new Thread(()->{met();}).start();  // -> creating new thread so on thread 2 waits main will execute -> first third second
		met(); // -> first line second third because everything in same thread java is default single thread
		System.out.println("third line...");
		
	}
	
	static void met() {
		try{Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("second line...");
	
	}
}