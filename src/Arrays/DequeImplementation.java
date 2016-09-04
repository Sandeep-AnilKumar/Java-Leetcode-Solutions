package Arrays;

public class DequeImplementation<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;
    private int size;

    private static class QueueNode<T> {
        private T val;
        private QueueNode<T> next;
        private QueueNode<T> prev;

        public QueueNode(T val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        public T getValue() {
            return val;
        }

        public void setNext(QueueNode<T> nextNode) {
            next = nextNode;
        }

        public QueueNode<T> getNext() {
            return next;
        }

        public void setPrev(QueueNode<T> prevNode) {
            prev = prevNode;
        }

        public QueueNode<T> getPrev() {
            return prev;
        }

        public String toString() {
            if(val == null) {
                return "null";
            }
            return val.toString();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offerLast(T val) {
        QueueNode<T> cur = new QueueNode(val);
        if(size == 0) {
            cur.setNext(first);
            first = cur;
            last = cur;
            size++;
            return;
        }

        last.setNext(cur);
        cur.setPrev(last);
        last = cur;
        size++;
    }

    public void offerFirst(T val) {
        QueueNode<T> cur = new QueueNode(val);
        if(size == 0) {
            cur.setNext(first);
            first = cur;
            last = cur;
            size++;
            return;
        }

        cur.setNext(first);
        first.setPrev(cur);
        first = cur;
        size++;
    }

    public T peekLast() {
        if(isEmpty()) {
            return null;
        }
        return last.getValue();
    }

    public T peekFirst() {
        if(isEmpty()) {
            return null;
        }
        return first.getValue();
    }

    public QueueNode<T> pollFirst() {
        if(isEmpty()) {
            return null;
        }

        QueueNode<T> cur = first;
        first = first.getNext();
        if(first != null) {
            first.setPrev(null);
        }
        size--;
        return cur;
    }

    public QueueNode<T> pollLast() {
        if(isEmpty()) {
            return null;
        }

        QueueNode<T> cur = last;
        last = last.getPrev();
        if(last != null) {
            last.setNext(null);
        }
        size--;
        return cur;
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public String toString() {
        if(size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("null<-");
        QueueNode<T> cur = first;
        sb.append(cur.getValue() + "<-");

        while(cur.getNext() != null && !cur.equals(last)) {
            sb.append(cur.getNext().getValue() + "<-");
            cur = cur.getNext();
        }

        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        DequeImplementation<Integer> dq = new DequeImplementation<>();
        System.out.println(dq.size());
        System.out.println(dq.pollLast()); //returns null
        System.out.println(dq);
        dq.offerLast(100);
        dq.offerFirst(10);
        dq.offerFirst(1);
        System.out.println(dq.pollFirst());
        System.out.println(dq);
        System.out.println(dq.size());
        System.out.println(dq.peekLast());
        System.out.println(dq.pollLast());
        System.out.println(dq);
        System.out.println(dq.size());
        System.out.println(dq.pollFirst());
        System.out.println(dq.pollLast()); //returns null
        dq.clear();
        System.out.println(dq.size());
    }   
}