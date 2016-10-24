package DynamicProgramming;

public class BestTimeToBuyAndSellStock4 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6,4,2,4,2,7,1,6,3,4};
        int k = 2;
        System.out.println("Maximum profit with 2 transactions is : " + maxProfit(k, nums));
    }


    public static int maxProfit(int k, int[] prices) {
        if(prices.length == 0) {
            return 0;
        }

        if(k >= prices.length/2){
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i-1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int trans = k;
        int dp[][] = new int[trans + 1][prices.length];

        for(int i = 1; i <= trans; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j < prices.length; j++) {
                min = Math.min(min, prices[j - 1] - dp[i - 1][j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
            }
        }
        return dp[trans][prices.length - 1];       
    }
}
