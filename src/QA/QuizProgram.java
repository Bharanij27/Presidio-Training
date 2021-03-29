package QA;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public interface QuizProgram extends Remote{
	
	public String verifyAnswer(Map<Integer, Integer> answers, Map<Integer, Question> ques, int qcount) throws RemoteException;
	public Map<Integer, Question> createQuestions() throws RemoteException;
	public Map<Integer, Question> start(int qCount) throws RemoteException;
}
