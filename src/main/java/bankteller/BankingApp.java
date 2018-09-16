package bankteller;

import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Bank account = new Bank();

		BankAccount checking = new BankAccount("1111", "Checking", 500);
		BankAccount savings = new BankAccount("2222", "Savings", 100);

		String userChoice;

		account.showDetails();

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
				account.showDetails();
				System.out.println();
				System.out.println("Type the account number to choose an account to deposit to.");
				System.out.println();
				userChoice = input.nextLine();

				if (checking.getAccountNumber().contains(userChoice)) {
					account.add(checking);
					System.out.println("You have selected " + checking.getAccountNumber());
					System.out.println("Enter the amount to deposit");
					userChoice = input.nextLine();
					int amountToDeposit = Integer.parseInt(userChoice);

					account.deposit(checking.getAccountNumber(), amountToDeposit);
					System.out.println("Your updated balance on account " + checking.getAccountNumber() + " is now "
							+ (double) checking.getBalance());
				} else if (savings.getAccountNumber().contains(userChoice)) {
					account.add(savings);
					System.out.println("You have selected " + savings.getAccountNumber());
					System.out.println("Enter the amount to deposit");
					userChoice = input.nextLine();
					int amountToDeposit = Integer.parseInt(userChoice);

					account.deposit(savings.getAccountNumber(), amountToDeposit);
					System.out.println("Your updated balance on account " + savings.getAccountNumber() + " is now "
							+ (double) savings.getBalance());
				}

			} else if (userChoice.equals("2")) {
				System.out.println("You want to withdraw.");
				System.out.println();
				account.showDetails();
				System.out.println();
				System.out.println("Type the account number to choose an account to withdraw from.");
				System.out.println();
				userChoice = input.nextLine();

				if (checking.getAccountNumber().contains(userChoice)) {
					account.add(checking);
					System.out.println("You have selected " + checking.getAccountNumber());
					System.out.println("Enter the amount to withdraw");
					userChoice = input.nextLine();
					int amountToWithdraw = Integer.parseInt(userChoice);

					account.withdraw(checking.getAccountNumber(), amountToWithdraw);
					System.out.println("Your updated balance on account " + checking.getAccountNumber() 
							+ " is now " + (double) checking.getBalance());
				} else if (savings.getAccountNumber().contains(userChoice)) {
					account.add(savings);
					System.out.println("You have selected " + savings.getAccountNumber());
					System.out.println("Enter the amount to Withdraw");
					userChoice = input.nextLine();
					int amountToWithdraw = Integer.parseInt(userChoice);

					account.withdraw(savings.getAccountNumber(), amountToWithdraw);
					System.out.println("Your updated balance on account " + savings.getAccountNumber() + " is now "
							+ (double) savings.getBalance());
				}
			} else if (userChoice.equals("3")) {
				System.out.println("Type the account number you want to view balance.");
				userChoice = input.nextLine();
				if (checking.getAccountNumber().contains(userChoice)) {
					System.out.println("The balance on account " + checking.getAccountNumber() + " is "
							+ (double) checking.getBalance());
				} else if (savings.getAccountNumber().contains(userChoice)) {
					System.out.println("The balance on account " + savings.getAccountNumber() + " is "
							+ (double) savings.getBalance());
				}
			} else if (userChoice.equals("4")) {
				System.out.println("You would like to close an account.");
				System.out.println();
				account.showDetails();
				System.out.println();
				System.out.println("Enter the account number of the account you would like to close:");
				userChoice = input.nextLine();
				
				if(checking.getAccountNumber().contains(userChoice)) {
					System.out.println("You are closing account # " + checking.getAccountNumber());
					account.findAccount(checking.getAccountNumber());
					account.closeAccount(checking);
					System.out.println();
					System.out.println("Here are the remaining accounts");
					account.showDetails();
				}
			}
			System.out.println("What would you like to do next?");
			System.out.println("Press 1 to deposit");
			System.out.println("Press 2 to withdraw");
			System.out.println("Press 3 to check balance");
			System.out.println("Press 4 to close an account");
			System.out.println("Press 0 to exit");
			userChoice = input.nextLine();
		} while (!userChoice.equals("0"));
		System.out.println("Thanks for banking with us. Goodbye!..");
			System.exit(0);
	}

}
