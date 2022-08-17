// https://leetcode.com/problems/regular-expression-matching/

class Solution {
    String s, p;
    int n, m;
    Result dp[][];
    
    public boolean isMatch(String _s, String _p) {
        s = _s;
        p = _p;
        n = s.length();
        m = p.length();
        
        dp = new Result[n+1][m+1];
        
        return helper(0, 0);
    }
    
    private boolean helper(int i, int j) {
        if(dp[i][j] != null) return dp[i][j] == Result.TRUE;
        
        boolean res;
        
        if(j == m) {
            dp[i][j] = (i == n) ? Result.TRUE : Result.FALSE;
            return i == n;
        }
        
        boolean firstMatch = (i < n && 
                             (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        
        if(j+1 < m && p.charAt(j+1) == '*') {
            res = (helper(i, j+2) || (firstMatch && helper(i+1,j)));
        } else {
            res =firstMatch && helper(i+1, j+1);
        }
        
        dp[i][j] = res ? Result.TRUE : Result.FALSE;
        return res;
    }
}

enum Result {
    TRUE, FALSE
}
