package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Calendar {

	class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "start: " + this.start + ", end: " + this.end;
		}
	}

	PriorityQueue<Interval> pq;

	public Calendar() {
		pq = new PriorityQueue<>(new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
	}

	public boolean canAdd(int start, int end) {
		if(pq.isEmpty()) {
			return true;
		}

		PriorityQueue<Interval> cur = new PriorityQueue<>(new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		Interval curInterval = null;

		while(!pq.isEmpty()) {
			curInterval = pq.poll();
			cur.offer(curInterval);

			if((start < curInterval.start && end > curInterval.start) || 
					(start >= curInterval.start && start < curInterval.end)) {
				while(!cur.isEmpty()) {
					pq.offer(cur.poll());
				}
				return false;
			}
		}
		while(!cur.isEmpty()) {
			pq.offer(cur.poll());
		}
		return true;
	}

	public void add(int start, int end) {
		if(canAdd(start, end)) {
			Interval i = new Interval(start, end);
			pq.offer(i);
			System.out.println("Added calendar event from " + start + " to " + end);
		} else {
			System.out.println("Cannot add the interval from " + start + " to " + end);
			proposeSameDuration(start, end);
		}
		return;
	}

	public void proposeSameDuration(int start, int end) {
		Interval curInterval = null;
		PriorityQueue<Interval> cur = new PriorityQueue<>(new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		int prevEnd = 0;
		int duration = end - start;

		while(!pq.isEmpty()) {
			curInterval = pq.poll();
			cur.offer(curInterval);

			if(curInterval.start - prevEnd >= duration) {
				System.out.println("The earliest calendar event for same duration can be added between " + prevEnd + " to " + curInterval.start);
				while(!cur.isEmpty()) {
					pq.offer(cur.poll());
				}
				return;
			} else {
				prevEnd = curInterval.end;
			}
		}
		while(!cur.isEmpty()) {
			pq.offer(cur.poll());
		}
		System.out.println("The earliest calendar event for same duration can be added from " + prevEnd);
		return;
	}

	public static void main(String[] args) {
		Calendar c = new Calendar();
		c.add(0, 60);
		c.add(65, 115);
		c.add(65, 130);
		c.add(120, 180);
		c.add(65, 200);
		c.add(130, 170);
		c.add(130, 200);
		c.add(25, 45);
		c.add(180, 200);
	}
}
