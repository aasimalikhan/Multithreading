package org.example.criticalSectionAndSynchronisation.code2;

public class Main {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();
    public static void doSomething()
    {
        synchronized (lock2) {
            System.out.println("Doing something");
        }
    }
    public static void doSomethingUseful()
    {
        synchronized (lock1) {
            System.out.println("Doing Something useful");
        }
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            doSomething();
        });
        Thread thread2 = new Thread(() -> {
            doSomethingUseful();
        });
        thread1.start();
        thread2.start();
    }
}
