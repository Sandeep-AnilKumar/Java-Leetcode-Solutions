package Arrays;

public class MaximumProudctOfThreeNumbers {
  public static int maximumProduct(int[] nums) {
    if (nums.length == 0) return 0;
    
    int range = 1000, k = 3, product = 1, left = 0, mod = 2;
    int[] countsLeft = new int[2 * range + 1];
    int[] countsRight = new int[2 * range + 1];
    int temp = 0, tempProdLeft = 1, tempProdRight = 1, right = countsRight.length - 1;
    
    for (int n : nums) {
      countsLeft[n + range]++;
      countsRight[n + range]++;
    }

    while(k > 0) {
      if(k % 2 == 1) {
        while (right >= 0) {
          if (countsRight[right] > 0) {
            product *= (right - range);
            countsRight[right]--;
            break;
          }
          right--;
        }
      }
      else {
        temp = mod;
        tempProdLeft = 1;
        tempProdRight = 1;
        while (left < countsLeft.length && temp > 0) {
          while (countsLeft[left] > 0 && temp > 0) {
            tempProdLeft *= (left - range);
            countsLeft[left]--;
            temp--;
          }
          left++;
        }
        temp = mod;
        while (right >= 0 && temp > 0) {
          while (countsRight[right] > 0 && temp > 0) {
            tempProdRight *= (right - range);
            countsRight[right]--;
            temp--;
          }
          right--;
        }

        product *= tempProdLeft > tempProdRight ? tempProdLeft : tempProdRight;
        k--;
      }
      k--;
    }
    return product;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    System.out.println(MaximumProudctOfThreeNumbers.maximumProduct(nums));
  }
}
