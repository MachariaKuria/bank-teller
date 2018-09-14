package bankteller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Bank account = new Bank();
		BankAccount checking = new BankAccount("1111", "Checking", 500);
		BankAccount savings = new BankAccount("2222", "Savings", 100);
		String userChoice;

		System.out.println("Here are your accounts at our bank:");
		System.out.println("(" + checking.getAccountNumber() + ") " + checking.getAccountType() + " "
				+ (double) checking.getBalance() + "\n(" + savings.getAccountNumber() + ") " + savings.getAccountType()
				+ " " + (double) savings.getBalance());
		System.out.println();
		System.out.println("What would you like to do next?");

		System.out.println("Press 1 to deposit");
		System.out.println("Press 2 to withdraw");
		System.out.println("Press 3 to check balance");
		System.out.println("Press 4 to close an account");
		System.out.println("Press 0 to exit");

		userChoice = input.nextLine();

		do {

			if (userChoice.equals("1")) {

				System.out.println("You want to deposit.");
				System.out.println();
				System.out.println("Here are your accounts at our bank:");
				System.out.println("(" + checking.getAccountNumber() + ") " + checking.getAccountType() + " "
						+ (double) checking.getBalance() + "\n(" + savings.getAccountNumber() + ") "
						+ savings.getAccountType() + " " + (double) savings.getBalance());
				System.out.println();
				System.out.println("Type the account number to choose an account to deposit to.");
				System.out.println();
				userChoice = input.nextLine();
				
				if(checking.getAccountNumber().contains(userChoice)) {
					System.out.println("You have selected " + checking.getAccountNumber());
				}else {
					System.out.println("You have selected " + savings.getAccountNumber());
				}
				System.out.println("Enter the amount to deposit");
				userChoice = input.nextLine();
				int amount = Integer.parseInt(userChoice);
				
				account.deposit(checking.getAccountNumber(), amount);
				System.out.println("(" + checking.getAccountNumber() + ") " + checking.getAccountType() + " "
						+ (double) checking.getBalance());
			}

		} while (userChoice.equals("0"));

	}

}
