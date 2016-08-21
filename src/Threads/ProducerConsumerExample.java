package Threads;

public class ProducerConsumerExample {
	public static void main(String[] args) {
		ValueStore valueObj = new ValueStore();
		(new Thread(new Producer(valueObj))).start();
		(new Thread(new Consumer(valueObj))).start();
	}

	static class ValueStore {
		// value sent from producer
		// to consumer.
		private int value = 0;
		// True if consumer should wait
		// for producer to send value,
		// false if producer should wait for
		// consumer to retrieve value.
		private boolean canAccess = true;

		public synchronized int get() {
			// Wait until value is
			// available.
			while (canAccess) {
				try {
					wait();
				} catch (InterruptedException e) {}
			}
			// Toggle status.
			canAccess = true;
			// Notify producer that
			// status has changed.
			notifyAll();
			return value;
		}

		public synchronized void set() {
			// Wait until value has
			// been retrieved.
			while (!canAccess) {
				try { 
					wait();
				} catch (InterruptedException e) {}
			}
			// Toggle status.
			canAccess = false;
			// Store message.
			this.value++;
			// Notify consumer that status
			// has changed.
			notifyAll();
		}
	}

	static class Producer implements Runnable {
		private ValueStore valueObj;

		public Producer(ValueStore valueObj) {
			this.valueObj = valueObj;
		}

		public void run() {

			for (int i = 0; i < 10; i++) {
				valueObj.set();
				System.out.println("Produced value: " + valueObj.value );
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		}
	}

	static class Consumer implements Runnable {
		private ValueStore valueObj;

		public Consumer(ValueStore valueObj) {
			this.valueObj = valueObj;
		}

		public void run() {

			for (int i = 0; i < 10; ++i){
				System.out.println("Consumed value:"+ valueObj.get());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		}
	}
}
