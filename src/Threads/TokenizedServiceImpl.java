package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TokenizedServiceImpl {
	private static BlockingQueue<Integer> queue;
	private static Thread[] tokenProviderThreads;
	private static Thread[] serviceProviderThreads;
    private static AtomicInteger token;

	public TokenizedServiceImpl(int capacity, int totalTokenStations, int totalServiceStations, int initialToken) {
		queue = new LinkedBlockingDeque<>(capacity);
        tokenProviderThreads = new Thread[totalTokenStations];
        serviceProviderThreads = new Thread[totalServiceStations];
        token = new AtomicInteger(initialToken);
	}

	public static void main(String[] args) {
		try {
		    Scanner scanner = new Scanner(System.in);
		    System.out.print("Enter the total slack for tokens waiting : ");
		    int capacity = scanner.nextInt();
            System.out.print("Enter the total number of token stations : ");
            int totalTokenStations = scanner.nextInt();
            System.out.print("Enter the total number of service providers : ");
            int totalServiceStations = scanner.nextInt();
            System.out.print("Enter the starting token value : ");
            int initialToken = scanner.nextInt();
			TokenizedServiceImpl tokenService = new TokenizedServiceImpl(capacity, totalTokenStations, totalServiceStations, initialToken);
			List<Thread> threads = new ArrayList<>();
			
			char name = '1';

			for (Thread tokenThread : tokenProviderThreads) {
				tokenThread = new Thread(new TokenProvider(name, queue, token));
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
	private Random random;
	private AtomicInteger token;

	public TokenProvider(char name, BlockingQueue<Integer> queue, AtomicInteger token) {
		this.queue = queue;
		this.name = name;
        this.token = token;
		random = new Random();
		System.out.println("Token provider " + name + " has started");
	}

	@Override
	public void run() {
		try {
		    while(true) {
		        int curToken = token.addAndGet(1);
		        System.out.println("Token provider " + name + " produced " + curToken);
		        queue.put(curToken);
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
