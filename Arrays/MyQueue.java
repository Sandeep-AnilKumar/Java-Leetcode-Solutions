package Arrays;
import Arrays.MyNode;
public class MyQueue {

	MyNode first, last;

	public void enqueue(MyNode n){
		if(first == null){
			first = n;
			last = first;
		}

		last.next = n;
		last = n;
	}

	public MyNode dequeue(){
		if(first == null){
			return null;
		}

		else{
			MyNode temp = new MyNode(first.val);
			first = first.next;
			return temp;
		}
	}
}
