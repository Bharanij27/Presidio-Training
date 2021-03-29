package QA;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuizRmiClient {
	static Map<Integer, Question> questions = new HashMap<Integer, Question>();
	static Map<Integer, Integer> answers = new HashMap<Integer, Integer>();
	static QuizProgram quiz;
	static ExecutorService service = Executors.newFixedThreadPool(1);
	
	public static void main(String[] args) throws Exception{
	
		System.out.println(Naming.lookup("rmi://localhost:1099/rmiservice/quizService"));
		quiz = (QuizProgram)Naming.lookup("rmi://localhost:1099/rmiservice/quizService");
		
		System.out.println("Enter number of questions : ");
		Scanner scan = new Scanner(System.in);
		int maxQues = scan.nextInt();
		questions = quiz.start(maxQues);
		System.out.println("You have " + maxQues * 10 + " secs to answer all questions");
		startTimer(maxQues);
		showQuestions(maxQues);
		String res = quiz.verifyAnswer(answers, questions, maxQues);
		System.out.println(res);
		terminateThread();
		
	}
	
	
	public static void startTimer(int maxQues){
		service.execute(() ->{
			try {
				Thread.sleep(maxQues * 10 * 1000);
				String res =  quiz.verifyAnswer(answers, questions, maxQues);
				System.out.println("Time's Up!!.... \n" + res);
				terminateThread();
			} catch (InterruptedException e) {
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}


	private static void terminateThread() {
		if(!service.isShutdown()){
			service.shutdownNow();
			System.exit(0);
		}
	}


	public static void showQuestions(int questionCount) {
		int count = 0;
		int[] questionsAsked = new int[questionCount];
		while(count < questionCount) {
			int quesNum = getQuestionNumber(questions.size(), questionsAsked);
			showques(questions.get(quesNum));
			count++;
		}
	}
	
	public static int getQuestionNumber(int bound, int[] questionsAsked) {
		Random rand = new Random();
		int quesNum = 0;
		while(true) {
			quesNum = rand.nextInt(bound);
			if(!Arrays.asList(questionsAsked).contains(quesNum)) break;
		}
		return quesNum;
	}
	
	public static void showques(Question question) {
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
	
}
