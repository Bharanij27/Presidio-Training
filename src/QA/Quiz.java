package QA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface QA{
	
	public void showQuestions(Map<Integer, Question> questions, int questionCount, Map<Integer, Integer> answers);
	public int getQuestionNumber(int bound, int[] questionsAsked);
	public void showques(Question question, Map<Integer, Integer> answers);
	public void verifyAnswer(Map<Integer, Question> questions, Map<Integer, Integer> answers);
}

public class Quiz {
	public static void main(String[] args) {
		QuestionAnswer p = new QuestionAnswer();
		Map<Integer, Question> questions = new HashMap<Integer, Question>();
		Map<Integer, Integer> answers = new HashMap<Integer, Integer>();
		int questionCount = 0;
		p.createQuestions(questions);
		
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter number questions you want to attend...?");
			questionCount = scanner.nextInt();
			System.out.println("You have " + questionCount * 10 + " secs to answer all questions");
			makeTimer(questionCount);
			p.showQuestions(questions, questionCount, answers);
			p.verifyAnswer(questions, answers);
			System.exit(0);
		}	
	}
	
	public static void makeTimer(int qCount){
		
		ExecutorService service = Executors.newFixedThreadPool(1);
		service.execute(() ->{
			try {
				Thread.sleep(qCount * 10 * 1000);
				System.out.println("TimeOut......");
				System.exit(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}

class QuestionAnswer implements QA{

	@Override
	public void showQuestions(Map<Integer, Question> questions, int questionCount, Map<Integer, Integer> answers) {
		int count = 0;
		int[] questionsAsked = new int[questionCount];
		while(count < questionCount) {
			int quesNum = getQuestionNumber(questions.size(), questionsAsked);
			showques(questions.get(quesNum), answers);
			count++;
		}
	}
	
	@Override
	public void showques(Question question, Map<Integer, Integer> answers) {
		System.out.println(question.question);
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < question.options.length; i++) {
			System.out.println(i + 1 + ") " + question.options[i]);
		}
		System.out.println("Enter your option : ");
		int ans = scan.nextInt();
		answers.put(question.id, ans);
		//getAnswer();
	}
	
	@Override
	public void verifyAnswer(Map<Integer, Question> questions, Map<Integer, Integer> answers) {
		int correctAnswer = 0;
		for (Map.Entry<Integer, Integer> entry : answers.entrySet()) {
			Question quest = questions.get(entry.getKey());
			if(quest.rightAnswer.equals(quest.options[entry.getValue() - 1])) {
				correctAnswer++;
			}
		}
		System.out.println("You have answered " + correctAnswer + " questions correctly out of " + answers.size() + " questions");
	}
	
	@Override
	public int getQuestionNumber(int bound, int[] questionsAsked) {
		Random rand = new Random();
		int quesNum = 0;
		while(true) {
			quesNum = rand.nextInt(bound);
			if(!Arrays.asList(questionsAsked).contains(quesNum)) break;
		}
		return quesNum;
	}
	
	public void createQuestions(Map<Integer, Question> questions) {
		for(int  i = 0; i < 10; i++) {
			questions.put(i, new Question(i, "What is  " + i + " + 10 ?", new String[]{"10", "20", "30", "" + (i + 10)} , "" + (i + 10)));			
		}
	}
}

class Question{
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