package org.example.practicePrograms1;

/*
   CRITICAL SECTION PROBLEM
*/
public class program3 {
    public static int counter = 0;
    public static void incrementCounter()
    {
        counter += 1;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for(int i=1; i <= 100000; i++)
            {
                incrementCounter();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 1; i <= 100000; i++)
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
