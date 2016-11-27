package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int size;
    int capacity;
    public LeastRecentlyUsedCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
        this.capacity = capacity;
        size = 0;
    }

    public void deleteNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    public void addToTail(Node node) {
        tail.pre.next = node;
        node.next = tail;
        node.pre = tail.pre;
        tail.pre = node;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            int toReturn = node.value;
            deleteNode(node);
            addToTail(node);
            return toReturn;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToTail(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if(size < capacity) {
                addToTail(node);
                size++;
            } else {
                map.remove(head.next.key);
                deleteNode(head.next);
                addToTail(node);
            }
        }
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node pre;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}