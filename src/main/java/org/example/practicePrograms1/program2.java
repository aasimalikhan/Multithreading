package org.example.practicePrograms1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class program2 {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10; i++)
        {
            int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Task: " + taskNumber + ", executed by: " + Thread.currentThread().getName());
            });
        }
    }
}
