// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

class Solution {
    int[][] matrix, dp;
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n= matrix[0].length;
        dp = new int[m][n];
        int longest = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] != 0) continue;
                
                longest = Math.max(longest, bfs(i, j));
            }
        }
        
        return longest;
    }
    
    private int bfs(int i, int j) {
        if(dp[i][j] != 0) return dp[i][j];
        
        int max = 0, curr = matrix[i][j];
        
        if(i-1 > -1 && matrix[i-1][j] > curr) max = bfs(i-1, j);
        if(i+1 < m && matrix[i+1][j] > curr) max = Math.max(max, bfs(i+1, j));
        if(j-1 > -1 && matrix[i][j-1] > curr) max = Math.max(max, bfs(i, j-1));
        if(j+1 < n && matrix[i][j+1] > curr) max = Math.max(max, bfs(i, j+1));
        
        return dp[i][j] = max + 1;
    }
}
