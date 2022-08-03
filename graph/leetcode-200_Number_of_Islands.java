// https://leetcode.com/problems/number-of-islands/

// Follow up question: Count the number of Islands efficiently if the matrix is super large and sparse
// https://leetcode.com/problems/number-of-islands/discuss/223373/Follow-up-question%3A-Count-the-number-of-Islands-efficiently-if-the-matrix-is-super-large-and-sparse

// DFS
class Solution {
    char[][] grid;
    int m, n;
    int[] offset;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        offset = new int[]{0, 1, 0, -1, 0};
        
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    eraseIsland(i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void eraseIsland(int i, int j) {
        grid[i][j] = '0';
        
        for(int k = 0; k < 4; k++) {
            int r = i + offset[k], c = j + offset[k+1];
            
            if(r < m && r >= 0 && c < n && c >= 0 && grid[r][c] == '1') {
                eraseIsland(r, c);
            }
        }
        
    }
}
