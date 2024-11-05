package org.example.practicePrograms1.interruption2;

public class program1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            int a = 10;
            for(int i = 0; i < 1000000000; i++)
            {
                if(Thread.currentThread().isInterrupted())
                {
                    System.out.println("Thread interrupted");
                    System.out.println("a: " + a);
                    break;
                }
                a++;
            }
            System.out.println("End of Thread1 code");

        });

        System.out.println("Main Thread started");
        thread1.start();
        thread1.interrupt();
        System.out.println("End of Main Thread");
    }
}
