package Arrays;

public class MaximumSubarrayDivideAndConquer {
    public int maxSubArray(int[] nums) {
        return Subarray(nums, 0 ,nums.length -1 );
    }
    
    private int Subarray(int[] A,int left, int right){
        if(left == right){return A[left];}
        int mid = left + (right - left) / 2;
        int leftSum = Subarray(A,left,mid); 
        int rightSum = Subarray(A,mid+1,right);
        int crossSum = crossSubarray(A,left,right);
        if(leftSum >= rightSum && leftSum >= crossSum) {
            return leftSum;
        }
        if(rightSum >= leftSum && rightSum >= crossSum) {
            return rightSum;
        }
        return crossSum;
    }
    private int crossSubarray(int[] A,int left,int right){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = left + (right - left) / 2;
        for(int i = mid; i >= left ; i--){
            sum = sum + A[i];
            if(leftSum < sum){
                leftSum = sum;
            }
        }
        sum = 0;
        for(int j = mid + 1; j <= right; j++){
            sum = sum + A[j];
            if(rightSum < sum){
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("The maximum subarray is := " + new MaximumSubarrayDivideAndConquer().maxSubArray(nums));
    }
}
