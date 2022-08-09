// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        
        if(nums.length == 0) return res;
        
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(mid == 0 && nums[mid] == target) {
                res[0] = mid;
                break;
            }
                        
            if(nums[mid] == target && nums[mid-1] != target) {
                res[0] = mid;
                break;
            } else if(nums[mid] >= target) high = mid - 1;
            else low = mid + 1;
        }
        
        low = 0;
        high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(mid == nums.length-1 && nums[mid] == target) {
                res[1] = mid;
                break;
            }
            
            if(nums[mid] == target && nums[mid+1] != target) {
                res[1] = mid;
                break;
            } else if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        
        return res;
    }
}
