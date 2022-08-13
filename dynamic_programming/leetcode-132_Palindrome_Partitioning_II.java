// https://leetcode.com/problems/palindrome-partitioning-ii/

// Memoization
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        // subtracting 1 as an extra partition is perform at the end of string
        return frontPartition(0, n, s, dp) - 1; 
    }
    
    private int frontPartition(int i, int n, String str, int[] dp) {
        if(i == n) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int min = Integer.MAX_VALUE;
        for(int k = i; k < n; k++) {
            if(isPalindrome(i, k, str)) 
                min = Math.min(min, frontPartition(k+1, n, str, dp));
        }
        
        return dp[i] = min + 1;
    }
    
    private boolean isPalindrome(int i, int j, String s) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) 
                return false;
        }
        
        return true;
    }
}

// Tabulation
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        
        for(int i = n-1; i > -1; i--) {
            dp[i] = Integer.MAX_VALUE;
            
            for(int k = i; k < n; k++) {
                if(isPalindrome(i, k, s)) 
                    dp[i] = Math.min(dp[i], 1 + dp[k+1]);
            }
        }
        
        // subtracting 1 as an extra partition is perform at the end of string
        return dp[0] - 1;
    }
    
    private boolean isPalindrome(int i, int j, String s) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) 
                return false;
        }
        
        return true;
    }
}
