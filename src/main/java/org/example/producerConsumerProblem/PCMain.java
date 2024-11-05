package org.example.producerConsumerProblem;

public class PCMain {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        Thread producer = new Thread(() -> {
            for(int i = 0; i < 30; i++)
            {
                try {
                    buffer.produce(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumer = new Thread(() -> {
            for(int i = 0; i < 20; i++)
            {
                try {
                    buffer.consume();
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
