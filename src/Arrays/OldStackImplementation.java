package Arrays;

public class OldStackImplementation {

    static class Stack<T> {
        private Stack<T> next;
        private T elem;
        public Stack<T> top;

        public Stack(T value) {
            elem = value;
            next = null;
        }

        public Stack() {
        }

        public T value() {
            return elem;
        }

        public void setValue(T value) {
            elem = value;
        }

        public Stack<T> next() {
            return next;
        }

        public void setNext(Stack<T> nt) {
            next = nt;
        }

        public void push(T value) {
            Stack<T> newElem = new Stack<T>(value);
            newElem.next = this.top;
            this.top = newElem;
        }

        public T pop() {
            if(this.top == null) {
                throw new java.util.NoSuchElementException();
            }

            T value = this.top.value();
            this.top = this.top.next();
            return value;
        }

        public T peek() {
            if(this.top == null) {
                return null;
            }
            T value = this.top.value();
            return value;
        }

        public void display() {
            if(this.top == null) {
                return;
            }

            Stack<T> current = this.top;

            while(current != null) {
                System.out.println(current.value() + " ");
                current = current.next();
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(10);
        stack.push(15);
        stack.push(25);
        stack.push(45);
        stack.push(56);

        System.out.println("current stack is: -");
        stack.display();

        int popped = stack.pop();
        System.out.println("Popped element is :" + popped + ", new top is: " + stack.peek());

        popped = stack.pop();
        System.out.println("Popped element is :" + popped + ", new top is: " + stack.peek());

        int top = stack.peek();

        System.out.println("The top element is: " + top);

        System.out.println("current stack is: -");
        stack.display();
    }
}