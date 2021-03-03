package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * It applies a fee on deposit and withdraw.
 */
public class SimpleBankAccountWithAtm extends AbstractBankAccount {
    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }
}
