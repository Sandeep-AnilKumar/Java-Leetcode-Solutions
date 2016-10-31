package DynamicProgramming;

public class BestTimeToBuyAndSellStockCooldown {

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,1,4,2,1};
        System.out.println("Total profit with a cooldown : " + maxProfit(nums)); 
    }
    
    //buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]) //because of cool down.
    //sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i])
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
        int length = prices.length;
        for(int i = 0; i < length; ++i) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
}
