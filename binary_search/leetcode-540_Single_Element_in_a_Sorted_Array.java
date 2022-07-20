// https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(isUnique(nums, mid)) return nums[mid];
            else if(isToLeft(nums, mid)) high = mid - 1;
            else low = mid + 1;
        }
        
        return nums[0];
    }
    
    private boolean isUnique(int[] nums,int mid){
        boolean valid = true;
        
        if(mid - 1 >= 0) valid = valid && nums[mid] != nums[mid - 1];
        if(valid && mid + 1 < nums.length) valid = valid && nums[mid] != nums[mid + 1];
        
        return valid;
    }
    
    private boolean isToLeft(int[] nums, int mid){
        boolean valid = true;
        
        if(mid % 2 == 1){ // even position
            valid = nums[mid - 1] != nums[mid];
        } else {
            if(mid - 1 >= 0) valid = nums[mid] == nums[mid - 1];
        }
        
        return valid;
    }
}
