package funLab6;

import java.util.Scanner;

public class Bank {
	String name;
	String accountNumber;
	String accountType;
	double balance;
	
	public Bank(String name, String accountNumber, String accountType) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = 0;
	}
	
	public void deposit() {
		int amount;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter amount you want to deposit");
		amount = scan.nextInt();
		this.balance += amount;
		System.out.println("Your balance is " + this.balance);
	}
	
	public void accountDetails(){
		System.out.println("Account Holder Name : " + this.name + " and his/her balance is " + this.balance);
		deposit();
	}
	
	public static void main(String[] args) {
		Bank newAccount = new Bank("Bharani", "A10986", "Saving");
		newAccount.accountDetails();
	}
}
