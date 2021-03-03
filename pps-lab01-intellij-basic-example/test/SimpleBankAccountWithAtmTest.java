import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest {
    private static final int VALID_USER_ID = 1;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", VALID_USER_ID);
        bankAccount   = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testFeePaymentOnDeposit() {
        bankAccount.deposit(VALID_USER_ID, 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testFeePaymentOnWithdraw() {
        bankAccount.deposit(VALID_USER_ID, 100);
        bankAccount.withdraw(VALID_USER_ID, 8);
        assertEquals(90, bankAccount.getBalance());
    }
}
