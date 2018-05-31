package DataStructureImplementation;

public class MinStack {

    class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    /** initialize your data structure here. */

    private Node head;

    public MinStack() {}

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
    
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        System.out.println(stack.getMin());
        stack.push(-1);
        System.out.println(stack.top());
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.top());
    }
}
