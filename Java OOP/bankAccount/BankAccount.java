package bankAccount;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public BankAccount() {
        numberOfAccounts++;
    }

    // setters:
}