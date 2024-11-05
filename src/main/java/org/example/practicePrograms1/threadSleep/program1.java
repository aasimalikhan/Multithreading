package org.example.practicePrograms1.threadSleep;

public class program1 {
    public static void main(String[] args) {
        Thread workerThread = new Thread(() -> {
            System.out.println("Worker thread starting");
            try {
                Thread.sleep(1000);
                System.out.println("Worker thread woke up and completed");
            } catch (InterruptedException e)
            {
                System.out.println("Worker thread interrupted during sleep");
            }
        });
        workerThread.start();

        try {
            System.out.println("Main thread sleeping for 1 second");
            Thread.sleep(1000);
            System.out.println("Main thread woke up");
        } catch (InterruptedException e)
        {
            System.out.println("Main thread interrupted during sleep");
        }
    }
}
