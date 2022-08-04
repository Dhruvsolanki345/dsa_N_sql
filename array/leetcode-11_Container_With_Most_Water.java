// https://leetcode.com/problems/container-with-most-water/

// Topic: Two Pointer

class Solution {
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        
        while(left < right) {
            int width = right - left;
            int currHeight = height[left];
            
            if(height[right] == currHeight) {
                left++;
                right--;
            } else if(height[right] < currHeight) {
                currHeight = height[right];
                right--;
            } else {
                left++;
            }
            
            max = Math.max(max, width * currHeight);
        }
        
        return max;
    }
}
