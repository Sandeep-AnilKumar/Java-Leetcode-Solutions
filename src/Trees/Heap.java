package Trees;

import java.util.HashSet;
import java.util.Set;

public class Heap {

    DataNode[] heapArray;
    int size;
    public Heap(int[] array) {
        heapArray = new DataNode[array.length];
        size = array.length;
    }

    public void heapify() {
        DataNode root = null;
        int left = 0;
        int right = 0;
        DataNode leftNode = null;
        DataNode rightNode = null;
        int lower = 0;
        for(int i = 0; i < size / 2; ++i) {
            root = heapArray[i];
            left = 2 * i + 1;
            right = left + 1;
            
            if(right < size) {
                leftNode = heapArray[left];
                rightNode = heapArray[right];
                
                if(leftNode.key <= rightNode.key) {
                    lower = left;
                } else {
                    lower = right;
                }
                
                if(root.key > heapArray[lower].key) {
                    heapArray[i] = heapArray[lower];
                }
                
                
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums = {56,34,78,12,13,9,67,3,10};

    }




}

class DataNode {
    int key;
    public DataNode(int key) {
        this.key = key;
    }
}
