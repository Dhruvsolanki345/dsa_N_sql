// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, max = 1;
        int[] dp = new int[n], count = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        for(int i = 0; i < n; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(nums[i] <= nums[prev]) continue;
                
                if(dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    count[i] = count[prev];
                } else if(dp[prev] + 1 == dp[i]) {
                    count[i] += count[prev];
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        int nos = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] == max) nos += count[i];
        }
        
        return nos;
    }
}
