// https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int sum = nums[0], max = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            sum += nums[i];
            
            if(sum < nums[i]) sum = nums[i];
            if(sum > max) max= sum;
        }
        
        return max;
    }
}
