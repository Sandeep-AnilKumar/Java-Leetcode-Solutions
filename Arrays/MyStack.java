package Arrays;
import Arrays.MyNode;

public class MyStack {

	MyNode top;

	public void push(MyNode n){

		if(n != null){
			n.next = top;
			top = n;
		}
	}
	public MyNode pop(){
		if(top == null)
		{
			return null;
		}
		else
		{
			MyNode temp = new MyNode(top.val);
			top = top.next;
			return temp;
		}
	}

	public MyNode peek(){
		if(top == null){
			return null;
		}
		return top;
	}
}
