// https://www.codingninjas.com/codestudio/problems/distinct-island_630460?leftPanelTab=0
import java.util.*;

public class Solution {
    
    public static int distinctIsland(int [][] arr, int n, int m)  {
        Set<String> paths = new HashSet<>();
        int count = 0;
        String[] path = new String[1];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    path[0] = "S";
                    eraseIsland(i, j, path, arr, n, m);
                    if(!paths.contains(path[0])) count++;
                    paths.add(path[0]);
                }
            }
        }
        
        return count;
    }
    
    private static void eraseIsland(int i, int j, String[] path, int[][] grid, int n, int m) {
        grid[i][j] = 0;
        
        if(i-1 >= 0 && grid[i-1][j] == 1) {
            path[0] += "U";
            eraseIsland(i-1, j, path, grid, n, m);
            path[0] += "B";
        }
        if(i+1 < n && grid[i+1][j] == 1) {
            path[0] += "D";
            eraseIsland(i+1, j, path, grid, n, m);
            path[0] += "B";
        }
        if(j-1 >= 0 && grid[i][j-1] == 1) {
            path[0] += "L";
            eraseIsland(i, j-1, path, grid, n, m);
            path[0] += "B";
        }
        if(j+1 < m && grid[i][j+1] == 1) {
            path[0] += "R";
            eraseIsland(i, j+1, path, grid, n, m);
            path[0] += "B";
        }
    }
}
