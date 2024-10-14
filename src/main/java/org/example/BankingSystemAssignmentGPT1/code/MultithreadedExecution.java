package org.example.BankingSystemAssignmentGPT1.code;

public class MultithreadedExecution {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount1 = new BankAccount();
        BankAccount bankAccount2 = new BankAccount();
        bankAccount1.deposit(10000);
        bankAccount2.deposit(10000);
        Thread thread1 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++)
            {
                bankAccount1.withdraw(1);
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++)
            {
                bankAccount1.withdraw(1);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        //balance should be 20000
        System.out.println(bankAccount1.getBalance());
    }
}

