package Arrays;

import java.util.NoSuchElementException;

public class LinkedListImplementation<T> {
    private int size;
    private ListNode<T> head;

    static class ListNode<T> {
        private T value;
        private ListNode<T> next;

        public ListNode(T val) {
            this.value = val;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public ListNode<T> getNext() {
            return next;
        }

        public void setNext(ListNode<T> nextNode) {
            this.next = nextNode;
            return;
        }

        public String toString() {
            if(this.value == null) {
                return "null";
            }
            return this.value.toString();
        }
    }

    public LinkedListImplementation() {
        head = new ListNode(0);
        head.setNext(null);
        size = 0;
    }

    public void add(T val) {
        ListNode<T> cur = new ListNode<>(val);
        if(size == 0) {
            head.setNext(cur);
            size++;
            return;
        }

        ListNode<T> prev = head;
        while(prev.getNext() != null) {
            prev = prev.getNext();
        }

        prev.setNext(cur);
        size++;
        return;
    }

    public boolean remove(T val) {
        if(size == 0) {
            throw new NoSuchElementException();
        }

        ListNode<T> cur = head;
        ListNode<T> prev = null;
        while(cur.getNext() != null && cur.getNext().getValue() != val) {
            prev = cur;
            cur = cur.getNext();
        }

        if(cur.getNext() != null && cur.getNext().getValue() == val) {
            prev = cur;
            cur = cur.getNext();
            prev.setNext(cur.getNext());
            size--;
        }
        else {
            return false;
        }
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head.setNext(null);
        size = 0;
        return;
    }

    public ListNode<T> get(int index) {
        if(index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int curIndex = index;
        ListNode<T> cur = head;

        while(cur.getNext() != null && curIndex-- > 0) {
            cur = cur.getNext();
        }

        if(curIndex != -1) {
            throw new NoSuchElementException();
        }
        return cur.getNext();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<T> cur = head;
        sb.append(cur.getValue() + "->");

        while(cur.getNext() != null) {
            sb.append(cur.getNext().getValue() + "->");
            cur = cur.getNext();
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListImplementation<Integer> list = new LinkedListImplementation<>();
        System.out.println(list.size());
        list.add(1);
        list.add(3);
        list.add(5);
        System.out.println(list.remove(3));
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.remove(6));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        //System.out.println(list.get(20));// ArraysIndexOutOfBoundsException.
        System.out.println(list.remove(5));
        System.out.println(list.size());
        //System.out.println(list.get(1));// ArraysIndexOutOfBoundsException.
        System.out.println(list.get(0));
        list.clear();
        System.out.println(list.size());
        //System.out.println(list.remove(1));//NoSuchElementException.
    }
}
