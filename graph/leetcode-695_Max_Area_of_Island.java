// https://leetcode.com/problems/max-area-of-island/
class Solution {
    int[][] grid;
    int m, n;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        
        int max = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, findArea(i, j));
                }
            }
        }
        
        return max;
    }
    
    private int findArea(int i, int j) {
        grid[i][j] = 0;
        
        int area = 1;
        
        if(i-1 >= 0 && grid[i-1][j] == 1) area += findArea(i-1, j);
        if(i+1 < m && grid[i+1][j] == 1) area += findArea(i+1, j);
        if(j-1 >= 0 && grid[i][j-1] == 1) area += findArea(i, j-1);
        if(j+1 < n && grid[i][j+1] == 1) area += findArea(i, j+1);
        
        return area;
    }
}
