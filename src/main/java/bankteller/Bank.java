package bankteller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {

	Map<String, BankAccount> accounts = new HashMap<>();

	BankAccount checking = new BankAccount("1111", "Checking", 500);
	BankAccount savings = new BankAccount("2222", "Savings", 100);

	public void add(BankAccount account) {

		accounts.put(account.getAccountNumber(), account);

	}

	public BankAccount findAccount(String accountNumber) {

		return accounts.get(accountNumber);
	}

	public Collection<BankAccount> getAllAccounts() {

		return accounts.values();
	}

	public void closeAccount(BankAccount account) {

		accounts.remove(account.getAccountNumber(), account);

	}

	public void withdraw(String accountNumber, int amount) {

		BankAccount withdrawFromAccount = findAccount(accountNumber);
		withdrawFromAccount.withdraw(amount);
	}

	public void deposit(String accountNumber, int amount) {
		BankAccount depositIntoAccount = findAccount(accountNumber);
		depositIntoAccount.deposit(amount);

	}

	public void showDetails() {
		System.out.println("Here are your accounts at our bank:");
		System.out.println("(" + checking.getAccountNumber() + ") " + checking.getAccountType() + " "
				+ (double) checking.getBalance() + "\n(" + savings.getAccountNumber() + ") " + savings.getAccountType()
				+ " " + (double) savings.getBalance());
	}

}
