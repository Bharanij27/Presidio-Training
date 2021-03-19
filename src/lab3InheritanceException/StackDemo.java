package lab3InheritanceException;

public class StackDemo {
	public static void main(String[] args) {
		Stack normalStack = new DynamicStack(2);
		System.out.println(normalStack.push(0));
		System.out.println(normalStack.push(1));
		System.out.println(normalStack.push(2));
		
		System.out.println(normalStack.pull());
		System.out.println(normalStack.pull());
		System.out.println(normalStack.pull());
	}
}

abstract class Stack{
	abstract public String push(int num);
	abstract public String pull();
}

class FixedStack extends Stack{
	public int size = 0;
	public int[] arr;
	int top = -1;
	public FixedStack(int size) {
		this.size = size;
		this.arr = new int[size];
	}
	
	@Override
	public String pull() {
		if(this.top <= -1 ) return "Cannot pull stack underload";
		int num = this.arr[top];
		this.top--;
		return num + " removed from stack";
	}
	
	@Override
	public String push(int num) {
		if(this.top >= this.size - 1 ) return "Cannot push stack overload";
		this.top++;
		this.arr[top] = num;
		return num + " added to stack";
	}
}

class DynamicStack extends Stack{
	public int size = 0;
	public int[] arr;
	int top = -1;
	public DynamicStack(int size) {
		this.size = size;
		this.arr = new int[size];
	}
	
	@Override
	public String pull() {
		if(this.top <= -1 ) return "Cannot pull stack underload";
		int num = this.arr[top];
		this.top--;
		return num + " removed from stack";
	}
	
	@Override
	public String push(int num) {
		if(this.top >= this.size - 1) updateArray();
		this.top++;
		this.arr[top] = num;
		return num + " added to stack";
	}
	
	public void updateArray() {
		this.size *= 2;
		int[] newArr = new int[this.size];
		for(int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		this.arr = newArr;
	}
}