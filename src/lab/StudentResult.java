package lab;

import java.util.Scanner;

public class StudentResult {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of students");
		int studentsCount = scan.nextInt();
		int studentsMarks[][] = new int[studentsCount][3];
		for(int i = 0; i < studentsCount; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println("Enter Student "+ (i + 1) + " on subject  "+ (j + 1));
				studentsMarks[i][j] = scan.nextInt();
			}
		}
		
		for(int i = 0; i < studentsCount; i++) {
			double avg = AverageOfN.averageOf(studentsMarks[i]);
			System.out.println("Total mark of Student " + (i+1) + " is " + (int)(avg * 3) + "/300 and average is " + avg);
		}
	}
}
