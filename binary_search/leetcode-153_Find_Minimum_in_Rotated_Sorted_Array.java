// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE;
        int low = 0, high = n - 1;
        
        while(low <= high) {
            if(nums[low] < nums[high]) {
                min = Math.min(min, nums[low]);
                return min;
            }
            
            int mid = low + (high - low) / 2;
            
            if(nums[low] <= nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        
        return min;
    }
}
