package org.example.practicePrograms1.join;

public class Thread1 extends Thread{
    @Override
    public void run()
    {
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                System.out.println("Thread2 interrupted");
            }
        });
        System.out.println("Thread1 started");
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread1 interrupted");
        }
        System.out.println("Thread1 completed execution");
    }
}

