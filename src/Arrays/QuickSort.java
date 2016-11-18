package Arrays;

public class QuickSort {
    static int[] array = {5,3,-4,9,-9,2,4,-2};
    public static void main(String[] args) {
        System.out.println("Quick Sort Start");
        quickSort(array, 0, array.length-1);
        printArray();
        System.out.println("\nQuick Sort End");
    }

    private static void printArray() {
        for(int i : array){
            System.out.print(i+" ");
        }
    }

    public static void quickSort(int[]A, int low, int high){
        int pivot;
        if(high>low) {
            pivot = partition(A,low,high);
            quickSort(A, low, pivot-1);
            quickSort(A, pivot+1, high);
        }
    }

    private static int partition(int[] A, int low, int high) {
        int left, right, pivot_item = 0;
        left = low;
        right = high;
        while(left<right) {
            while(A[left]<=pivot_item)
                left++;
            while(A[right]>pivot_item)
                right--;
            if(left<right)
                swap(A,left,right);
        }
        A[low] = A[right];
        A[right] = pivot_item;
        return right;
    }

    private static void swap(int[]A, int left, int right){
        int temp = 0;
        temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}