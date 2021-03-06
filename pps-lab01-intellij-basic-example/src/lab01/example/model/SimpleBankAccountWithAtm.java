package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * It applies a fee on deposit and withdraw.
 */
public class SimpleBankAccountWithAtm extends AbstractBankAccount {
    public static final double ATM_FEE = 1.0;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    protected double getFee() {
        return ATM_FEE;
    }

    @Override
    protected boolean isWithdrawAllowed(double amount) {
        return getBalance() > amount;
    }
}
