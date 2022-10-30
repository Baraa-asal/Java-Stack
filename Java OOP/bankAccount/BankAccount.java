package bankAccount;

import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;
    private static int numberOfAccounts = 0;
    private static double totalAmountOfMoney = 0.0;

    public BankAccount() {
        this.checkingBalance = 0.0;
        this.savingsBalance = 0.0;
        BankAccount.totalAmountOfMoney++;
    }

    public BankAccount(double checkingBalance, double savingsBalance) {
        numberOfAccounts++;
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.accountNumber = this.generateAccountNumber();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public static double getTotalAmountOfMoney() {
        return totalAmountOfMoney;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void deposit(double amount, String balanceType) {
        if (balanceType.equals("checkingBalance")) {
            this.checkingBalance += amount;
        } else {
            this.savingsBalance += amount;
        }
        totalAmountOfMoney += amount;
    }

    public void withdraw(double amount, String balanceType) {
        if (balanceType.equals("checkingBalance")) {
            if (amount <= checkingBalance) {
                this.checkingBalance -= amount;
            }
        } else {
            if (amount <= savingsBalance) {
                this.savingsBalance -= amount;
            }
        }
        totalAmountOfMoney -= amount;
    }

    public static void displayTotalAmountOfMoney() {
        System.out.println(getTotalAmountOfMoney());
    }

    private String generateAccountNumber() {
        String accountNumber = new String();
        Random randomNumber = new Random();
        for (int i = 0; i < 10; i++) {
            accountNumber += randomNumber.nextInt(10);
        }
        return accountNumber;
    }
}