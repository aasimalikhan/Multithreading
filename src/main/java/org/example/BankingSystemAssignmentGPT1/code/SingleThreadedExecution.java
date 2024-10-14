package org.example.BankingSystemAssignmentGPT1.code;

public class SingleThreadedExecution {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();
        BankAccount bankAccount2 = new BankAccount();
        bankAccount1.deposit(10000);
        bankAccount1.deposit(20000);
        bankAccount1.deposit(30000);

        bankAccount2.deposit(10000);

        bankAccount1.transfer(bankAccount2, 10000);

        System.out.println(bankAccount1.getAccountNumber());
        System.out.println(bankAccount1.getBalance());
        System.out.println(bankAccount2.getAccountNumber());
        System.out.println(bankAccount2.getBalance());
    }
}
