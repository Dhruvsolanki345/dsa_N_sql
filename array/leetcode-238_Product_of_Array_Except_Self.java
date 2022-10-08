// https://leetcode.com/problems/product-of-array-except-self/

// With extra space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] prefix = new int[n], suffix = new int[n];   
        prefix[0] = 1;
        
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        
        suffix[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        
        for(int i = 0; i < n; i++) {
            prefix[i] *= suffix[i];
        }
        
        return prefix;
    }
}

// Without extra space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] prefix = new int[n];   
        prefix[0] = 1;
        
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        
        int mul = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            prefix[i] *= mul;
            mul *= nums[i];
        }
        
        return prefix;
    }
}
