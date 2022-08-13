// https://www.codingninjas.com/codestudio/problems/problem-name-boolean-evaluation_1214650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

import java.util.*;

public class Solution {
    static final int mod = (int) 1e9 + 7;
    
    public static int evaluateExp(String exp) {
        int n = exp.length();
        int[][][] dp = new int[n+1][n+1][3];
        
        for(int[][] child: dp)
            for(int[] innerChild: child)
                Arrays.fill(innerChild, -1);
        
        return partition(0, n-1, 1, exp, dp);
    }
    
    private static int partition(int i, int j, int isTrue, String exp, int[][][] dp) {
        if(i > j) return 0;
        if(i == j) {
            if(isTrue == 1) return exp.charAt(i) == 'T' ? 1 : 0;
            else return exp.charAt(i) == 'F' ? 1 : 0;
        }
        
        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        
        int ways = 0;
        for(int k = i+1; k <= j-1; k += 2) {
            int lT = partition(i, k-1, 1, exp, dp); // true of left partition
            int lF = partition(i, k-1, 0, exp, dp); // false of left partition
            int rT = partition(k+1, j, 1, exp, dp); // true of right partition
            int rF = partition(k+1, j, 0, exp, dp); // false of right partition
            char curr = exp.charAt(k);
            
            if(curr == '&') {
                if(isTrue == 1) ways = (ways + (lT*rT) % mod) % mod;
                else ways = (ways + (lF*rT) % mod + (lT*rF) % mod + (lF*rF) % mod) % mod;
            } else if(curr == '|') {
                if(isTrue == 1) ways = (ways + (lT*rT) % mod + (lT*rF) % mod + (lF*rT) % mod) % mod;
                else ways = (ways + (lF*rF) % mod) % mod;
            } else if(curr == '^') {
                if(isTrue == 1) ways = (ways + (lT*rF) % mod + (lF*rT) % mod) % mod;
                else ways = (ways + (lT*rT) % mod + (lF*rF) % mod) % mod;
            }
        }
        
        return dp[i][j][isTrue] = ways;
    }
}
