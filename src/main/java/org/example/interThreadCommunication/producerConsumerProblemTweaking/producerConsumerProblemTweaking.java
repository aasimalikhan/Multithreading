package org.example.interThreadCommunication.producerConsumerProblemTweaking;

import org.example.interThreadCommunication.producerConsumerProblem.SharedBuffer;

public class producerConsumerProblemTweaking {
    public static void main(String[] args) {
        org.example.interThreadCommunication.producerConsumerProblem.SharedBuffer buffer = new SharedBuffer();
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 5; i++)
            {
                try {
                    buffer.produce(i);
                    Thread.sleep(1000);
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
        thread1.interrupt();
        thread2.start();
    }
}
