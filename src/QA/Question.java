package QA;

import java.io.Serializable;

public class Question implements Serializable{
	int id;
	String question;
	String[] options;
	String rightAnswer;
		
	public Question(int id, String ques, String[] opts, String rightAnswer) {
		this.id = id;
		this.question = ques;
		this.options = opts;
		this.rightAnswer = rightAnswer;
	}
}