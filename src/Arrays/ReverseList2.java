package Arrays;

public class ReverseList2 {

    public static void main(String[] args) {
        MyNode l1 = new MyNode(1);
        MyNode l2 = new MyNode(2);		
        MyNode l3 = new MyNode(3);
        MyNode l4 = new MyNode(4);
        MyNode l5 = new MyNode(5);
        MyNode l6 = new MyNode(5);
        MyNode l7 = new MyNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        reverseList(l1,2,4);
    }
    public static MyNode reverseList(MyNode head, int m, int n)
    {
        if(head == null || head.next == null)
            return head;

        int total = n-m;
        int j = m;

        MyNode dummy = new MyNode(0);
        MyNode pre = dummy;

        while(j > 1)
        {
            pre = pre.next;
            j--;
        }

        MyNode start = pre.next;
        MyNode then = start.next;

        while(total > 0)
        {
            start.next = start.next.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
            total--;
        }
        return dummy.next;
    }

    //A recursive solution.
    public static MyNode reverseList(MyNode head) {
        head = reverse(head, null);
        return head;
    }

    public static MyNode reverse(MyNode head, MyNode next) {
        if(head == null) {
            return next;
        }

        MyNode nextHead = head.next;
        head.next = next;
        return reverse(nextHead, head);
    }

    //An iterative solution.
    public static MyNode reverseListIterative(MyNode head) {
        if(head == null) {
            return head;
        }

        MyNode next = null;
        MyNode nextHead = null;
        MyNode cur = head;
        while(cur != null) {
            nextHead = cur.next;
            cur.next = next;
            next = cur;
            cur = nextHead;
        }
        return next;
    }
}
