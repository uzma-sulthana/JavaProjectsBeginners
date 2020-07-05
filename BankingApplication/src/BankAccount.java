import java.util.Scanner;

class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	BankAccount(String cname,String cid){
		customerName=cname;
		customerId=cid;
	}
		
	
	void deposit(int amount) {
		if(amount>0) {
			balance+=amount;
			previousTransaction=amount;
		}
		
		}
	void winthdraw(int amount) {
	 balance-=amount;
	 previousTransaction =-amount;
	}
	void getPreviousTransaction() {
		if(previousTransaction>0) {
			System.out.println("Deposited:"+previousTransaction);
		}
		else if (previousTransaction<0) {
			System.out.println("Withdrawn:"+Math.abs(previousTransaction));
		}
		else {
			System.out.println("No transaction occured");
		}
	}
	void showMenu() {
		int option;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome "+customerName);
		System.out.println("Your ID is :" +customerId);
		System.out.println("\n");
		System.out.println("1 Check Balance");
		System.out.println("2 Deposit");
		System.out.println("3 Withdraw");
		System.out.println("4Previous Transaction");
		System.out.println("5 Exit");
		do {
		System.out.println("***********************************************************************");
		System.out.println("Enter an option");
		System.out.println("***********************************************************************");
		option=scanner.nextInt();
		System.out.println("\n");
		switch(option) {
		case 1:
			System.out.println("************************************");
			System.out.println("Balance ="+balance);
			System.out.println("************************************");
			System.out.println("\n");
			break;
			
		case 2:
			System.out.println("************************************");
			System.out.println("Enter an amount to deposit");
			System.out.println("************************************");
			int amount=scanner.nextInt();
			deposit(amount);
			System.out.println("\n");
			break;
			
		case 3:
			System.out.println("************************************");
			System.out.println("Enter an amount to witdraw");
			int amount2=scanner.nextInt();
			winthdraw(amount2);
			System.out.println("\n");
			break;
			
		case 4:
			System.out.println("************************************");
			getPreviousTransaction();
			System.out.println("************************************");
			System.out.println("\n");
			break;
			
		case 5:
			System.out.println("Thank you for using our services");
			System.exit(0);
			
			
		default:
			System.out.println("Invalid option !.Please enter again");
			break;
				
		}		
		}while(option!=0);
		
	}
		
}

