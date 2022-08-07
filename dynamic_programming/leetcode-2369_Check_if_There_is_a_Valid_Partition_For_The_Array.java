// https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/

// Memoization
class Solution {
    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) dp[i] = -1;
        
        return (isValid(0, nums, dp) == 1) ? true : false;
    }
    
    private int isValid(int i, int[] nums, int[] dp) {
        if(i == nums.length) return 1;
        
        if(dp[i] != -1) return dp[i];
        
        if(i + 1 < nums.length && nums[i] == nums[i+1]) {
            if(isValid(i+2, nums, dp) == 1) return dp[i] = 1;
            
            if(i + 2 < nums.length && nums[i] == nums[i+2]) {
                if(isValid(i+3, nums, dp) == 1) return dp[i] = 1;
            }
        }
        
        if(i + 2 < nums.length && nums[i] + 1 == nums[i+1] && nums[i] + 2 == nums[i+2]) {
            if(isValid(i+3, nums, dp) == 1) return dp[i] = 1;
        }
        
        return dp[i] = 0;
    }
}

// Tabulation
class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length + 1];
        dp[nums.length] = true;
        
        for(int i = nums.length - 1; i > -1; i--) {
            if(i + 1 < nums.length && nums[i] == nums[i+1]) {
                if(dp[i+2]) {
                    dp[i] = true;
                } else if(i + 2 < nums.length && nums[i] == nums[i+2]) {
                    if(dp[i+3]) {
                         dp[i] = true;
                    }
                }
            } else if(i + 2 < nums.length && nums[i] + 1 == nums[i+1] && nums[i] + 2 == nums[i+2]) {
                if(dp[i+3]) {
                    dp[i] = true;
                }
            } else {
                dp[i] = false;
            }
        }
        
        return dp[0];
    }
}
