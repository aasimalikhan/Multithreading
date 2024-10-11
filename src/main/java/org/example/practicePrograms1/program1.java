package org.example.practicePrograms1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class program1 {
    public static void main(String[] args) {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                command.run();
            }
        };

        executor.execute(() -> {
            System.out.println("called from an executor");
        });
    }
}
