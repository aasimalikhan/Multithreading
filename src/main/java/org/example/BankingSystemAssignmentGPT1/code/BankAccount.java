package org.example.BankingSystemAssignmentGPT1.code;

import org.example.BankingSystemAssignmentGPT1.code.exception.InsufficientBalanceException;

import java.util.Random;
import java.util.random.RandomGenerator;

public class BankAccount {
    public static String generateRandomNumberString()
    {
        String NUMBERS = "0123456789";
        StringBuilder sb = new StringBuilder(10);
        for(int i = 0; i < 10; i++)
        {
            int randomIndex = RandomGenerator.getDefault().nextInt(9);
            sb.append(NUMBERS.charAt(randomIndex));
        }
        return sb.toString();
    }
    private String accountNumber;
    private double balance;
    public BankAccount()
    {
        this.accountNumber = generateRandomNumberString();
        this.balance = 0.0;
    }
    public boolean deposit(double amount)
    {
        try {
            synchronized (this) {
                this.balance += amount;
                return true;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean withdraw(double amount)
    {
        try {

            if(this.balance - amount >= 0)
            {
                synchronized (this) {
                    this.balance -= amount;
                }
            }
            else
            {
                throw new InsufficientBalanceException("You dont have sufficient balance to withdraw");
            }
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean transfer(BankAccount targetAccount, double amount)
    {
        try {
            if(this.balance - amount >= 0)
            {
                synchronized (this) {
                    this.balance -= amount;
                    synchronized (targetAccount) {
                        targetAccount.balance += amount;
                    }
                }
            }
            else
            {
                throw new InsufficientBalanceException("You dont have sufficient balance to transfer");
            }
            return true;
        } catch (Exception e)
        {
            System.out.println("Something went wrong during transaction");
            return false;
        }
    }

}
