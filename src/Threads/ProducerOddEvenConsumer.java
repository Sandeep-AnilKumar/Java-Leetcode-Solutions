package Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sandeepa
 */

public class ProducerOddEvenConsumer {
    static BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
    static volatile boolean finished = false;
    final static int toProduce = 10; 
    static boolean odd = true;

    static class Producer implements Runnable {
        @Override public void run() {
            for(int i = 1; i <= toProduce; ++i) {
                try {
                    bq.put(i);
                    System.out.println("Produced " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            finished = true;
        }
    }

    static class Consumer1 implements Runnable {
        @Override
        public void run() {
            while (!finished) {
                while (odd) {
                    try {
                        int cur = bq.take();
                        System.out.println("Consumer 1 consumed " + cur);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    odd = false;
                }
            }
            return;
        }
    }

    static class Consumer2 implements Runnable {
        @Override public void run() {
            while(!finished) {
                while (!odd) {
                    try {
                        int cur = bq.take();
                        System.out.println("Consumer 2 consumed " + cur);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    odd = true;
                }
            }
            return; 
        }
    }

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer());
        Thread consumer1 = new Thread(new Consumer1());
        Thread consumer2 = new Thread(new Consumer2());

        System.out.println("Starting the threads. . .");
        producer.start();
        consumer1.start();
        consumer2.start();
        System.out.println("Started the threads. . .");

        try {
            producer.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Threads finished execution. . .");
    }
}
