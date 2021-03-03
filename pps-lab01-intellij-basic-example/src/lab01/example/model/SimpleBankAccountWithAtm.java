package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * It applies a fee on deposit and withdraw.
 */
public class SimpleBankAccountWithAtm extends AbstractBankAccount {
    private static final double ATM_FEE = 1.0;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    protected double applyFee(double amount) {
        return amount - ATM_FEE;
    }
}
