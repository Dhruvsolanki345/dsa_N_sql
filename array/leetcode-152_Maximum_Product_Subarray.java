// https://leetcode.com/problems/maximum-product-subarray/

class Solution {
    public int maxProduct(int[] nums) {
        int left = nums[0], right = nums[0];
        int mul = 1;     
        boolean isZero = false;
        
        for(int num: nums) {
            if(num == 0) {
                isZero = true;
                mul = 1;
                continue;
            }
            
            mul *= num;
            left = Math.max(left, mul);
        }
        
        mul = 1;
        for(int i = nums.length - 1; i > -1; i--) {
            if(nums[i] == 0) {
                isZero = true;
                mul = 1;
                continue;
            }
            
            mul *= nums[i];
            right = Math.max(right, mul);
        }
        
        int res = Math.max(left, right);
        return (isZero && res < 0) ? 0 : res; 
    }
}
