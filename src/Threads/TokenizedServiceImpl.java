package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class TokenizedServiceImpl {
	private static BlockingQueue<Integer> queue;

	public TokenizedServiceImpl() {
		queue = new ArrayBlockingQueue<>(100);
	}

	public static void main(String[] args) {
		try {
			TokenizedServiceImpl tokenService = new TokenizedServiceImpl();
			List<Thread> threads = new ArrayList<>();

			Thread[] tokenProviderThreads = new Thread[1];
			Thread[] serviceProviderThreads = new Thread[4];
			char name = '1';

			for (Thread tokenThread : tokenProviderThreads) {
				tokenThread = new Thread(new TokenProvider(name, queue));
				threads.add(tokenThread);
				name = (char)(name + 1);
			}
			
			name = '1';

			for (Thread serviceThread : serviceProviderThreads) {
                serviceThread = new Thread(new ServiceProvider(name, queue));
				threads.add(serviceThread);
				name = (char)(name + 1);
			}
			
			for (Thread thread : threads) {
			    thread.start();
            }
            
            for (Thread thread : threads) {
			    thread.join();
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class TokenProvider implements Runnable {
	private BlockingQueue<Integer> queue;
	private final char name;
	private int tokenNumber = 0;
	private Random random;

	public TokenProvider(char name, BlockingQueue<Integer> queue) {
		this.queue = queue;
		this.name = name;
		random = new Random();
		System.out.println("Token provider " + name + " has started");
	}

	@Override
	public void run() {
		try {
		    while(true) {
		        System.out.println("Token provider " + name + " produced " + ++tokenNumber);
		        queue.put(tokenNumber);
		        Thread.sleep(random.nextInt(1000));
            }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ServiceProvider implements Runnable {
	private BlockingQueue<Integer> queue;
	private final char name;
	private Random random;

	public ServiceProvider(char name, BlockingQueue<Integer> queue) {
		this.queue = queue;
		this.name = name;
		random = new Random();
		System.out.println("Service provider " + name + " has started");
	}

	@Override
	public void run() {
		try {
			while(true) {
			    int token = queue.take();
			    System.out.println("Service provider " + name + " received token " + token);
			    Thread.sleep(random.nextInt(10000));
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
