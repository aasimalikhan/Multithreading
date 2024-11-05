package org.example.ReentrantLock.basicCode;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public void deposit(int amount)
    {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + " Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }
    public void withdraw(int amount)
    {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrawn " + amount + " Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " insufficient balance for withdrawal");
            }
        } finally {
            lock.unlock();
        }
    }

    public int getBalance()
    {
        return balance;
    }
}
