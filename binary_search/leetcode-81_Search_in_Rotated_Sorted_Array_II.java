// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length, low = 0, high = n - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(target == nums[mid]) return true;
            
            if(nums[low] == nums[mid]) {
                low++;
                continue;
            }
            
            boolean pivotArray = existsInFirst(nums, low, nums[mid]);

            boolean targetArray = existsInFirst(nums, low, target);
            
            if (pivotArray ^ targetArray) { 
                if (pivotArray) {
                    low = mid + 1; 
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
    
    private boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }
}
