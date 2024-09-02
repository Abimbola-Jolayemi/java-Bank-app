package bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankTest {

    Bank bank = new Bank();

    @Test
    public void testCreateAccount_NumberOfAccountIsOne() {
        Account createAccount = bank.createAccount("Abimbola", "Jolayemi", "1234");
        assertEquals(1, bank.countAccount());
    }

    @Test
    public void testCreateTwoAccount_NumberOfAccountIsTwo() {
        Account account1 = bank.createAccount("Abimbola", "Jolayemi", "1111");
        Account account2 = bank.createAccount("Abimbola", "Jolayemi", "1222");
        assertEquals(2, bank.countAccount());
    }

    @Test
    public void testThatBankCanDeposit(){
        Account account1 = bank.createAccount("Abimbola", "Jolayemi", "1111");
        bank.deposit(5000, "10000001");
        assertEquals(5000, account1.getBalance("1111"));
    }

    @Test
    public void testThatBankCanWithdraw(){
        Account account = bank.createAccount("Abimbola", "Jolayemi", "1111");
        bank.deposit(10000, "10000001");
        assertEquals(10000, account.getBalance("1111"));
        bank.withdraw(5000, "10000001", "1111");
        assertEquals(5000, account.getBalance("1111"));
    }

    @Test
    public void testThatBankCanTransfer(){
        Account account1 = bank.createAccount("Abimbola", "Jolayemi", "1111");
        Account account2 = bank.createAccount("Bimbola", "Jolayemi", "0000");
        bank.deposit(10000, "10000001");
        bank.transfer("10000001", "10000002", 5000, "1111");
        assertEquals(5000, account1.getBalance("1111"));
        assertEquals(5000, account2.getBalance("0000"));
    }

    @Test
    public void testThatBankCanCheckBalance(){
        Account account1 = bank.createAccount("Abimbola", "Jolayemi", "1111");
        bank.deposit(10000, "10000001");
        assertEquals(10000, bank.getBalance("10000001", "1111"));
    }

    @Test
    public void testThatBankCannotGetBalanceOfInexistingAccount(){
        Account account1 = bank.createAccount("Abimbola", "Jolayemi", "1111");
        bank.deposit(10000, "10000001");
        assertEquals(10000, bank.getBalance("10000001", "1111"));
        assertEquals(0, bank.getBalance("10000009", "0000"));
    }

    @Test
    public void testThatBankCanAssignAccountNumbers(){
        Account account1 = bank.createAccount("Abimbola", "Jolayemi", "1111");
        Account account2 = bank.createAccount("Abimbola", "Jolayemi", "1111");
        assertEquals("10000001", account1.getNumber());
        assertEquals("10000002", account2.getNumber());
    }
}
