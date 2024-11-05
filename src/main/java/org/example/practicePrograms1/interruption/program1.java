package org.example.practicePrograms1.interruption;

public class program1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread1.interrupt();
        Thread.sleep(1000);
        System.out.println("End of main thread");
    }
}
