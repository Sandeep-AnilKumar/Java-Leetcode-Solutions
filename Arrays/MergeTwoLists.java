package Arrays;

public class MergeTwoLists {

	public static void main(String[] args) {
		MyNode l1 = new MyNode(1);
		MyNode l2 = new MyNode(2);		
		MyNode l3 = new MyNode(3);
		MyNode l4 = new MyNode(4);
		MyNode l5 = new MyNode(2);
		MyNode l6 = new MyNode(2);
		MyNode l7 = new MyNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;

		//l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		mergeTwoLists(l1,l5);

	}

	public static MyNode mergeTwoLists(MyNode l1, MyNode l2)
	{
		if (l1 ==  null)
			return l2;
		if(l2 == null)
			return l1;

		MyNode newHead = new MyNode(0);
		MyNode finalList = newHead;
		MyNode first = l1;
		MyNode second = l2;

		while(first != null && second != null)
		{
			if(first.val < second.val)
			{
				MyNode temp = first;
				finalList.next = temp;
				finalList = finalList.next;
				first = first.next;
				temp.next = null;
			}

			else if(first.val == second.val)
			{
				MyNode temp1 = first;
				MyNode temp2 = second;

				finalList.next = temp1;
				finalList = finalList.next;
				first = first.next;
				temp1.next = null;


				finalList.next = temp2;
				finalList = finalList.next;
				second = second.next;
				temp2.next = null;
			}

			else
			{
				MyNode temp = second;
				finalList.next = temp;
				finalList = finalList.next;
				second = second.next;
				temp.next = null;
			}
		}

		if(first == null)
			finalList.next = second;
		else if(second == null)
			finalList.next = first;

		return newHead.next;
	}
}
/*other solution, more feasible one : -
 * 
 * {
 * {
 * if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode dummy = new ListNode(0);
        ListNode finalList = dummy;

        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                finalList.next = l1;
                l1 = l1.next;
            }
            else
            {
                finalList.next = l2;
                l2 = l2.next;
            }
            finalList = finalList.next;
        }

        if(l1 == null)
            finalList.next = l2;
        if(l2 == null)
            finalList.next = l1;

        return dummy.next;
        }
        }
 */
