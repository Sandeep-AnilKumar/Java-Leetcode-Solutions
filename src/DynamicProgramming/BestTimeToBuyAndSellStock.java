package DynamicProgramming;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] nums = {7,1,5,6,3,4};
        int[] diff = {0,-6,4,1,-3,1};

        //Kadane's Algorithm
        int maxHere = 0, maxSoFar = 0;
        for(int i : nums) {
            maxHere = Math.max(0, maxHere + i);
            maxSoFar = Math.max(maxSoFar, maxHere);
        }
        System.out.println("Max So Far : " + maxSoFar);
        System.out.println("Max Ending Here : " + maxHere);

        System.out.println("Maximum Profit Buying and Selling the Stock : " + buySellStock(diff));

    }

    public static int buySellStock(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int maxEndingHere = 0, maxSoFar = 0;
        int length = prices.length;
        for(int i = 1; i < length; ++i) {
            maxEndingHere = Math.max(0, maxEndingHere + prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
