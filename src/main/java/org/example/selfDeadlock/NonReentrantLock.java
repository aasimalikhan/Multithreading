package org.example.selfDeadlock;

public class NonReentrantLock {
    public boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while(isLocked)
        {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock()
    {
        isLocked = false;
        notify();
    }
}
