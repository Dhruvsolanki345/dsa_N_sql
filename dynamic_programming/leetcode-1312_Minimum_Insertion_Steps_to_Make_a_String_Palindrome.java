// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

class Solution {
    public int minInsertions(String s) {
        if(s.length() <= 1) return 0;
        
        return s.length() - lcs(s);
    }
    
    // longest palindromic subsequence length using longest common subsequence length
    private int lcs(String s) {
        String s2 = reverse(s);
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][n];
    }
    
    private String reverse(String s) {
        char[] rev = new char[s.length()];
        int i = 0, j = s.length() - 1;
        
        while(i <= j) {
            rev[i] = s.charAt(j);
            rev[j] = s.charAt(i);
            i++; j--;
        }
        
        return new String(rev);
    }
}
