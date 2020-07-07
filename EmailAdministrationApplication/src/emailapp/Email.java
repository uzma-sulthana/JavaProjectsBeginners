package emailapp;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int defaultPasswordLength=10;
	private String email;
	private int mailboxCapacity=500;
	private String alternateEmail;
	private String companySuffix="anycompany.com";
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("EMAIL CREATED: "+this.firstName+" "+this.lastName);

		//Call a method asking for the department  - return the department
		this.department = setDepartment();
		//System.out.println("Department:"+this.department);

		//Call a method that return a random password
		this.password=randomPassword(defaultPasswordLength);
		System.out.println("Your password is: "+this.password);

		// Combine elements to generate email
		email= firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department +"."+companySuffix;
		//System.out.println("Your Email is :" +email);
	}

	// Ask for the department
	private String setDepartment() {

		System.out.println("New worker:" + firstName+".Department Codes:\n1 for Sales \n2 for Development \n3 for Accounting \n0 for none \nEnter the department code:");
		Scanner input=new Scanner(System.in);
		int depChoice=input.nextInt();
		switch(depChoice) {
		case 1: return "scales";
		case 2: return "dev";
		case 3: return "acct";
		default : return "";
		}

	}

	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int rand=(int)(Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}

	//set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}

	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail=altEmail;
	}

	//change the password
	public void changePassword(String password) {
		this.password=password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}
	public String showInfo() {
		return "DISPLAY NAME:" +firstName + " " + lastName +
				"\nCOMPANY EMAIL:" + email +
				"\nMAILBOX CAPACITY:"+ mailboxCapacity+"mb";
	}
}
