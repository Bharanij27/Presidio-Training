package day11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//scenario - one object and two threads communicating...
// so we can synchronize an object instead of sync methods


// object lock is done  ->  persimistic lock
// Method lock is done  ->  Optimistic lock

public class TwoThreadDemo2 {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		TrainTicketBook book = new TrainTicketBook();
		
		es.execute(() -> {
			synchronized (book) {
				Thread.currentThread().setName("ramu");				
				book.bookTicket(1000);
				book.giveChange();
			}
		});
		
		es.execute(() -> {
			synchronized (book) {
				Thread.currentThread().setName("somu");
				book.bookTicket(500);
				book.giveChange();
			}
		});
	}
}

class TrainTicketBook{
	int amt;
	
	public void bookTicket (int amount) {
		this.amt = amount;
		Thread t = Thread.currentThread();
		String name=t.getName();
		System.out.println("Ticket booked for...:"+name+"....amt is...:"+this.amt);
	}
	
	public void giveChange() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("Change being given to.....:"+name+" and the amount is..."+(amt-100));
	}
}


// Method Lock -> optimistic block

//class TrainTicketBook{
//	int amt;
//	
//	synchronized public void bookTicket (int amount) {
//		this.amt = amount;
//		Thread t = Thread.currentThread();
//		String name=t.getName();
//		System.out.println("Ticket booked for...:"+name+"....amt is...:"+this.amt);
//	}
//	
//	synchronized public void giveChange() {
//		Thread t = Thread.currentThread();
//		String name = t.getName();
//		System.out.println("Change being given to.....:"+name+" and the amount is..."+(amt-100));
//	}
//}
