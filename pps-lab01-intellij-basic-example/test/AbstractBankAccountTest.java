import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {
    protected static final int USER_ID = 1;
    protected static final double AMOUNT_TO_DEPOSIT  = 100;
    protected static final double AMOUNT_TO_WITHDRAW = 70;
    protected static final double INITIAL_DEPOSIT = 0;
    private static final int WRONG_USER_ID = 2;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", USER_ID);
        bankAccount   = generateBankAccount();
    }

    protected abstract BankAccount generateBankAccount();

    protected abstract double getFee();

    protected double computeAmountToWithdraw(double amount) {
        return amount + getFee();
    }

    protected double computeAmountToDeposit(double amount) {
        return amount - getFee();
    }

    protected BankAccount getBankAccount() {
        return bankAccount;
    }

    protected AccountHolder getAccountHolder() {
        return accountHolder;
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, getBankAccount().getBalance());
    }

    @Test
    void testWrongDeposit() {
        getBankAccount().deposit(getAccountHolder().getId(), AMOUNT_TO_DEPOSIT);
        getBankAccount().deposit(WRONG_USER_ID, AMOUNT_TO_DEPOSIT);
        assertEquals(computeAmountToDeposit(AMOUNT_TO_DEPOSIT), getBankAccount().getBalance());
    }

    @Test
    void testWrongWithdraw() {
        getBankAccount().deposit(getAccountHolder().getId(), AMOUNT_TO_DEPOSIT);
        getBankAccount().withdraw(WRONG_USER_ID, AMOUNT_TO_WITHDRAW);
        assertEquals(computeAmountToDeposit(AMOUNT_TO_DEPOSIT), getBankAccount().getBalance());
    }
}
