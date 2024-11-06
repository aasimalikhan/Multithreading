package org.example.interThreadCommunication.producerConsumerProblem;

public class SharedBuffer {
    private int data;
    private boolean hasData = false;
    public synchronized  void produce(int data) throws InterruptedException {
        while(hasData)
        {
            wait();
        }
        this.data = data;
        hasData = true;
        System.out.println("Produced: " + data);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while(!hasData)
        {
            wait();
        }
        System.out.println("Consumed: " + this.data);
        hasData = false;
        notify();
    }
}
