package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NAryPostorder {
    public List<Integer> postorder(Node root) {
        List<Integer> order = new ArrayList<>();
        if (root == null) return order;
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(root);
        Node cur;
        LinkedList<Node> q;
        while (!dq.isEmpty()) {
            cur = dq.peekLast();
            q = new LinkedList<>(cur.children);

            if (q.isEmpty()) {
                dq.pollLast();
                order.add(cur.val);
                continue;
            }

            cur.children = q;
            while (!q.isEmpty()) {
                dq.offer(q.pollLast());
            }
        }
        return order;
    }
}
