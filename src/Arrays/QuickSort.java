package Arrays;

public class QuickSort {
	static int[] array = {5, 5, 5, 5, 6, 5};
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
		if(high > low) {
			pivot = partition(A,low,high);
			quickSort(A, low, pivot - 1);
			quickSort(A, pivot + 1, high);
		}
	}

	private static int partition(int[] A, int low, int high) {
		int left, right, pivot = A[low];
		left = low;
		right = high;
		while(left < right) {
			while(A[left] <= pivot)
				left++;
			while(A[right] > pivot)
				right--;
			if(left < right)
				swap(A,left,right);
		}
		A[low] = A[right];
		A[right] = pivot;
		return right;
	}

	private static void swap(int[]A, int left, int right){
		if(left != right) {
			A[left] = A[left] ^ A[right];
			A[right] = A[left] ^ A[right];
			A[left] = A[left] ^ A[right];
		}
	}
}