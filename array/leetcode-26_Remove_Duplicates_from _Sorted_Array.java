// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        int unique = 1, prev = nums[0];
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == prev) continue;
            
            prev = nums[i];
            nums[unique++] = nums[i];
        }
        
        return unique;
    }
}
