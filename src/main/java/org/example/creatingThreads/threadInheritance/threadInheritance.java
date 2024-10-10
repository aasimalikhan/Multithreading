package org.example.creatingThreads.threadInheritance;

public class threadInheritance {
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.setName("thread created using Thread class extension");
        thread.start();
    }
    private static class NewThread extends Thread {
        @Override
        public void run()
        {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }
}
