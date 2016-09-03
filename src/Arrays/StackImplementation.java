package Arrays;
import java.util.NoSuchElementException;

public class StackImplementation<T> {
    private StackNode<T> first;
    private StackNode<T> top;
    private StackNode<T> head;
    private int size;

    static class StackNode<T> {
        private T value;
        private StackNode<T> next;

        public StackNode(T val) {
            this.value = val;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public StackNode<T> getNext() {
            return next;
        }

        public void setNext(StackNode<T> nextNode) {
            this.next = nextNode;
        }

        public String toString() {
            if(value == null) {
                return "null";
            }
            return value.toString();
        }
    }

    public StackImplementation() {
        head = new StackNode(0);
        size = 0;
        top = null;
        first = null;
    }

    public void push(T val) {
        StackNode<T> cur = new StackNode<T>(val);
        if(size == 0) {
            head.setNext(cur);
            size++;
            first = head.getNext();
            top = head.getNext();
            return;
        }

        top.setNext(cur);
        top = top.getNext();
        size++;
        return;
    }

    public StackNode<T> peek() {
        return top;
    }

    public void pop() {
        if(size == 0) {
            throw new NoSuchElementException();
        }

        StackNode<T> cur = first;
        while(!cur.getNext().equals(top)) {
            cur = cur.getNext();
        }

        cur.setNext(top.getNext());
        top = cur;
        size--;
        return;
    }

    public void clear() {
        head.setNext(null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StackNode<T> cur = first;
        sb.append(cur.getValue() + "->");
        while(!cur.equals(top)) {
            sb.append(cur.getValue() + "->");
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        StackImplementation<Integer> st = new StackImplementation<>();
        System.out.println(st.size());
        st.push(1);
        st.push(10);
        st.push(100);
        System.out.println(st.size());
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.isEmpty());
        st.clear();
        System.out.println(st.isEmpty());
        System.out.println(st.size());
        //st.pop(); //NoSuchElementException
    }
}
