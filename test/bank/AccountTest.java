package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("Abimbola Jolayemi", "pin", "accountNumber");
    }

    @Test
    public void newAccount_balanceIsZeroTest(){
        account = new Account("Abimbola Jolayemi", "pin","accountNumber");
        assertEquals(0, account.getBalance("pin"));
    }
    @Test
    public void newAccount_depositPositiveAmountTest(){
        account = new Account("Abimbola Jolayemi", "pin","accountNumber");
        assertEquals(0, account.getBalance("pin"));
    }

    @Test
    public void newAccount_depositNegativeAmountTest(){
        account = new Account("Abimbola Jolayemi", "pin", "accountNumber");
        account.deposit(-1000);
        assertEquals(0, account.getBalance("pin"));
    }

    @Test
    public void newAccount_withdrawPositiveAmountTest(){
        account = new Account("Abimbola Jolayemi", "pin", "accountNumber");
        account.deposit(10_000);
        assertEquals(10_000, account.getBalance("pin"));
        account.withdraw(2000, "pin");
        assertEquals(8000, account.getBalance("pin"));
    }

    @Test
    public void newAccount_withdrawNegativeAmountTest(){
        account = new Account("Abimbola Jolayemi", "pin", "accountNumber");
        account.deposit(10_000);
        assertEquals(10_000, account.getBalance("pin"));
        account.withdraw(-2000, "pin");
        assertEquals(10_000, account.getBalance("pin"));
    }

    @Test
    public void account_updatePinTest(){
        account.deposit(2_000);
        assertEquals(2_000, account.getBalance("pin"));
        account.updatePin("pin", "newPin");
        assertEquals(2_000, account.getBalance("newPin"));
        assertEquals(0, account.getBalance("pin") );
    }

    @Test
    public void testThatGetAccountNameExists(){
        account = new Account("Abimbola Jolayemi", "pin", "accountNumber");
        assertEquals("Abimbola Jolayemi", account.getName());
    }
}
