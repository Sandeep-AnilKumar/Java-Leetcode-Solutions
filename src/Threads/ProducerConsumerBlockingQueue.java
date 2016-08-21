package Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {

	static class Message {
		String msg = "";

		public Message(String msg) {
			this.msg = msg;
		}

		public String getMessage() {
			return msg;
		}
	}

	static class Producer implements Runnable {
		BlockingQueue<Message> q = null;

		public Producer(BlockingQueue<Message> queue) {
			this.q = queue;
		}

		public void run() {
			try {
				for(int i = 0; i < 10; ++i) {
					q.put(new Message("" + i));
					System.out.println("Produced " + i);
					Thread.sleep(2000);
				}
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}

			try {
				q.put(new Message("Exit"));
				System.out.println("Produced exit");
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Consumer implements Runnable {
		BlockingQueue<Message> q = null;

		public Consumer(BlockingQueue<Message> queue) {
			this.q = queue;
		}

		public void run() {
			try {
				Message msg;
				while((msg = q.take()).getMessage() != "Exit") {
					System.out.println("Consumed " + msg.getMessage());
					//Thread.sleep(1000);
				}
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



	public static void main(String[] args) {
		BlockingQueue<Message> bq = new ArrayBlockingQueue<>(10);
		Producer producer = new Producer(bq);
		Consumer consumer = new Consumer(bq);

		System.out.println("Starting Producer Consumer Threads. . .");
		new Thread(producer).start();
		new Thread(consumer).start();
		System.out.println("Started Producer Consumer Threads. . .");
	}

}