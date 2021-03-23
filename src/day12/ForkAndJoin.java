package day12;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoin {
	public static void main(String[] args) {
		String names[] = {"padala", "meghana", "kalpana", "kanpur", "megha", "raghul", "raghul", "mohan", "raghul", "meghana"};
		int count = 0;
		for(String s : names) {
			if(s.equalsIgnoreCase("raghul")) count++;
		}
		System.out.println("Roghul : " + count);
		
		ForkJoinPool fjp = ForkJoinPool.commonPool();
		
		MyTask task1 = new MyTask(names, 0, 3, "raghul");
		MyTask task2 = new MyTask(names, 3, 5, "raghul");
		MyTask task3 = new MyTask(names, 5, 7, "raghul");
		MyTask task4 = new MyTask(names, 7, 9, "raghul");
		
		int res1 = task1.invoke();
		int res2 = task2.invoke();
		int res3 = task3.invoke();
		int res4 = task4.invoke();
		
		System.out.println("By fork and join " + (res1 + res2 + res3 + res4));
	}
}


class MyTask extends RecursiveTask<Integer>{
	String arr[];
	int start,end;
	String searchString;
	
	public MyTask(String arr[],int start,int end,String searchString) {
		this.arr=arr;
		this.start=start;
		this.end=end;
		this.searchString=searchString;
	}
	
	@Override
	protected Integer compute() {
		int count = 0;
		for(int  i = start; i < end; i++) {
			if(arr[i].equalsIgnoreCase(searchString)) count++;
		}
		return count;
	}
}