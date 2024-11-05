package org.example.producerConsumerProblem;

import org.example.semaphore.basicSemaphore.SemaphoreMain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    private final Semaphore empty;
    private final Semaphore full;
    private final Semaphore mutex;

    public Buffer(int capacity)
    {
        this.capacity = capacity;
        this.empty = new Semaphore(capacity);
        this.full = new Semaphore(0);
        this.mutex = new Semaphore(1);
    }

    public void produce(int item) throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        queue.add(item);
        System.out.println("Produced: " + item);
        mutex.release();
        full.release();
    }

    public int consume() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        int item = queue.poll();
        System.out.println("Consumed: " + item);
        mutex.release();
        empty.release();
        return item;
    }

}
