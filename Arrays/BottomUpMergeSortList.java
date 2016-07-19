package Arrays;

public class BottomUpMergeSortList {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(6);
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(8);
		MyNode l5 = new MyNode(2);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		MyNode result = sortList(l1);
		while(result.next != null) {
			System.out.print(result.val + ", ");
			result = result.next;
		}
		System.out.println(result.val);
	}

	public static MyNode move(MyNode head, int moveBy) {
		while(head!=null && moveBy-- > 0)
			head=head.next;
		return head;
	}

	public static MyNode merge(MyNode loop, int length) {
		if (loop==null || loop.next==null)
			return null;
		MyNode start1 = loop.next;
		MyNode end1   = move(start1, length/2-1);
		if (end1 == null)
			return null;
		MyNode start2 = end1.next;
		end1.next = null;
		MyNode end2 = move(start2, length/2-1);
		MyNode end2next = (end2!=null)? end2.next: null;
		if (end2next!=null)
			end2.next = null;
		while (start1!=null || start2!=null) {
			if (start2==null || (start1!=null && start1.val < start2.val)) {
				loop.next = start1;
				start1=start1.next;
				loop=loop.next;
			} else {
				loop.next = start2;
				start2=start2.next;
				loop=loop.next;
			}
		}
		loop.next=end2next;
		return loop;
	}

	public static MyNode sortList(MyNode head) {
		MyNode dummy = new MyNode(0);
		dummy.next = head;
		for (int k=2; true; k*=2) {
			int nMerges = 0;
			MyNode loop = dummy;
			while(loop!=null && loop.next!=null) {
				loop = merge(loop, k);
				nMerges++;
			}
			if (nMerges<=1)
				break;
		}
		return dummy.next;
	}

	//time complexity is O(nlogn), space complexity is constant. But difficult to implement.
	//Easier solution is below, time is O(nlogn), and space is O(logn).
}

/*
 * ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        head = sortList(head);
        slow = sortList(slow);

        return merge(head, slow);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode l = newHead;

        if(l1 == null || l2 == null) {
            return (l1 == null ? l2 : l1);
        }

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                l.next = l1;
                l1 = l1.next;
            }
            else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }

        if(l1 == null) {
            l.next = l2;
        }
        if(l2 == null) {
            l.next = l1;
        }
        return newHead.next;
    }
 */

/*
 * Quicksort implementation: -
 * ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        return head;

    //split into three list
    ListNode fakesmall = new ListNode(0), small = fakesmall;
    ListNode fakelarge = new ListNode(0), large = fakelarge;
    ListNode fakeequal = new ListNode(0), equal = fakeequal;

    ListNode cur = head; // pivot is h.
    while(cur != null){
        if(cur.val < head.val){
            small.next = cur;
            small = small.next;
        }
        else if(cur.val == head.val){
            equal.next = cur;
            equal = equal.next;
        }
        else{
            large.next = cur;
            large = large.next;
        }

        cur = cur.next;
    }

    // put an end.
    small.next = equal.next = large.next = null;
    // merge them and return . merge reusing below one. merge for quicksort should be simplified. 
    return merge(merge(sortList(fakesmall.next), sortList(fakelarge.next)),fakeequal.next) ;
}

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode l = newHead;

        if(l1 == null || l2 == null) {
            return (l1 == null ? l2 : l1);
        }

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                l.next = l1;
                l1 = l1.next;
            }
            else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }

        if(l1 == null) {
            l.next = l2;
        }
        if(l2 == null) {
            l.next = l1;
        }
        return newHead.next;
    }
 */ //The space is O(3logn) nothing but O(logn) and time complexity is O(nlogn).