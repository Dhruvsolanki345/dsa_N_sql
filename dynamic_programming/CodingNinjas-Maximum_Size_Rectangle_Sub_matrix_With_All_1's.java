// https://www.codingninjas.com/codestudio/problems/maximum-size-rectangle-sub-matrix-with-all-1-s_893017?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

import java.util.*;

public class Solution {
    public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
        int max = 0;
        int[] height = new int[m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) height[j]++;
                else height[j] = 0;
            }
            int area = largestRectangleArea(height);
            max = Math.max(max, area);
        }
        
        return max;
    }
    
    private static int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i <= n; i++) {
            while(!stack.isEmpty() && (i==n || heights[stack.peek()] >= heights[i])) {
                int h = heights[stack.pop()];
                int width;
                if(stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;
                max = Math.max(max, width*h);
            }
            stack.push(i);
        }
        
        return max;
    }
}
