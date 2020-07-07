package studentDatabaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {

		//Ask how many users we need to add
		System.out.println("Enter number of new students to enroll: ");
		Scanner scanner=new Scanner(System.in);
		int numOfstudents=scanner.nextInt();
		Student[] students = new Student[numOfstudents];
		//Create n number of new students
		for(int i=0;i<numOfstudents;i++) {
			students[i]  =new Student();
			students[i].enroll();
			students[i].payTuition();

		}
		for(int i=0;i<numOfstudents;i++) {
			System.out.println(students[i].toString());
		}

	}

}
