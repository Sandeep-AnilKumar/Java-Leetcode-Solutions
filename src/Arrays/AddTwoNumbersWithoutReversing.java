package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbersWithoutReversing {

    public static void main(String[] args) {
        MyNode node1 = new MyNode(5);
        node1.next = new MyNode(8);
        node1.next.next = new MyNode(3);
        node1.next.next.next = new MyNode(6);

        MyNode node2 = new MyNode(3);
        node2.next = new MyNode(8);
        node2.next.next = new MyNode(7);

        MyNode result = addTwoNumbers(node1, node2);
        System.out.println("Result of addition of 2 list nodes is: ");
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static MyNode addTwoNumbers(MyNode l1, MyNode l2) {
        if(l1 == null) {
            return l2;
        } if(l2 == null) {
            return l1;
        }

        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        MyNode cur1 = l1;
        MyNode cur2 = l2;
        while(cur1 != null || cur2 != null) {
            if(cur1 != null) {
                stack1.offerLast(cur1.val);
                cur1 = cur1.next;
            } if(cur2 != null) {
                stack2.offerLast(cur2.val);
                cur2 = cur2.next;
            }
        }
        int sum = 0;
        int carry = 0;
        MyNode resultNode = new MyNode(0);
        MyNode temp = null;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            sum = carry + (stack1.isEmpty() ? 0: stack1.pollLast()) + (stack2.isEmpty() ? 0 : stack2.pollLast());
            carry = sum / 10;
            sum %= 10;
            temp = resultNode.next;
            resultNode.next = new MyNode(sum);
            resultNode.next.next = temp;
        }
        if(carry > 0) {
            temp = resultNode.next;
            resultNode.next = new MyNode(carry);
            resultNode.next.next = temp;
        }
        return resultNode.next;
    }
}
