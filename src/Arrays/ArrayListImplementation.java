package Arrays;

public class ArrayListImplementation {

    static class ListNode<T> {
        private T value;

        public ListNode(T val) {
            this.value = val;
        }

        public T getValue() {
            return this.value;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.value);
            return sb.toString();
        }
    }

    static class List<T> {
        private ListNode<T>[] node;
        private int listSize;
        private int initialCapacity;

        public List(int size) {
            node = new ListNode[size];
            initialCapacity = size;
        }

        public int size() {
            return listSize;
        }

        public boolean isEmpty() {
            return listSize == 0;
        }

        public T get(int index) {
            if(index >= initialCapacity) {
                throw new ArrayIndexOutOfBoundsException();
            }

            return node[index].getValue();
        }

        public void add(T val) {
            if(listSize == initialCapacity) {
                System.out.println("No space to add a new list element");
                return;
            }

            ListNode<T> head = null;
            if(listSize == 0) {
                head = new ListNode<>(val);
                node[0] = head;
                listSize++;
                return;
            }

            ListNode<T> cur = new ListNode<>(val);
            node[listSize++] = cur;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            for(int i = 0; i < initialCapacity - 1; ++i) {
                sb.append(node[i].getValue() + ", ");
            }
            sb.append(node[initialCapacity - 1].getValue() + " ]");
            return sb.toString();
        }

        public void clear() {
            node = new ListNode[initialCapacity];
            listSize = 0;
            return;
        }

        public boolean remove(T value) {
            boolean result = false;
            for(int i = 0; i < initialCapacity; ++i) {
                if(node[i].getValue() == value) {
                    result =  remove(node[i], i);
                    if(result) {
                        listSize--;
                    }
                }
            }   
            return result;
        }

        private boolean remove(ListNode<T> toBeRemoved, int index) {
            if(index < 0 || index >= initialCapacity) {
                return false;
            }

            if(initialCapacity > 1) {
                int prevSize = initialCapacity;
                ListNode<T>[] copyNode = node;

                node = new ListNode[--initialCapacity];
                for(int i = 0; i < index; ++i) {
                    node[i] = copyNode[i];
                }

                for(int i = index + 1; i < prevSize; ++i) {
                    node[i-1] = copyNode[i];
                }
            }
            else {
                this.clear();
            }
            return true;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new List<Integer>(5);
        System.out.println(list.isEmpty());
        list.add(5);
        list.add(10);
        list.add(15);
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        System.out.println(list.size());
        list.add(20);
        System.out.println(list.size());
        list.add(25);
        System.out.println(list.get(4));
        System.out.println(list.remove(20));
        System.out.println(list.remove(45));
        System.out.println(list.remove(5));
        System.out.println(list.remove(25));
        System.out.println(list.remove(10));
        System.out.println(list.remove(15));
        //System.out.println(list.get(5)); //ArrayIndexOutOfBoundsException
        list.clear();
        System.out.println(list.size());
    }
}
