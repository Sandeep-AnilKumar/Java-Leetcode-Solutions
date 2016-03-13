import java.util.Scanner;

public class QuickSort {
	static int[] Array = {5,3,1,9,8,2,4,7};
	public static void main(String[] args) {
		System.out.println("Quick Sort Start");
		quickSort(Array, 0, Array.length-1);
		printArray();
		System.out.println("\nQuick Sort End");
	}

	private static void printArray() {
		for(int i : Array){
			System.out.print(i+" ");
		}
	}

	public static void quickSort(int[]A, int low, int high){
		int pivot;
		if(high>low)
		{
			pivot = partition(A,low,high);
			quickSort(A, low, pivot-1);
			quickSort(A, pivot+1, high);
		}
	}

	private static int partition(int[] A, int low, int high) {
		int left, right, pivot_item = A[low];
		left = low;
		right = high;
		while(left<right)
		{
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
