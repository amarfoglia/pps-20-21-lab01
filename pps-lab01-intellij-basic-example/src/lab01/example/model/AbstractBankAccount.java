package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {
    private final AccountHolder holder;
    private double balance;

    public AbstractBankAccount(final AccountHolder holder, final double balance) {
        this.balance = balance;
        this.holder = holder;
    }

    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += applyFee(amount);
        }
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance -= applyFee(amount);
        }
    }

    /**
     * @param amount on which applying fee
     * @return the reduced amount
     */
    protected abstract double applyFee(final double amount);

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
