package org.example.practicePrograms1.join;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread1();
        thread1.start();
        Thread.sleep(3000);
        System.out.println("Somethjing");
        thread1.interrupt();
        thread1.join();
        System.out.println("End of Main thread");
    }
}
