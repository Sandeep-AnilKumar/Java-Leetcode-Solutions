package Arrays;

public class QueueImplementation<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;
    private int size;

    private static class QueueNode<T> {
        private T val;
        private QueueNode<T> next;

        public QueueNode(T val) {
            this.val = val;
            this.next = null;
        }

        public void setNext(QueueNode<T> nextNode) {
            next = nextNode;
        }

        public QueueNode<T> getNext() {
            return next;
        }

        public T getValue() {
            return val;
        }

        @Override
        public String toString() {
            if(val == null) {
                return "null";
            }
            return val.toString();
        }

    }

    public void offer(T val) {
        QueueNode<T> cur = new QueueNode(val);
        if(size == 0) {
            cur.setNext(first);
            first = cur;
            last = cur;
            size++;
            return;
        }

        last.setNext(cur);
        last = cur;
        size++;
    }

    public T peek() {
        if(!isEmpty()) {
            return first.getValue();
        }
        else {
            return null;
        }
    }

    public QueueNode<T> poll() {
        if(isEmpty()) {
            return null;
        }

        QueueNode<T> cur = first;
        first = first.getNext();
        size--;
        return cur;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        QueueNode<T> cur = first;
        sb.append(cur.getValue() + "<-");

        while(cur.getNext() != null && !cur.equals(last)) {
            sb.append(cur.getNext().getValue() + "<-");
            cur = cur.getNext();
        }

        return sb.append("null").toString();
    }

    public static void main(String[] args) {
        QueueImplementation<Integer> q = new QueueImplementation<>();
        System.out.println(q.size());
        System.out.println(q.poll()); //returns null;
        System.out.println(q.peek()); //return null;
        System.out.println(q);
        q.offer(1);
        System.out.println(q);
        q.offer(10);
        q.offer(100);
        System.out.println(q);
        System.out.println(q.size());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q);
        System.out.println(q.size());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q);
        System.out.println(q.size());
        System.out.println(q.poll());
    }
}
