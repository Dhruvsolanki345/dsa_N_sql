// https://leetcode.com/problems/largest-rectangle-in-histogram/

class Solution {
    public int largestRectangleArea(int[] heights) {
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
