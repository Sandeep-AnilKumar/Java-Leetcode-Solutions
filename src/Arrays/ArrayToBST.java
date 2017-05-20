package Arrays;

import Trees.TreeNode;

public class ArrayToBST {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		TreeNode root = arrayToMinimalBST(nums);
		System.out.println(root);
	}

	public static TreeNode arrayToMinimalBST(int[] nums) {
		if(nums == null || nums.length == 0) {
			return null;
		}

		return arrayToMinimalBST(nums, 0, nums.length - 1);
	}

	public static TreeNode arrayToMinimalBST(int[] nums, int start, int end) {
		if(end < start) {
			return null;
		}

		int mid = start + ((end - start) >>> 1);
		TreeNode cur = new TreeNode(nums[mid]);
		cur.left = arrayToMinimalBST(nums, start, mid - 1);
		cur.right = arrayToMinimalBST(nums, mid + 1, end);
		return cur;
	}
}
