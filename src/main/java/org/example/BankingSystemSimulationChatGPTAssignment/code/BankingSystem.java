package org.example.BankingSystemSimulationChatGPTAssignment.code;

import java.util.ArrayList;
import java.util.List;

public class BankingSystem {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount1 = new BankAccount();
        BankAccount bankAccount2 = new BankAccount();
        BankAccount bankAccount3 = new BankAccount();

        bankAccount2.deposit(200000);
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 20; i++)
        {
            Thread thread = new Thread(() -> {
                bankAccount2.transferTo(bankAccount1, 10000);
            });
            threads.add(thread);
        }
        for(int i = 0; i < 20; i++)
        {
            threads.get(i).start();
            threads.get(i).join();
        }
        System.out.println(bankAccount1.getBalance());

        bankAccount2.deposit(100000);
        Thread threadLongRunning = new Thread(() -> {
            try {
                bankAccount2.longRunningTransfer(bankAccount1, 10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadLongRunning2 = new Thread(() -> {
            try {
                bankAccount3.deposit(10000);
                bankAccount3.longRunningTransfer(bankAccount1, 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadLongRunning.start();
        threadLongRunning.interrupt();
        threadLongRunning2.start();
        threadLongRunning2.join();
        System.out.println("bankAccount3 balance: " + bankAccount3.getBalance());
//        threadLongRunning.join();
        System.out.println("End of main");

    }
}
