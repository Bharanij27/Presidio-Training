package QA;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class QuestionAnswer extends UnicastRemoteObject implements QuizProgram{
	int questionCount;
	boolean canQuit = false;
	Map<Integer, Question> questions = new HashMap<Integer, Question>();
	Map<Integer, Integer> answers = new HashMap<Integer, Integer>();
	
//	public QuestionAnswer(int qCount) throws RemoteException{
//		this.questionCount = qCount;
//		System.out.println("You have " + qCount * 10 + " secs to answer all questions");
//		createQuestions();
//		makeTimer(questionCount);
//		showQuestions(questionCount);
//		verifyAnswer(questionCount);
//	}
	
	public QuestionAnswer() throws RemoteException {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Map<Integer, Question> start(int qCount){
		this.questionCount = qCount;
		this.questions = createQuestions();
		canQuit = false;
		return this.questions;
	}
	


	@Override
	public String verifyAnswer(Map<Integer, Integer> answers, Map<Integer, Question> ques, int qCount) {
		if(canQuit) return "";
		
		int correctAnswer = 0;
		for (Map.Entry<Integer, Integer> entry : answers.entrySet()) {
			Question quest = ques.get(entry.getKey());
			if(quest.rightAnswer.equals(quest.options[entry.getValue() - 1])) {
				correctAnswer++;
			}
		}
		canQuit = true;
		return "You have answered " + correctAnswer + " questions correctly out of " + qCount + " questions";
	}
	
	@Override
	public Map<Integer, Question> createQuestions() {
		Map<Integer, Question> ques = new HashMap<Integer, Question>();
		for(int  i = 0; i < 10; i++) {
			ques.put(i, new Question(i, "What is  " + i + " + 10 ?", new String[]{"10", "20", "30", "" + (i + 10)} , "" + (i + 10)));			
		}
		return ques;
	}
	
	public static void main(String[] args)throws Exception {
		System.out.println("aa");

		QuestionAnswer rmiService = new QuestionAnswer();
		LocateRegistry.createRegistry(1099);		
		
		System.out.println("Server Ready....");
		Naming.bind("rmi://localhost:1099/rmiservice/quizService", rmiService);
	}
}