package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindShortestSubarray {
  public static int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> left = new HashMap(),
            right = new HashMap(), count = new HashMap();

    for (int i = 0; i < nums.length; i++) {
      int x = nums[i];
      if (left.get(x) == null) left.put(x, i);
      right.put(x, i);
      count.put(x, count.getOrDefault(x, 0) + 1);
    }

    int ans = nums.length;
    int degree = Collections.max(count.values());
    for (int x: count.keySet()) {
      if (count.get(x) == degree) {
        ans = Math.min(ans, right.get(x) - left.get(x) + 1);
      }
    }
    return ans;
  }
  public static int findShortestSubArrayBetter(int[] nums) {
    Item[] items = new Item[50000];
//    Arrays.fill(items, new Item(-1, 0));
    Item item;
    for (int i = 0; i < nums.length; ++i) {
      if (items[nums[i]] == null) {
        items[nums[i]] = new Item(nums[i], i);
      }
      item = items[nums[i]];
      item.highIndex = i;
      item.count++;
    }
    Arrays.sort(items);
    return items[0].highIndex - items[0].lowIndex + 1;
  }

  static class Item implements Comparable<Item> {
    int key;
    int count;
    int lowIndex;
    int highIndex;

    public Item(int key, int lowIndex) {
      this.key = key;
      count = 0;
      highIndex = 0;
      this.lowIndex = lowIndex;
    }

    @Override
    public int compareTo(Item other) {
      if (other == null) return -1; 
      if (this.count == other.count) {
        return (this.highIndex - this.lowIndex) - (other.highIndex - other.lowIndex);
      }
      return other.count - this.count;
    }
  }

  public static void main(String[] args) {
    int[] nums = {2, 3, 2, 1, 1};
    System.out.println(FindShortestSubarray.findShortestSubArrayBetter(nums));
  }
}
