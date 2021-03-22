package day11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future f = es.submit(new MyCallabel());
		//Thread.sleep(500);
		String res = (String)f.get();
		//System.out.println(1);
		System.out.println(res);
	}
}

class MyCallabel implements Callable<String>{
	
	@Override
	public String call() throws Exception {
		System.out.println("Callable called");
		//Thread.sleep(200);
		return "Hello....";
	}
}
