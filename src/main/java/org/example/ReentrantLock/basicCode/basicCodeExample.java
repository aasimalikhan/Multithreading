package org.example.ReentrantLock.basicCode;

public class basicCodeExample {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 5; i++)
            {
                bankAccount1.deposit(100);
                bankAccount1.withdraw(50);
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 5; i++)
            {
                bankAccount1.deposit(200);
                bankAccount1.withdraw(150);
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
