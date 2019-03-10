package Arrays;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TradeOrder {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input = "";
		String[] parts;
		boolean isBuy = false;
		long index = 1;
		long volume = 0;
		double price = 0.0;

		PriorityQueue<Order> buy = new PriorityQueue<Order>(new Comparator<Order>() {
			@Override
			public int compare(Order a, Order b) {
				if (a.price == b.price) return Long.compare(a.index, b.index);
				return Double.compare(b.price, a.price);
			}
		});

		PriorityQueue<Order> sell = new PriorityQueue<Order>(new Comparator<Order>() {
			@Override
			public int compare(Order a, Order b) {
				if (a.price == b.price) return Long.compare(a.index, b.index);
				return Double.compare(a.price, b.price);
			}
		});

		while (in.hasNext()) {
			input = in.next();
			parts = input.split("\\s+");
			if (parts[1].equals("buy")) isBuy = true;
			volume = Long.parseLong(parts[2]);
			price = Double.parseDouble(parts[3]);

			if (isBuy) {
				buy.offer(new Order(index, volume, price));
			} else {
				sell.offer(new Order(index, volume, price));
			}

			processOrder(buy, sell);
			index++;
		}
	}

	private static void processOrder(PriorityQueue<Order> buy, PriorityQueue<Order> sell) {
		Order bOrder, sOrder;
		long maxVolume = 0;
		while (!buy.isEmpty() && !sell.isEmpty() && buy.peek().price >= sell.peek().price) {
			bOrder = buy.peek();
			sOrder = sell.peek();
			maxVolume = Math.max(bOrder.volume, sOrder.volume);
			System.out.println("match " + sOrder.index + " " + bOrder.index + " " + maxVolume + " " + bOrder.price);
			bOrder.volume -= maxVolume;
			sOrder.volume -= maxVolume;
			if (bOrder.volume == 0) buy.poll();
			if (sOrder.volume == 0) sell.poll();
		}
	}

	static class Order {
		long index;
		long volume;
		double price;

		public Order(long index, long volume, double price) {
			this.index = index;
			this.volume = volume;
			this.price = price;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != this.getClass()) return false;
			Order other = (Order) o;
			return index == other.index && volume == other.volume && price == other.price;
		}

		@Override
		public int hashCode() {
			return Objects.hash(index, volume, price);
		}
	}
}