package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillProcesses {

	class NaryNode {
		int val;
		List<NaryNode> children;

		NaryNode(int val) {
			this.val = val;
			children = new ArrayList<>();
		}
	}

	public static void main(String[] args) {
		List<Integer> pid = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		List<Integer> ppid = new ArrayList<>(Arrays.asList(0,1,1,1,1));

		KillProcesses kp = new KillProcesses();
		System.out.println("The killed processes are := " + kp.killProcess(pid, ppid, 1));
	}

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		List<Integer> killedProcesses = new ArrayList<>();
		Map<Integer, NaryNode> treeMap = new HashMap<>();

		for(int i = 0; i < pid.size(); ++i) {
			treeMap.put(pid.get(i), new NaryNode(pid.get(i)));
		}

		NaryNode cur = null;
		for(int i = 0; i < ppid.size(); ++i) {
			if(ppid.get(i) != 0) {
				cur = treeMap.get(ppid.get(i));
				cur.children.add(treeMap.get(pid.get(i)));
			}
		}

		traverse(treeMap.get(kill), killedProcesses);

		return killedProcesses;
	}

	public void traverse(NaryNode node, List<Integer> killedProcesses) {
		if(node == null) {
			return;
		}

		Deque<NaryNode> stack = new ArrayDeque<>();
		stack.offerFirst(node);
		killedProcesses.add(node.val);
		NaryNode cur = null;

		while(!stack.isEmpty()) {
			cur = stack.pollFirst();
			for(NaryNode n: cur.children) {
				killedProcesses.add(n.val);
				stack.offerFirst(n);
			}
		}
		return;
	}
}
