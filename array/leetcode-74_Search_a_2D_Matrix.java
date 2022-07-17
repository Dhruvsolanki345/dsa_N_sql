// https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowL = matrix.length, colL = matrix[0].length;
        int left = 0, right = rowL * colL - 1;
        
        while (left <= right){
            int mid = left + (right - left) / 2;
            int i = mid / colL;
            int j = mid % colL;
            
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return false;
    }
}
