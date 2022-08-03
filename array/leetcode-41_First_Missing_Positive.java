// https://leetcode.com/problems/first-missing-positive/

// refrence :
// https://www.youtube.com/watch?v=9SnkdYXNIzM&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=14

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length, hasOne = 0;
        
        for(int i = 0; i < len; i++) {
            if(nums[i] == 1) hasOne = 1;
            
            nums[i] = (nums[i] <= 0 || nums[i] > len) ? 1 : nums[i];
        }
        
        if(hasOne == 0) return 1;
        
        for(int i = 0; i < len; i++) {
            int curr = nums[i] < 0 ? nums[i] * -1 : nums[i];
            
            if(nums[curr - 1] < 0) continue;
            
            nums[curr - 1] = -1 * nums[curr - 1];
        }
        
        for(int i = 0; i < len; i++) {
            if(nums[i] > 0) return i + 1;
        }
        
        return len + 1;
    }
}
