package Exercise;
class BankAccount {
    private String accountName;
    private double withdraw;
    protected double balance;

    public BankAccount(String accountName, double balance){
        this.accountName = accountName;
        this.withdraw = 0;
        this.balance = balance;
        
    }
    
    public void setDeposit(double money) {
        balance += money;
    }

    public void setWithdraw(double money) {
        if (money <= balance) {
            balance -= withdraw;
            withdraw += money;
        } else {
            System.out.println("The balance is not sufficient");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public double getDeposit() {
        return balance + withdraw;
    }
}
