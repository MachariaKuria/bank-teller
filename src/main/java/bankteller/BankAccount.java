package bankteller;

public class BankAccount {

	private String accountNumber;
	private int balance;
	private String acctType;

	public BankAccount(String accountNumber, String acctType, int balance) {
		this.accountNumber = accountNumber;
		this.acctType = acctType;
		this.balance = balance;
	}

	public String getAccountNumber() {

		return accountNumber;
	}
	
	public String getAccountType() {
		return acctType;
	}

	public int getBalance() {

		return balance;
	}

	public void withdraw(int amount) {
		balance -= amount;

	}

	public void deposit(int amount) {
		balance += amount;

	}

}
