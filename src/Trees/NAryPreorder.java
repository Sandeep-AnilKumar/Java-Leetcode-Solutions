package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NAryPreorder {

    public List<Integer> preorder(Node root) {
        List<Integer> order = new ArrayList<>();
        if (root == null) return order;
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(root);
        Node cur;
        Deque<Node> q;
        while (!dq.isEmpty()) {
            cur = dq.pollLast();
            q = new ArrayDeque<>(cur.children);
            order.add(cur.val);
            while (!q.isEmpty()) {
                dq.offer(q.pollLast());
            }
        }
        return order;
    }
}
