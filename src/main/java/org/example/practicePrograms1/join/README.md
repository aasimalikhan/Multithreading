## Flow of Execution:

The ```main thread``` starts thread1.
The ```main thread``` then sleeps for 3 seconds.
During this time, ```thread1``` begins execution and starts ```thread2```, which itself calls sleep(3500) to pause for 3.5 seconds.
After 3 seconds, the main thread wakes up and interrupts ```thread1``` by calling ```thread1.interrupt()```.
## Interruption of thread1:

At the time of interruption, ```thread1``` is waiting for thread2 to complete because of the thread2.join() call inside its run() method.
thread1 is in a blocked state while waiting for thread2 to finish.
Since thread1 is in a blocked state, the interrupt() call on thread1 will cause the InterruptedException to be thrown in the thread2.join() line of thread1’s run() method.
## Handling the Interruption:

When thread1 catches the InterruptedException, it executes the code inside the catch block, printing "Thread1 interrupted".
After handling the exception, thread1 continues to the next line in the run() method, which prints "Thread1 completed execution", assuming it doesn’t re-throw the exception or terminate.