package Exercise;

public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountName, double balance, double overdraftLimit) {
        super(accountName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void setWithdraw(double money) {
        if (money <= balance + overdraftLimit) {
            balance -= money;
            System.out.println("Withdraw is success");
            System.out.println("Your balance is now " + getBalance());
        } else {
            System.out.println("Insufficient funds");
            System.exit(0); 
        }
    }
}
