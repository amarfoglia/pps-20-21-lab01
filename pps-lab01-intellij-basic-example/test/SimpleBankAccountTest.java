import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBankAccountTest {

    @Override
    protected BankAccount generateBankAccount() {
        return new SimpleBankAccount(getAccountHolder(), AbstractBankAccountTest.INITIAL_DEPOSIT);
    }

    @Override
    protected double getFee() {
        return 0;
    }

    @Test
    void testDeposit() {
        getBankAccount().deposit(getAccountHolder().getId(), AMOUNT_TO_DEPOSIT);
        assertEquals(AMOUNT_TO_DEPOSIT, getBankAccount().getBalance());
    }

    @Test
    void testWithdraw() {
        getBankAccount().deposit(getAccountHolder().getId(), AMOUNT_TO_DEPOSIT);
        getBankAccount().withdraw(getAccountHolder().getId(), AMOUNT_TO_WITHDRAW);
        assertEquals(AMOUNT_TO_DEPOSIT - AMOUNT_TO_WITHDRAW, getBankAccount().getBalance());
    }
}
