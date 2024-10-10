package org.example.secureVaultApplication.practiceCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Vault vault = new Vault(998);
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());
        for(Thread thread : threads)
        {
            thread.start();
        }
    }
    private static class Vault
    {
        private int password;
        public Vault(int password)
        {
            this.password = password;
        }
        public boolean checkIfPasswordCorrect(int guess)
        {
            try {
                Thread.sleep(5);
            }
            catch (InterruptedException e)
            {}
            return guess == this.password;
        }
    }

    private static abstract class HackerThread extends Thread
    {
        protected Vault vault;
        public HackerThread(Vault vault)
        {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }
        @Override
        public void start()
        {
            System.out.println("Starting thread" + Thread.currentThread().getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackerThread
    {

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }
        @Override
        public void run()
        {
            for(int guess = 0; guess <= MAX_PASSWORD; guess++)
            {
                if(this.vault.checkIfPasswordCorrect(guess))
                {
                    System.out.println(Thread.currentThread().getName() + "guessed the correct password: " + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHackerThread extends HackerThread
    {

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }
        @Override
        public void run()
        {
            for(int guess = MAX_PASSWORD; guess >= 0; guess--)
            {
                if(this.vault.checkIfPasswordCorrect(guess))
                {
                    System.out.println(Thread.currentThread().getName() + "guessed the correct password: " + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread
    {
        @Override
        public void run()
        {
            for(int i = 10; i >= 0; i--)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(i);
            }
            System.out.println("Hackers you are caught! GAME OVER BRUH");
        }

    }
}
