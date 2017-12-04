package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sandeepa
 */

public class Node {
	private static enum State {
		Unvisited, Visiting, Visited;
	}

	private int val;
	private State state;
	private List<Node> adjacent;

	public Node(int val) {
		this.val = val;
		this.state = State.Unvisited;
		this.adjacent = new ArrayList<Node>();
	}

	public int getValue() {
		return this.val;
	}

	public void setValue(int val) {
		this.val = val;
		return;
	}

	public void addAdjacentNode(Node node) {
		this.adjacent.add(node);
		return;
	}

	public List<Node> getAdjacentNodes() {
		return this.adjacent;
	}

	public State getState() {
		return this.state;
	}

	public void setVisiting() {
		this.state = State.Visiting;
	}

	public void setVisited() {
		this.state = State.Visited;
	}

	public void setUnvisited() {
		this.state = State.Unvisited;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.val + " -> [");
		for(int index = 0; index < adjacent.size(); ++index) {
			sb.append(adjacent.get(index).val);
			if(index != adjacent.size() - 1) sb.append(" ,");
		}
		sb.append("]");
		return sb.toString();
	}
}
