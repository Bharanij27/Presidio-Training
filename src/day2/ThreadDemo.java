package day2;

public class ThreadDemo {
	public static void main(String a[]) { 
		new newthread(); 
		Thread t=Thread.currentThread(); 
		t.setName("My thread");
	for(int i=0;i<5;i++) { 
		try{ 
			System.out.println("main"+i);
			Thread.sleep(300);
		}
		catch(InterruptedException e){}
		}
	}
}

class newthread implements Runnable { 
	Thread t; 
	newthread() { 
		t=new Thread(this,"demo thread");
		t.start(); 
	} 
	public void run() { 
		for(int i=0;i<5;i++) { 
			try{
				System.out.println("child"+i); 
				Thread.sleep(300); 
			}
		catch(InterruptedException e){
				}
			}
		}
}
