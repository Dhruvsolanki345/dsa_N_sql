// https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int count = 0;
        
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax) leftMax = height[left];
                else count += leftMax - height[left];
                
                left++;
            } else {
                if(height[right] >= rightMax) rightMax = height[right];
                else count += rightMax - height[right];
                
                right--;
            }
        }
        
        return count;
    }
}
