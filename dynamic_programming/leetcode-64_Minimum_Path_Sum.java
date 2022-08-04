// https://leetcode.com/problems/minimum-path-sum/

// Memoization
class Solution {
    int m, n;
    int[][] grid;
    
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        
        if(m == 1 && n == 1) return grid[0][0];
        
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++) 
                dp[i][j] = -1;        
        
        return minSum(m-1, n-1, dp);
    }
    
    private int minSum(int i, int j, int[][] dp) {
        if(i == 0 && j == 0) return dp[0][0] = grid[i][j];
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int min = (int) 1e9;
        
        if(i-1 > -1) min = minSum(i-1, j, dp);
        if(j-1 > -1) min = Math.min(min, minSum(i, j-1, dp));
        
        return dp[i][j] = min + grid[i][j]; 
    }
}

// Tabulation
class Solution {    
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        if(m == 1 && n == 1) return grid[0][0];
        
        int[] prev = new int[n], curr = new int[n]; 
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int min = (int) 1e9;
                
                if(i-1 > -1) min = prev[j];
                if(j-1 > -1) min = Math.min(min, curr[j-1]);
                
                curr[j] = (min >= 1e9) ? grid[i][j] : min + grid[i][j];
            }
            prev = curr;
        }
        
        return prev[n-1];
    }
}

// Without extra space i.e. modifing input for storage
class Solution {    
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        if(m == 1 && n == 1) return grid[0][0];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int min = (int) 1e9;
                
                if(i-1 > -1) min = grid[i-1][j];
                if(j-1 > -1) min = Math.min(min, grid[i][j-1]);
                
                grid[i][j] += (min >= 1e9) ? 0 : min;
            }
        }
        
        return grid[m-1][n-1];
    }
}
