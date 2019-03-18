package Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BestRotation {
	public static void main(String[] args) {
		BestRotation rotation = new BestRotation();
		int[] n = {2, 3, 1, 4, 0};
		System.out.println("The best rotation to maximize the score is := " + rotation.bestRotation(n));
	}

	public int bestRotation(int[] n) {
		List<Integer> nums = Arrays.stream(n).boxed().collect(Collectors.toList());
		int maxScore = score(nums), cur = 1, k = 1, head = 0, curScore;

		while (cur < nums.size()) {
			head = nums.get(0);
			nums.remove(0);
			nums.add(head);
			curScore = score(nums);
			if (curScore > maxScore) {
				k = cur;
				maxScore = curScore;
			}
			cur++;
		}
		return k;
	}

	private int score(List<Integer> nums) {
		int total = 0;
		for (int i = 0; i < nums.size(); ++i) {
			if (nums.get(i) <= i) total++;
		}
		return total;
	}
}
