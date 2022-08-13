// https://leetcode.com/problems/partition-array-for-maximum-sum/

// Memoization
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return frontPartition(0, k, n, arr, dp);
    }
    
    private int frontPartition(int i, int k, int n, int[] arr, int[] dp) {
        if(i == n) return 0;
        
        if(dp[i] != -1) return dp[i];
        
        int maxSum = 0, maxElement = 0;
        for(int j = i; j < n && j < i+k; j++) {
            maxElement = Math.max(maxElement, arr[j]);
            
            int curr = (maxElement * (j-i+1)) + frontPartition(j+1, k, n, arr, dp);
            maxSum = Math.max(maxSum, curr);
        }
        
        return dp[i] = maxSum;
    }
}

// Tabulation
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        
        for(int i = n-1; i > -1; i--) {
            int maxElement = 0;
            
            for(int j = i; j < n && j < i+k; j++) {
                maxElement = Math.max(maxElement, arr[j]);
                
                int curr = (maxElement * (j-i+1)) + dp[j+1];
                dp[i] = Math.max(dp[i], curr);
            }
        }
        
        return dp[0];
    }
}
