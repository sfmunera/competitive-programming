package leetcode;

public class LC121_BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        int curmax = Integer.MIN_VALUE;   
        int curmin = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < curmin) {
                curmin = prices[i];
                curmax = curmin;
            } else if (prices[i] > curmax) {
                curmax = prices[i];
                if (maxprofit < curmax - curmin) {
                    maxprofit = curmax - curmin;
                }
            }
        }

        return maxprofit;
    }
}
