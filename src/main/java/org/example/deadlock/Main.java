package org.example.deadlock;

import java.util.Random;

public class Main {

    public static class Intersection {
        private Object roadA = new Object();
        private Object roadB = new Object();

        public void TakeRoadA() {
            synchronized (roadA) {
                System.out.println("Road A is locked by thread: " + Thread.currentThread().getName());

                synchronized (roadB) {
                    System.out.println("Train is passing through road B");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }

        public void TakeRoadB() {
            synchronized (roadB) {
                System.out.println("Road B is locked by thread " + Thread.currentThread().getName());

                synchronized (roadA) {
                    System.out.println("Train is passing through road A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }
    }
    public static class TrainB implements Runnable {
        private Intersection intersection;
        private Random random = new Random();
        public TrainB(Intersection intersection) {
            this.intersection = intersection;
        }
        @Override
        public void run() {
            while(true)
            {
                long sleepingTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepingTime);
                }
                catch (InterruptedException e)
                {

                }
                intersection.TakeRoadB();
            }
        }
    }

    public static class TrainA implements Runnable {
        private Intersection intersection;
        private Random random = new Random();
        public TrainA(Intersection intersection) {
            this.intersection = intersection;
        }
        @Override
        public void run() {
            while(true)
            {
                long sleepingTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepingTime);
                }
                catch (InterruptedException e)
                {

                }
                intersection.TakeRoadA();
            }
        }
    }
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread trainAThread = new Thread(new TrainA(intersection));
        Thread trainBThread = new Thread(new TrainB(intersection));

        trainAThread.start();
        trainBThread.start();
    }
}
