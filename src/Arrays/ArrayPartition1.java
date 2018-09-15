package Arrays;

public class ArrayPartition1 {
  
  public static void main(String[] args) {
    int[] nums = {1, 3, 3, 1, 1};
    System.out.println("The array partition sum is := " + new ArrayPartition1().arrayPairSum(nums));
  }

  public int arrayPairSum(int[] nums) {
    int[] arr = new int[7];
    int lim = 3;
    for (int num: nums)
      arr[num + lim]++;
    int d = 0, sum = 0;
    for (int i = -3; i <= 3; i++) {
      sum += (arr[i + lim] + 1 - d) / 2 * i;
      d = (2 + arr[i + lim] - d) % 2;
    }
    return sum;
  }
}
