package Arrays;

import java.util.Random;

public class ShuffleAnArray {

    private int[] original = null;
    private int[] shuffled = null;
    private Random rd = null;
    private int length = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println("\nThe Original Array is: ");
        for(int num : nums) {
            System.out.print(num + " ");
        }

        ShuffleAnArray shuffler = new ShuffleAnArray(nums);
        int[] shuffledArray = shuffler.shuffle();

        System.out.println("\nThe Shuffled Array is: ");
        for(int num : shuffledArray) {
            System.out.print(num + " ");
        }

        int[] resetArray = shuffler.reset();

        System.out.println("\nThe Reset Array is: ");
        for(int num : resetArray) {
            System.out.print(num + " ");
        }

    }

    public ShuffleAnArray(int[] nums) {
        if(nums != null && nums.length != 0) {
            length = nums.length;
            original = new int[length];
            for(int i = 0; i < length; ++i) {
                original[i] = nums[i];
                rd = new Random(System.currentTimeMillis());
            }
        }
    }

    public int[] shuffle() {
        if(length == 0) {
            return null;
        }
        shuffled = new int[length];
        for(int i = 0; i < length; ++i) {
            shuffled[i] = original[i];
        }

        int temp, rdNum;

        for(int i = 1; i < length; ++i) {
            rdNum = rd.nextInt(i+1); // generate a random number between 0 and i;
            temp = shuffled[rdNum];
            shuffled[rdNum] = shuffled[i];
            shuffled[i] = temp;
        }
        return shuffled;
    }

    public int[] reset() {
        return original;
    }
}
