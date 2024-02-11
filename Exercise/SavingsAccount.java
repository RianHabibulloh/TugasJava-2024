package Exercise;

public class SavingsAccount extends BankAccount {
    private double minimumBalance;

    public SavingsAccount(String accountName, double balance) {
        super(accountName, balance);
        this.minimumBalance = balance;
    }

    @Override
    public void setWithdraw(double money) {
        if (balance - money >= minimumBalance) {
            super.setWithdraw(money);
            System.out.println("Withdraw is success");
            System.out.println("Your balance is now " + getBalance());
        } else {
            System.out.println("Insufficient funds");
            System.exit(0); 
        }
    }
}
