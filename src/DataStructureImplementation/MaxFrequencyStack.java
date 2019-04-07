package DataStructureImplementation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MaxFrequencyStack {

	private final Map<Integer, TreeSet<Node>> freq;
	private final Map<Integer, Node> map;
	private int cur;

	public MaxFrequencyStack() {
		freq = new TreeMap<>((a, b) -> b - a);
		map = new HashMap<>();
		cur = 1;
	}

	public static void main(String[] args) {
		MaxFrequencyStack frequencyStack = new MaxFrequencyStack();
		frequencyStack.push(5);
		frequencyStack.push(7);
		frequencyStack.push(5);
		frequencyStack.push(7);
		frequencyStack.push(4);
		frequencyStack.push(5);
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
	}

	public void push(int value) {
		if (!map.containsKey(value)) {
			map.put(value, new Node(value));
		}

		Node node = map.get(value);

		removeNode(node);

		node.curFre++;

		node.times.offer(cur++);

		addNode(node);
	}

	public int pop() {
		Map.Entry<Integer, TreeSet<Node>> entry = freq.entrySet().stream().findFirst().get();

		int curFre = entry.getKey();
		Node node = entry.getValue().stream().findFirst().get();

		int value = node.value;

		removeNode(node);

		node.curFre--;

		node.times.pollLast();

		addNode(node);

		return value;
	}

	private void removeNode(Node node) {
		if (freq.containsKey(node.curFre)) {
			freq.get(node.curFre).remove(node);
			if (freq.get(node.curFre).size() == 0) freq.remove(node.curFre);
		}
	}

	private void addNode(Node node) {
		if (!freq.containsKey(node.curFre)) {
			freq.put(node.curFre, new TreeSet<>());
		}
		freq.get(node.curFre).add(node);
	}

	class Node implements Comparable<Node> {
		int value;
		Deque<Integer> times;
		int curFre;

		public Node(int value) {
			this.value = value;
			curFre = 0;
			times = new ArrayDeque<>();
			times.offer(0);
		}

		@Override
		public int compareTo(Node other) {
			return other.times.peekLast() - times.peekLast();
		}
	}
}
