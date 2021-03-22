package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadIntro {
	public ThreadIntro() {
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(new ThreadWork());
		es.shutdown();
	}
	
	public static void main(String[] args) throws Exception{
		new ThreadIntro();
		Thread t = Thread.currentThread();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
	}
}


class ThreadWork implements Runnable{
	@Override
	public void run() {
		System.out.println("Child thread");
	}
}