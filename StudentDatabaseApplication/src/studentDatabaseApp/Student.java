package studentDatabaseApp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses=null;
	private int tuitionBalance=0;
	private static int costOfCourse =600;
	private static int id=1000;
	//Constructor : prompt user to enter Student's name and the year
	public Student() {
		Scanner in= new Scanner(System.in);
		System.out.println("Enter student first name:");
		this.firstName=in.nextLine();

		System.out.println("Enter student last name:");
		this.lastName=in.nextLine();

		System.out.println("1 - Freshmen\n2 - Junior\n3 - Senior\nEnter student class level:");
		this.gradeYear=in.nextInt();

		setStudentID();

		//System.out.println(firstName+" "+lastName+" "+gradeYear+" "+studentID);

	}

	//Generate the ID
	private void setStudentID() {
		//Grade Level +ID
		id++;
		this.studentID= gradeYear +""+id;
	}

	//Enroll in courses 
	public void enroll() {
		//Get inside a loop,user hits 0	
		do {
			System.out.println("Enter course to enroll (Q to quit): ");
			Scanner in =new Scanner(System.in);
			String course=in.nextLine();
			if(!course.equals("Q")) {
				courses= courses + "\n  " + course;
				tuitionBalance = tuitionBalance+costOfCourse;
			}
			else {
				break;}
		}while(1!=0);

		//System.out.println("ENROLLED IN: " + courses );
		//System.out.println("TUITUION BALANCE: " + tuitionBalance);
	}
	//View balance 
	public void viewBalance() {
		System.out.println("Your Balance is : "+tuitionBalance + " "+"rs");
	}
	// Pay Tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment:");
		Scanner in = new Scanner(System.in);
		int payment=in.nextInt();

		tuitionBalance=tuitionBalance-payment;
		System.out.println("Thank you for your payment of " + payment +" "+"rs");
		viewBalance();
	}

	//Show status
	public String toString() {
		return "Name: "+ firstName + " "+lastName +
				"\nGrade Level:" + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled:" +courses +
				"\nBalance is:" +tuitionBalance + " "+"rs";

	}

}
