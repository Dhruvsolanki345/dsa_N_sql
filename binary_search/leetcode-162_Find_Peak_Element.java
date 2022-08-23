// https://leetcode.com/problems/find-peak-element/

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length, low = 0, high = n - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            boolean isValid = true;
            if(mid-1 >= 0) isValid &= nums[mid-1] < nums[mid];
            if(mid+1 < n) isValid &= nums[mid+1] < nums[mid];
            
            if(isValid) return mid;
            else if(mid-1 >= 0 && nums[mid-1] > nums[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        return -1;
    }
}
