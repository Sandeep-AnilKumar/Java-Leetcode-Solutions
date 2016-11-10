package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class VerifyPreorderInBST {

    public static void main(String[] args) {
        int[] preorder = {11,7,6,5,12,13,10};
        System.out.println("Is preorder valid ?= " + verifyPreorder(preorder));
    }

    public static boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Deque<Integer> path = new ArrayDeque<>();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.isEmpty() && p > path.peekLast())
                low = path.pollLast();
            path.offerLast(p);
        }
        return true;
    }

    public static boolean verifyPreorderRecursive(int[] preorder) {
        return verify(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean verify(int[] preorder, int start, int end, int min, int max) {
        if (start > end) {
            return true;
        }
        int root = preorder[start];
        if (root > max || root < min) {
            return false;
        }

        int rightIndex = start;
        while (rightIndex <= end && preorder[rightIndex] <= root) {
            rightIndex++;
        }
        return verify(preorder, start + 1, rightIndex - 1, min, root) && verify(preorder, rightIndex, end, root, max);
    }
}
