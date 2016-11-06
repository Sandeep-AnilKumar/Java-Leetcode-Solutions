package Arrays;

/*Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]*/

public class MinMoves {

    public static void main(String[] args) {
        int[] n = {1,2,3};
        System.out.println("Min moves to equal array elements is :" + minMoves(n));
    }

    public static int minMoves(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int length = nums.length;
        for(int i = 0; i < length; ++i) {
            min = Math.min(min, nums[i]);
        }

        int sum = 0;
        for(int i = 0; i < length; ++i) {
            sum += nums[i] - min;
        }
        return sum;
    }
}
