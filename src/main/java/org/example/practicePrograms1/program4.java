package org.example.practicePrograms1;

public class program4 {
    public volatile static int counter = 1;
    public static void incrementCounter()
    {
        counter = counter + 1;
    }
    public static void decrementCounter()
    {
        counter = counter - 1;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++)
            {
                incrementCounter();
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 1; i <= 10000; i++)
            {
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
