// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int curr = prices[0], max = 0;
        
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < curr) {
                curr = prices[i];
                continue;
            }
            
            if(prices[i] - curr > max) max = prices[i] - curr;
        }
        
        return max;
    }
}
