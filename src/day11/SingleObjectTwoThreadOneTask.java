package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleObjectTwoThreadOneTask {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Missile missile = new Missile();
		
		es.execute(() -> {
			synchronized (missile) {
				Thread.currentThread().setName("fill");				
				for(int i = 0; i < 5; i++) {
					missile.fill();					
				}
			}
		});
		
		es.execute(() -> {
			synchronized (missile) {
				Thread.currentThread().setName("shoot");
				for(int i = 0; i < 5; i++) {
					missile.shoot();					
				}
			}
		});
	}
}

class Missile{
	boolean flag;
	
	synchronized public void fill() {
		if(flag) {
			try {
				//Thread.sleep(5000);
				wait();
			}catch(Exception e) {}
		}
		System.out.println("Fill the missile..........");
		flag = true;
		notify();
	}
	
	synchronized public void shoot() {
		if(!flag) {
			try {
				//Thread.sleep(5000);
				wait();
			}catch(Exception e) {}
		}
		System.out.println("Shoot the missile..........");
		flag = false;
		notify();
	}
}