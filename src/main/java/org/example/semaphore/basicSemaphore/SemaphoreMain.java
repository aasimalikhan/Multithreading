package org.example.semaphore.basicSemaphore;

public class SemaphoreMain {
    public static void main(String[] args) {
        Resource resource = new Resource(2);
        for(int i = 1; i <= 5; i++)
        {
            String threadName = "Thread" + i;
            new Thread(() -> {
                resource.useResource(threadName);
            }).start();
        }
    }
}
