package Arrays;

import java.util.TreeSet;

public class FruitBasket {
  public static int totalFruit(int[] tree) {
    if (tree == null || tree.length == 0) return 0;

    int[][] fruits = new int[2][2];
    int max = Integer.MIN_VALUE, cur = 0, toRemove = 0, range = -1;
    fruits[0][0] = range; fruits[1][0] = range;

    for (int i = 0; i < tree.length; ++i) {
      if (fruits[0][0] == range || fruits[0][0] == tree[i]) {
        fruits[0][0] = tree[i];
        fruits[0][1] = i;
        cur++;
      } else if (fruits[1][0] == range || fruits[1][0] == tree[i]) {
        fruits[1][0] = tree[i];
        fruits[1][1] = i;
        cur++;
      } else {
        cur = 1 + Math.max(fruits[0][1], fruits[1][1]) - Math.min(fruits[0][1], fruits[1][1]);
        if (fruits[0][0] == tree[i - 1]) {
          fruits[1][0] = tree[i];
          fruits[1][1] = i;
        } else {
          fruits[0][0] = tree[i];
          fruits[0][1] = i;
        }
      }
      max = Math.max(max, cur);
    }

    return max == Integer.MIN_VALUE ? 0 : max;
  }

  public static void main(String[] args) {
    int[] tree = {1, 2, 3, 1, 2, 3, 4, 5, 5, 4};
    System.out.println(FruitBasket.totalFruit(tree));
  }
}
