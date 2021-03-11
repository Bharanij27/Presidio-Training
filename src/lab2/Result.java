package lab2;

class Student {
	String name;
	String rollNo;
	
	public Student(String name, String rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
}


class Exam extends Student{
	int physicsMark;
	int chemistryMark;
	int mathsMark;
	
	public Exam(String name, String rollNo, int mark1, int mark2, int mark3) {
		super(name, rollNo);
		this.physicsMark = mark1;
		this.chemistryMark = mark2;
		this.mathsMark = mark3;
	}
}


public class Result extends Exam{
	int totalMarks;
	Result(String name, String rollNo, int mark1, int mark2, int mark3){
		super(name, rollNo, mark1, mark2, mark3);
	}
	
	public void calculateTotal(){
		this.totalMarks = this.chemistryMark + this.physicsMark + this.mathsMark;
	}
	
	public static void main(String[] args) {
		Result obj = new Result("Bharani", "1233", 10 , 10, 10);
		obj.calculateTotal();
		System.out.println(obj.totalMarks);
	}
}