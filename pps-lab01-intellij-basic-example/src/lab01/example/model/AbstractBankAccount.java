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
        if (checkUser(usrID) && checkAmount(amount)) {
            balance += amount - getFee();
        }
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount) && checkAmount(amount)) {
            balance -= amount + getFee();
        }
    }

    protected abstract double getFee();

    protected abstract boolean isWithdrawAllowed(final double amount);

    private boolean checkAmount(final double amount) {
        return amount > 0;
    }

    private boolean checkUser(final int id) {
        return holder.getId() == id;
    }
}
