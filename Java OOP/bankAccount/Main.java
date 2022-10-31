package bankAccount;

public class Main {
    public static void main(String[] args) {

        BankAccount user = new BankAccount(0,0);

        user.deposit(1000, "checkingsBalance");
        user.deposit(1000, "savingsBalance");
        user.withdraw(500, "checkingsBalance");
        BankAccount.displayTotalAmountOfMoney();
        System.out.println(user.getCheckingBalance());
        System.out.println(user.getAccountNumber());
        System.out.println(user.getSavingsBalance());
    }
}



