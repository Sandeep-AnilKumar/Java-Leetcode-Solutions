package Arrays;

public class MergeSortedArraysSOlution {

    public static void main(String[] args) {
        int nums1[] = new int[]{1,2,3,4,5,0,0,0,0,0};
        int nums2[] = new int[]{3,8,9,10,11};
        int mergedArray[] = mergeSortedArrays(nums1, 5, nums2, 5);
        for(int i : mergedArray) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m + n - 1;
        while(i >=0 && j >= 0) {
            nums1[k--] = (nums1[i] < nums2[j] ? nums2[j--] : nums1[i--]);
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--]; 
        }
        return nums1;
    }
}
