package org.example.selfDeadlock;

public class selfDeadlock {
    NonReentrantLock lock = new NonReentrantLock();
    public void outerMethod() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " entered outerMethod");
        innerMethod();
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + "exited outerMethod");
    }

    public void innerMethod() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " entered innerMethod");
        lock.unlock();
    }

    public static void main(String[] args) {
        selfDeadlock self = new selfDeadlock();
        Thread thread = new Thread(() -> {
            try {
                self.outerMethod();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
