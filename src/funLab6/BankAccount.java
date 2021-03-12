package funLab6;

import funLab6.Bank;

public class BankAccount {
	public static void main(String[] args) {
		Bank[] obj = new Bank[5];
		obj[0] = new Bank("Bharani", "A12757", "Savings");
		obj[0].accountDetails();
	}
}
