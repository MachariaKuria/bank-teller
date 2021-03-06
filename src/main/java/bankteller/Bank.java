package bankteller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Bank {

	Map<String, BankAccount> accounts = new HashMap<>();

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

	public String showAllAccounts() {
		
		for (Entry<String, BankAccount> entry : accounts.entrySet()) {
			System.out.print("\n(" + entry.getKey() + ")"); 
			System.out.print(" " + entry.getValue().getAccountType());
			System.out.print(" " + entry.getValue().getBalance());
		}
		return " ";
	}

	public void depositAll() {
		for (BankAccount account : accounts.values()) {
			account.depositAll();
		}
	}

	public void showBalance(BankAccount account) {
		 account.getBalance();
		
	}

}
