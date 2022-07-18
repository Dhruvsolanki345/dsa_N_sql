// https://leetcode.com/problems/max-consecutive-ones/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0, prev = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){ 
                if(prev != 1) count = 1;
                else count++;

                max = Math.max(max, count);
            }
            prev = nums[i];
        }
        
        return max;
    }
}
