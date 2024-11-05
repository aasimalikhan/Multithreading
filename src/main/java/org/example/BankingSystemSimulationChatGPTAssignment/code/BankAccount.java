package org.example.BankingSystemSimulationChatGPTAssignment.code;

import org.example.BankingSystemSimulationChatGPTAssignment.code.exception.InsufficientBalanceException;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount()
    {
        this.accountId = RandomNumberStringGenerator.generateRandomNumberString(10);
        this.balance = 0;
    }

    public boolean deposit(double amount)
    {
        if(amount >= 0)
        {
            synchronized (this) {
                this.balance += amount;
            }
            return true;
        }
        return false;
    }
    public boolean withdraw(double amount)
    {
        if(this.balance - amount >= 0)
        {
            synchronized (this)
            {
                this.balance -= amount;
            }
            return true;
        }
        throw new InsufficientBalanceException();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public boolean transferTo(BankAccount target, double amount)
    {
        if(this.balance - amount >= 0)
        {
            synchronized (this) {
                this.balance -= amount;
                synchronized (target) {
                    target.balance += amount;
                }
            }
            return true;
        }
        throw new InsufficientBalanceException();
    }

    public boolean longRunningTransfer(BankAccount target, double amount) throws InterruptedException {
        Thread.sleep(2000);
        return true;
    }

}
