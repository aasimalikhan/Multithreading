package org.example.ReentrantLock.tryLock;

public class tryLock {
    public static void main(String[] args) throws InterruptedException {
        TryLockBankAccount account = new TryLockBankAccount();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(100);
                account.withdraw(50);
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(200);
                account.withdraw(150);
            }
        }, "Thread-2");

        t1.start();
//        t1.join();
        t2.start();
    }
}
