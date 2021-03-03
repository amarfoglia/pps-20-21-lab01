import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest {
    private static final int USER_ID = 1;
    private static final double NULL_AMOUNT = 0.0;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", USER_ID);
        bankAccount   = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testFeePaymentOnDeposit() {
        bankAccount.deposit(USER_ID, 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testFeePaymentOnWithdraw() {
        bankAccount.deposit(USER_ID, 100);
        bankAccount.withdraw(USER_ID, 8);
        assertEquals(90, bankAccount.getBalance());
    }

    @Test
    void testNullAmountOnDeposit() {
        bankAccount.deposit(USER_ID, NULL_AMOUNT);
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testNullAmountOnWithdraw() {
        bankAccount.withdraw(USER_ID, NULL_AMOUNT);
        assertEquals(0, bankAccount.getBalance());
    }
}
