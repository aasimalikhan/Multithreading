package org.example.threadTerminationAndDaemonThreads.code2;

import java.math.BigInteger;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Thread longComputationTask = new Thread(new LongComputationTask(new BigInteger("2"), new BigInteger("10")));
        longComputationTask.start();
        longComputationTask.interrupt();
    }
    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;
        public LongComputationTask(BigInteger base, BigInteger power)
        {
            this.base = base;
            this.power = power;
        }
        @Override
        public void run()
        {
            System.out.println(base + "^" + power + ": " + pow(base, power));
        }
        private BigInteger pow(BigInteger base, BigInteger power)
        {
            BigInteger result = BigInteger.ONE;
            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE))
            {
                if(Thread.currentThread().isInterrupted())
                {
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }
}
