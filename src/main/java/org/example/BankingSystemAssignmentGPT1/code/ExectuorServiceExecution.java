package org.example.BankingSystemAssignmentGPT1.code;

import java.sql.Time;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExectuorServiceExecution {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount1 = new BankAccount();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i = 1; i <= 20000; i++)
        {
            int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Task: " + taskNumber + ", getting executed by: " + Thread.currentThread().getName());
                bankAccount1.deposit(1);
            });
        }
        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("yooo");
        System.out.println(bankAccount1.getBalance());
    }
}
