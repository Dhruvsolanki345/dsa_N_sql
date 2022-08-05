// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = nums1.length;
        int split = (nums1.length + nums2.length) / 2;
        int n1 = nums1.length, n2 = nums2.length;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            int left1 = (mid == 0) ? Integer.MIN_VALUE : nums1[mid-1];
            int left2 = (mid == split) ? Integer.MIN_VALUE : nums2[split - mid - 1];
            int right1 = (mid == n1) ? Integer.MAX_VALUE : nums1[mid];
            int right2 = (split - mid == n2) ? Integer.MAX_VALUE : nums2[split - mid];
            
            if(left1 <= right2 && left2 <= right1) {
                if((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.min(right1, right2);
                }
            } else if(left1 > right2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return 0.0;
    }
}
