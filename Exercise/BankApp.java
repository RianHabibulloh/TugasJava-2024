package Exercise;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        AccountList accountList = new AccountList();  
        accountList.addAccount("Rian", "123");

        String accountName = "";
        String pin = "";
        boolean isRunning = false;

        while (!isRunning) {
            System.out.println("Welcome to the bank!");
            System.out.print("Enter account name: ");
            accountName = input.nextLine();
            
            System.out.print("Enter pin: ");
            pin = input.nextLine();

            if (accountList.validateAccount(accountName, pin)) {
                isRunning = true;
            } else {
                System.out.println("Invalid account name or pin. Please try again.");
            }
        }

        while (isRunning) {
            SavingsAccount savingsAccount = new SavingsAccount(accountName, 0);
            CheckingAccount checkingAccount = new CheckingAccount(accountName, 0, 1000);

            int accountType = 0;
            boolean isAccountTypeSelected = false;
            while (!isAccountTypeSelected) {
                System.out.print("Select account type (1.savings or 2.checking): ");
                accountType = input.nextInt();
                if (accountType == 1 || accountType == 2) {
                    isAccountTypeSelected = true;
                } else {
                    System.err.println("Invalid account type. Please try again.");
                }
            }

            boolean exit = false;

            while (!exit && isAccountTypeSelected) {
                System.out.println("\nMenu");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check balance");
                System.out.println("4. Exit");
            
                System.out.print("Enter your choice (1-4): ");
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        boolean isDepositValid = true;
                        while (isDepositValid) {
                            System.out.print("Enter money to deposit: ");
                            double money = input.nextDouble();
                            if (money >= 200) {
                                if (accountType == 1) {
                                    savingsAccount.setDeposit(money);
                                } else if (accountType == 2) {
                                    checkingAccount.setDeposit(money);
                                }
                                isDepositValid = false;
                            } else {
                                System.out.println("Minimum deposit is $200. Please try again.");
                            }
                        }
                        break;
                    case 2:
                        boolean isWithdrawValid = true;
                        while (isWithdrawValid) {
                            System.out.print("Enter money to withdraw: ");
                            double money = input.nextDouble();
                            if (money % 100 == 0 && money >= 100) {
                                if (accountType == 1) {
                                    savingsAccount.setWithdraw(money);
                                } else if (accountType == 2) {
                                    checkingAccount.setWithdraw(money);
                                  }
                                  isWithdrawValid = false;
                            } else {
                                System.out.println("Minimum withdraw amount is wrong. Please try again.");
                            }
                        }
                        break;
                    case 3:
                        if (accountType == 1) {
                            System.out.println("Your savings account balance is " + savingsAccount.getBalance());
                        } else if (accountType == 2) {
                            System.out.println("Your checking account balance is " + checkingAccount.getBalance());
                        }
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
