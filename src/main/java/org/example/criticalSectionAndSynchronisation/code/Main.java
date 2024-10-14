package org.example.criticalSectionAndSynchronisation.code;

public class Main {
    public static int counter = 0;
    public synchronized static void incrementCounter()
    {
        counter += 1;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 100000; i++) {
                incrementCounter();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 100000; i++) {
                incrementCounter();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("counter: " + counter);
    }
}
