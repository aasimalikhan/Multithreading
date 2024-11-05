package org.example.ReentrantLock.tryLock;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockBankAccount {
    private int balance = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void deposit(int amount)
    {
        if(lock.tryLock())
        {
//            System.out.println(Thread.currentThread().getName() + " acquried lock - deposit");
            try {
                balance += amount;
                System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", Balance: " + balance);
            } finally {
                lock.unlock();
            }
        } else
        {
            System.out.println(Thread.currentThread().getName() + " could not acquire lock for deposit");
        }
    }

    public void withdraw(int amount)
    {
        if(lock.tryLock())
        {
//            System.out.println(Thread.currentThread().getName() + " acquried lock - withdrawal");
            try {
                if(balance >= amount)
                {
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Balance: " + balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance for withdrawal.");
                }
            } finally {
                lock.unlock();
            }
        }
        else {
            System.out.println(Thread.currentThread().getName() + " could not acquire a lock for withdrawal");
        }
    }

}
