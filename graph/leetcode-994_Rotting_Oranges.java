// https://leetcode.com/problems/rotting-oranges/

class Solution {
    final int[] offset = {0, 1, 0, -1, 0};
    
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh = 0, minute = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) q.add(i*n + j);
                else if(grid[i][j] == 1) fresh++;
            }
        }
        
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int pos = q.poll();
                int r = pos / n, c = pos % n;
                
                for(int k = 0; k < 4; k++) {
                    int x = r + offset[k], y = c + offset[k+1];
                    
                    if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) continue;
                    
                    grid[x][y] = 2;
                    q.add(x*n + y);
                    fresh--;
                }
            }
            minute++;
        }
        
        return fresh > 0 ? -1 : minute;
    }
}
