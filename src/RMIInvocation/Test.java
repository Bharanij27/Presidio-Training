package RMIInvocation;

import java.rmi.registry.LocateRegistry;

import Invoice.PackageDeliveryEstimation;
import QA.QuizProgram;
import excelLab.PdfConverter;

public class Test {
	public static void main(String[] args)throws Exception {
		Telco telco = new Telco();
		Object obj = Controller.getTelecomAppObject(telco);
		QuizProgram quiz = (QuizProgram)obj;
	
		System.out.println(quiz);
		PackageDeliveryEstimation packDelivery = (PackageDeliveryEstimation)obj;
		
		PdfConverter converter = (PdfConverter)obj;
		
	}
}
