package DynamicProgramming;

public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] nums = {7,2,5,1,6,3,4};
        System.out.println("Max Profit doing Multiple Transactions : " + maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int maxHere = 0;
        int maxProfit = 0;
        int previousMax = 0;
        int maxSoFar = 0;
        for(int i = 1; i < length; ++i) {
            previousMax = maxHere;
            maxHere = Math.max(0, maxHere + prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxSoFar, maxHere);
            if(maxHere < previousMax) {
                maxProfit += maxSoFar;
                maxHere = 0;
                maxSoFar = 0;
            }
        }
        return maxProfit + maxSoFar;
    }
}
