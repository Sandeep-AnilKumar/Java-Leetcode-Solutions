package Threads;

public class Deadlock {
	static class Friend {
		private final String name;
		public Friend(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s"
					+ "  has bowed to me!%n", 
					this.name, bower.getName());
			bower.bowBack(this);
		}
		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s"
					+ " has bowed back to me!%n",
					this.name, bower.getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		Thread f1 = new Thread( () ->  {alphonse.bow(gaston);} );
		
		f1.start();
		//f1.join(); //Without this line there will be deadlock;
		
		Thread f2 = new Thread(new Runnable() {
			public void run() { gaston.bow(alphonse); }
		});
		
		f2.start();
	}
}