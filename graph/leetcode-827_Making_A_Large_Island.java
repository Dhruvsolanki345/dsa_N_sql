// https://leetcode.com/problems/making-a-large-island/

// reference:
// https://www.youtube.com/watch?v=_426VVOB8Vo&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=21

class Solution {
    int[][] grid;
    int m, n;
    
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length; 
        
        Map<Integer, Integer> map = new HashMap<>();
        int islandId = 2, max = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 1) continue;
                
                int area = dfs(i, j, islandId);

                max = Math.max(max, area);
                map.put(islandId, area);
                islandId++;
            }
        }
        
        Set<Integer> set = new HashSet<>();
        int[] offset = {0, 1, 0, -1, 0};
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) continue;
                
                int area = 1;
                
                for(int k = 0; k < 4; k++) {
                    int r = i + offset[k], c = j + offset[k+1];
                    
                    if(r < 0 || r >= m || c < 0 || c >= n || 
                         grid[r][c] == 0 || set.contains(grid[r][c])) {
                        continue;
                    }
                        
                    area += map.get(grid[r][c]);
                    set.add(grid[r][c]);
                }
                
                set.clear();
                max = Math.max(max, area);
            }
        }
        
        return max;
    }
    
    private int dfs(int i, int j, int islandId) {
        grid[i][j] = islandId;
        
        int area = 1;
        
        if(i-1 >= 0 && grid[i-1][j] == 1) area += dfs(i-1, j, islandId);
        if(i+1 < m && grid[i+1][j] == 1) area += dfs(i+1, j, islandId);
        if(j-1 >= 0 && grid[i][j-1] == 1) area += dfs(i, j-1, islandId);
        if(j+1 < n && grid[i][j+1] == 1) area += dfs(i, j+1, islandId);
        
        return area;        
    }
}
