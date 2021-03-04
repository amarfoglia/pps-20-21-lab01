import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest{
    private static final double NULL_AMOUNT = 0;
    private static final double EXCESS_AMOUNT = 99;

    @Override
    protected BankAccount generateBankAccount() {
        return new SimpleBankAccountWithAtm(getAccountHolder(), INITIAL_DEPOSIT);
    }

    @Override
    protected double getFee() {
        return SimpleBankAccountWithAtm.ATM_FEE;
    }

    @Test
    void testFeePaymentOnDeposit() {
        getBankAccount().deposit(USER_ID, AMOUNT_TO_DEPOSIT);
        assertEquals(computeAmountToDeposit(AMOUNT_TO_DEPOSIT), getBankAccount().getBalance());
    }

    @Test
    void testFeePaymentOnWithdraw() {
        getBankAccount().deposit(USER_ID, AMOUNT_TO_DEPOSIT);
        getBankAccount().withdraw(USER_ID, AMOUNT_TO_WITHDRAW);
        final double expectedBalance = computeAmountToDeposit(AMOUNT_TO_DEPOSIT) - computeAmountToWithdraw(AMOUNT_TO_WITHDRAW);
        assertEquals(expectedBalance, getBankAccount().getBalance());
    }

    @Test
    void testNullAmountOnDeposit() {
        getBankAccount().deposit(USER_ID, NULL_AMOUNT);
        assertEquals(INITIAL_DEPOSIT, getBankAccount().getBalance());
    }

    @Test
    void testNullAmountOnWithdraw() {
        getBankAccount().withdraw(USER_ID, NULL_AMOUNT);
        assertEquals(INITIAL_DEPOSIT, getBankAccount().getBalance());
    }

    @Test
    void testExcessWithdraw() {
        getBankAccount().deposit(USER_ID, AMOUNT_TO_DEPOSIT);
        getBankAccount().withdraw(USER_ID, EXCESS_AMOUNT);
        assertEquals(computeAmountToDeposit(AMOUNT_TO_DEPOSIT), getBankAccount().getBalance());
    }
}
