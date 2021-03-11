package lab2;

public class Stack {
	private int arr[];
	private int top;
	private int maxLength;
	
	Stack(int limit){
		this.arr = new int[limit];
		this.top = -1;
		this.maxLength = limit;
	}
	
	public int insert(int num) {
		if(!isFull()) {	
			top++;
			this.arr[top] = num;
			return 1;
		}
		return 0;
	}
	
	public int remove() {
		if(!isEmpty()) {			
			int num = arr[top];
			top--;
			return num;
		}
		return -1;
	}
	
	public int length() {
		return top + 1;
	}
	public Boolean isEmpty() {
	    return top == -1;
	}

	public Boolean isFull() {
	    return top == maxLength - 1;
	}
	
	public void printStack() {
		for(int i = 0; i <= this.top; i++) {
			System.out.println(this.arr[i]);
		}
	}
	
	public static void main(String[] args) {
		Stack obj = new Stack(5);
		obj.insert(0);
		obj.insert(1);
		obj.insert(2);
		obj.printStack();
		obj.remove();
		obj.remove();
		obj.printStack();
	}
}
