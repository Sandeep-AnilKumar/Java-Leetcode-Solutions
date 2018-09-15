package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class ContainsNearbyDuplicate {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < nums.length; ++i) {
      for (int j : queue) {
        if (j == nums[i]) return true;
      }
      if (queue.size() == k) queue.poll();
      queue.offer(nums[i]);
    }
    return false;
  }
  
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 1};
    int k = 3;
    System.out.println("Contains nearby duplicate := " + new ContainsNearbyDuplicate().containsNearbyDuplicate(nums, k));
  }
}
