// https://leetcode.com/problems/sort-the-matrix-diagonally/

// Using pre defined sorting function
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        
        for(int j = 0; j < m; j++) {
            sort(0, j, mat, n, m);
        }
        
        for(int i = 1; i < n; i++) {
            sort(i, 0, mat, n, m);
        }
        
        return mat;
    }
    
    private void sort(int row, int col, int[][] mat, int n, int m) {
        List<Integer> sorted = new ArrayList<>();
        int r = row, c = col;
        
        while(r < n && c < m) {
            sorted.add(mat[r++][c++]);
        }
        
        Collections.sort(sorted);
        
        int i = 0;
        r = row; c = col;
        while(r < n && c < m) {
            mat[r++][c++] = sorted.get(i++);
        }
    }
}

// Using count sort as constraints is '1 <= mat[i][j] <= 100'
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        
        for(int j = 0; j < m; j++) {
            sort(0, j, mat, n, m);
        }
        
        for(int i = 1; i < n; i++) {
            sort(i, 0, mat, n, m);
        }
        
        return mat;
    }
    
    private void sort(int row, int col, int[][] mat, int n, int m) {
        int[] counts = new int[101];
        int r = row, c = col;
        
        while(r < n && c < m) {
            counts[mat[r++][c++]]++;
        }
        
        r = row; c = col;
        
        for(int i = 0; i < 101; i++) {
            if(counts[i] == 0) continue;
            
            int count = counts[i];
            while(count-- > 0) {
                mat[r++][c++] = i;
            }
        }
    }
}
