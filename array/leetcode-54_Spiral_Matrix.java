// https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        
        int rows = 0, rowe = matrix.length - 1;
        int cols = 0, cole = matrix[0].length - 1;
        
        while(rows <= rowe && cols <= cole) {
            for(int i = cols; i <= cole; i++) res.add(matrix[rows][i]);
            rows++;
            
            for(int i = rows; i <= rowe; i++) res.add(matrix[i][cole]);
            cole--;
            
            if(rows > rowe || cols > cole) break;
            
            for(int i = cole; i >= cols; i--) res.add(matrix[rowe][i]);
            rowe--;
            
            for(int i = rowe; i >= rows; i--) res.add(matrix[i][cols]);
            cols++;
        }
        
        return res;
    }
}
