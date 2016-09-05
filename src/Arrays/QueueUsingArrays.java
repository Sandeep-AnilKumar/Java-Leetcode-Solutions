package Arrays;

import java.util.Arrays;

public class QueueUsingArrays<T> {
    private int INITIAL_CAPACITY = 5;
    private int size;
    private T[] queue;
    private int last;

    public QueueUsingArrays() {
        createNewArray();
        size = 0;
    }

    public void createNewArray() {
        queue = (T[]) new Object[INITIAL_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        createNewArray();
        size = 0;
        last = 0;
    }

    public void offer(T val) {
        if(size == INITIAL_CAPACITY) {
            resize();
        }

        queue[last++] = val;
        size++;
    }

    public T peek() {
        if(size == 0) {
            return null;
        }
        return queue[0];
    }

    public T poll() {
        if(size == 0) {
            return null;
        }

        T cur = queue[0];
        for(int i = 0; i <= last; ++i) {
            queue[i] = queue[i+1];
        }
        size--;
        last--;
        return cur;
    }

    public void resize() {
        queue = Arrays.copyOf(queue, INITIAL_CAPACITY*2);
        this.INITIAL_CAPACITY *= 2;
    }

    @Override
    public String toString() {
        if(size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < INITIAL_CAPACITY - 1; ++i) {
            sb.append(queue[i] + "<-");
        }
        sb.append(queue[INITIAL_CAPACITY - 1] + "]");
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueUsingArrays<Integer> q = new QueueUsingArrays<>();
        System.out.println(q);
        System.out.println(q.poll()); //returns null
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        q.offer(1);
        q.offer(10);
        q.offer(100);
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.poll()); //1 is polled
        System.out.println(q.size());
        System.out.println(q.poll()); //10 is polled
        System.out.println(q);
        q.offer(1000);
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
        System.out.println(q.poll());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.poll()); //1000 is polled
        System.out.println(q); //Queue is empty.
        q.offer(1);
        q.offer(10);
        q.offer(100);
        q.offer(1000);
        q.offer(10000);
        System.out.println(q);
        q.offer(100000); //resized.
        System.out.println(q);
        q.offer(11);
        q.offer(121);
        q.offer(1331);
        q.offer(14341);
        System.out.println(q);
        q.offer(12);//again resized.
        System.out.println(q);
    }
}
