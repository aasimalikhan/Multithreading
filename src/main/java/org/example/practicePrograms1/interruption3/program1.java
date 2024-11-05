package org.example.practicePrograms1.interruption3;

public class program1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Random code in thread");
        });

        thread1.start();
        thread1.interrupt();
        System.out.println("End of main thread");
    }
}
