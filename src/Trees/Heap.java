package Trees;

import java.util.Arrays;

public class Heap {

    DataNode[] heapArray;
    int size;
    int count = 0;
    public Heap(int[] array) {
        heapArray = new DataNode[array.length];
        size = array.length;
        putNumbersToHeap(array);
    }

    public void insert(int index, int value) {
        heapArray[index].key = value;
        count++;
    }

    public void putNumbersToHeap(int[] nums) {
        for(int i = 0; i < size; ++i) {
            heapArray[i] = new DataNode(0);
            insert(i, nums[i]);
        }
    }

    public void heapify(int index) {
        int largest = 0;
        DataNode root = heapArray[index];

        while(index < size / 2) {
            int left = 2 * index + 1;
            int right = left + 1;

            //convert > to < to make it as minHeap.
            if(right < size && heapArray[right].key > heapArray[left].key) {
                largest = right;
            } else {
                largest = left;
            }

            //convert >= to <= to make it as minHeap.
            if(root.key >= heapArray[largest].key) {
                break;
            }

            heapArray[index] = heapArray[largest];
            index = largest;

            printTree2(3);

        }
        heapArray[index] = root;
        printTree2(3);
        return;
    }

    public void heapSort() {
        for(int i = size - 1; i >= 0; --i) {
            DataNode largest = heapArray[0];
            heapArray[0] = heapArray[i];
            heapArray[i] = largest;
            size--;
            printTree2(3);
            heapify(0);
        }
        return;
    }

    public int[] reverseArray(int[] theArray) {
        // Index of the first element
        int leftIndex = 0;

        // Index of last element
        int rightIndex = theArray.length - 1;

        while (leftIndex < rightIndex) {
            // Exchange the left and right elements

            int temp = theArray[leftIndex];
            theArray[leftIndex] = theArray[rightIndex];
            theArray[rightIndex] = temp;

            // Move the indexes to check towards the middle
            leftIndex++;
            rightIndex--;        
        }
        return theArray;
    }

    public int[] getIndentArray(int rows) {
        int[] indentArray = new int[rows];
        for (int i = 0; i < rows; i++) {
            indentArray[i] = (int) Math.abs((-2 + (Math.pow(2, i + 1))));
        }

        Arrays.sort(indentArray);
        indentArray = reverseArray(indentArray);
        return indentArray;
    }

    public void printTree2(int rows) {
        // Number of spaces between items in tree
        int spaces = 0;
        int iteration = 1;

        // Generate all of the indents that are
        // needed depending on the number of rows
        // to print

        int[] indent = getIndentArray(rows);

        while (iteration <= rows) {
            // Find first Index : .5 * (-2 + 2^n)
            int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));

            // Number of Items per Row : 2^(n - 1)
            int itemsPerRow = (int) (Math.pow(2, iteration - 1));
            int maxIndexToPrint = indexToPrint + itemsPerRow;

            // Print the indents needed
            for (int j = 0; j < indent[iteration - 1]; j++)
                System.out.print(" ");

            // Print all of the index values for each row
            // indexToPrint represents the first index in the
            // row, while maxIndexToPrint equals the last

            for (int l = indexToPrint; l < maxIndexToPrint; l++) {

                // If the array isn't full don't try to print
                // indexes that don't exist

                if (l < count) {
                    System.out.print(String.format("%02d", heapArray[l].key));
                    for (int k = 0; k < spaces; k++)
                        System.out.print(" ");
                }
            }

            // In a tree the spaces get bigger in the
            // same way that indents get smaller

            spaces = indent[iteration - 1];
            iteration++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {17,14,12,18,19};
        Heap heap = new Heap(nums);
        System.out.println("The Heap is := " + Arrays.toString(heap.heapArray));
        heap.printTree2(3);

        System.out.println("Heapifying the heap");
        for(int i = heap.size / 2 - 1; i >= 0; --i) {
            heap.heapify(i);
        }

        System.out.println("The Heap after heapifying is := " + Arrays.toString(heap.heapArray));
        heap.printTree2(3);

        System.out.println("The original Array is := " + Arrays.toString(nums));
        System.out.println("HeapSort the heap");

        heap.heapSort();
        System.out.println("The Heap is after heapSort or minHeap:= " + Arrays.toString(heap.heapArray));
        heap.printTree2(3);
    }
}

class DataNode {
    int key;
    public DataNode(int key) {
        this.key = key;
    }

    public String toString() {
        return String.valueOf(key);
    }
}
