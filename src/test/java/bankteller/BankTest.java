package bankteller;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.Collection;

public class BankTest {

	Bank underTest;
	BankAccount account1;
	BankAccount account2;

	@Before
	public void setUp() {
		underTest = new Bank();
		account1 = new BankAccount("1", "Checking", 100);
		account2 = new BankAccount("2", "Savings", 100);
	}

	@Test
	public void shouldBeAbleToAddAccount() {
		underTest.add(account1);
		BankAccount retrievedAccount = underTest.findAccount("1");
		assertThat(retrievedAccount, is(account1));
	}

	@Test
	public void shouldBeAbleToAddTwoAccounts() {
		underTest.add(account1);
		underTest.add(account2);
		Collection<BankAccount> allAccounts = underTest.getAllAccounts();
		assertThat(allAccounts, contains(account1, account2));
		assertThat(allAccounts, containsInAnyOrder(account2, account1));// Order doesn't matter. More flexible.
		assertEquals(2, allAccounts.size());

	}

	@Test
	public void shouldBeAbleToCloseAnAccount() {
		underTest.add(account1);
		underTest.closeAccount(account1);
		BankAccount retrievedAccount = underTest.findAccount(account1.getAccountNumber());
		assertThat(retrievedAccount, is(nullValue()));
	}

	@Test
	public void shouldWithdrawFromAccount() {

		underTest.add(account1);
		underTest.withdraw(account1.getAccountNumber(), 50);
		assertThat(account1.getBalance(), is(50));

	}

	@Test
	public void shouldDepositIntoAccount() {

		underTest.add(account1);
		underTest.deposit(account1.getAccountNumber(), 50);
		assertThat(account1.getBalance(), is(150));

	}

	@Test
	public void shouldDepositIntoAccount2() {

		underTest.add(account2);
		underTest.deposit(account2.getAccountNumber(), 50);
		assertThat(account2.getBalance(), is(150));

	}
	@Test
	public void shouldBeAbleToShowAccount2Balance() {

		underTest.showBalance(account2);
		assertThat(account2.getBalance(), is(150));

	}	
	@Test
	public void shouldDepositToAllAccounts() {
		underTest.add(account1);
		underTest.add(account2);
		underTest.depositAll();
		assertThat(account1.getBalance(), is(110));
		assertThat(account2.getBalance(), is(110));
	}
}
