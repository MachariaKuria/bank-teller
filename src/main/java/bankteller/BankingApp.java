package bankteller;

import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Bank myBank = new Bank();

		myBank.add(new BankAccount("1111", "Checking", 500));
		myBank.add(new BankAccount("2222", "Savings", 100));

		String userChoice = null;
		System.out.println(myBank.showAllAccounts());
		System.out.println();
		System.out.println("What would you like to do next?");
		System.out.println("Press 1 to deposit \nPress 2 to withdraw \nPress 3 to check balance \nPress 4 to close an account \nPress 0 to exit");
	
		do {
			try {
				userChoice = input.nextLine();

				if (userChoice.equals("1")) {
					System.out.println("Which account would you like to deposit");
					String accountToDeposit = input.nextLine();
					myBank.findAccount(accountToDeposit);
					System.out.println("Enter the amount to deposit");
					int amountToDeposit = input.nextInt();
					myBank.deposit(accountToDeposit, amountToDeposit);
					System.out.println(myBank.showAllAccounts());
					input.nextLine();
				} else if (userChoice.equals("2")) {
					System.out.println("Which account would you like to withdraw");
					String accountToWithdraw = input.nextLine();
					myBank.findAccount(accountToWithdraw);
					System.out.println("Enter the amount to withdraw");
					int amountToDeposit = input.nextInt();
					myBank.withdraw(accountToWithdraw, amountToDeposit);
					System.out.println(myBank.showAllAccounts());
					input.nextLine();
				} else if (userChoice.equals("3")) {
					System.out.println("Which account would you like to check balance?");
					String accountToCheckBal = input.nextLine();
					System.out.print("Your " + myBank.findAccount(accountToCheckBal).getAccountType()
							+ " account balance is $" + myBank.findAccount(accountToCheckBal).getBalance());
					
				} else if (userChoice.equals("4")) {
					System.out.println("Which account would you like to close?");
					String accountToClose = input.nextLine();
					myBank.closeAccount(myBank.findAccount(accountToClose));
					System.out.println(myBank.showAllAccounts());
					System.out.println();
				}

			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			System.out.println("What would you like to do next?");
			System.out.println("Press 1 to deposit \nPress 2 to withdraw \nPress 3 to check balance \nPress 4 to close an account \nPress 0 to exit");
			userChoice = input.nextLine();
		} while (!userChoice.equals("0"));
		System.out.println("Thanks for banking with us. Goodbye!..");
		System.exit(0);
		input.close();
	}

}
