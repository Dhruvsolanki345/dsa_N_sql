// https://leetcode.com/problems/decode-ways/

// Optimized
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        
        int n = s.length();
        int next = 1, next2 = 0, curr = 0;
        
        for(int i = n-1; i > -1; i--) {
            curr = 0;
            if(s.charAt(i) != '0') {
            
                curr = next;

                if(i+1 < n &&(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')))
                    curr += next2;
            }
            
            next2 = next;
            next = curr;
        }
        
        return next;
    }
}

// Tabulation
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        
        for(int i = n-1; i > -1; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0; continue;
            }
            
            int count = dp[i+1];
            
            if(i+1 < n &&(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')))
                count += dp[i+2];
            
            dp[i] = count;
        }
        
        return dp[0];
    }
}

// Memoization
class Solution {
    char[] str;
    int n;
    
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        
        str = s.toCharArray();
        n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return helper(0, dp);
    }
    
    private int helper(int i, int[] dp) {
        if(i == n) return 1;
        if(str[i] == '0') return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int count = helper(i+1, dp);
        
        if(i+1 < n &&(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')))
            count += helper(i+2, dp);
        
        return dp[i] = count;
    }
}
