package org.example.semaphore.basicSemaphore;

import java.util.concurrent.Semaphore;

public class Resource {
    public final Semaphore semaphore;
    public Resource(int permits)
    {
        semaphore = new Semaphore(permits);
    }
    public void useResource(String threadName)
    {
        try {
            System.out.println(threadName + " is trying to acquire a permit");
            semaphore.acquire();
            System.out.println(threadName + " has acquired a permit");
            System.out.println(threadName + " is using the resource");
            Thread.sleep(1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally {
            System.out.println(threadName + " is releasing the permit");
            semaphore.release();
        }
    }
}
