package Trees;

public class MaximumBinaryTree {

	public static void main(String[] args) {
		MaximumBinaryTree mbt = new MaximumBinaryTree();
		int[] nums = {3,2,1,6,0,5};
		System.out.println(mbt.constructMaximumBinaryTree(nums));
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums == null || nums.length == 0) {
			return null;
		}

		TreeNode root = null;

		root = constructTree(nums, 0, nums.length - 1, root, null, null);
		return root;
	}

	public TreeNode constructTree(int[] nums, int start, int end, TreeNode root, TreeNode left, TreeNode right) {
		if(start > end) {
			return root;
		}

		int index = start;
		int max = nums[start];
		for(int i = start + 1; i <= end; ++i) {
			if(nums[i] > max) {
				index = i;
				max = nums[i];
			}
		}

		root = new TreeNode(nums[index]);

		if(index > start) {
			root.left = constructTree(nums, start, index - 1, left, null, null);
		}

		if(index < end) {
			root.right = constructTree(nums, index + 1, end, right, null, null);
		}
		return root;
	}
}

