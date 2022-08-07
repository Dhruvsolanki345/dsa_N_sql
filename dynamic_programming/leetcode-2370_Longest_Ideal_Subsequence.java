// https://leetcode.com/problems/longest-ideal-subsequence/

class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[150];
        int res = 0;
        
        for(int c = 0; c < s.length(); c++) {
            int i = s.charAt(c);
            for(int j = i - k; j <= i + k; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
            res = Math.max(res, ++dp[i]);
        }
        
        return res;
    }
}
