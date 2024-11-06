package org.example.interThreadCommunication.producerConsumerProblem;

public class producerConsumerProblem {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 5; i++)
            {
                try {
                    buffer.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 5; i++)
            {
                try {
                    buffer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
