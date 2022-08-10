// https://leetcode.com/problems/jump-game/

// Without dp - linear time
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        
        int n = nums.length - 1, dis = 0;
        
        for(int i = 0; i <= dis; i++) {
            dis = Math.max(dis, i + nums[i]);
            
            if(dis >= n) return true;
        }
        
        return false;
    }
}

// Tabulation
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        
        int n = nums.length - 1;
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        
        for(int i = n-1; i >= 0; i--) {
            boolean flag = false;
            
            for(int k = 1; k <= nums[i]; k++) {
                if(i + k > n) break;
                
                if(dp[i+k]) {
                    flag = true;
                    break;
                }
            }
            
            dp[i] = flag;
        }
        
        return dp[0];
    }
}

// Memoization
class Solution {
    int nums[], n;
    
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        
        this.nums = nums;
        n = nums.length - 1;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return dfs(0, dp) == 1;
    }
    
    private int dfs(int i, int[] dp) {
        if(i == n) return 1;
        
        if(dp[i] != -1) return dp[i];
        
        for(int k = 1; k <= nums[i]; i++) {
            if(dfs(i+k, dp) == 1) return dp[i] = 1;
        }
        
        return dp[i] = 0;
    }
}
