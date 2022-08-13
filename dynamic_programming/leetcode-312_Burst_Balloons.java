// https://leetcode.com/problems/burst-balloons/

class Solution {
    public int maxCoins(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        List<Integer> arr = addListBoundary(nums);
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        
        for(int i = n; i >= 1; i--) {
            for(int j = i; j <= n; j++) {
                int max = 0;
                
                for(int k = i; k <= j; k++) {
                    int sum = arr.get(i-1) * arr.get(k) * arr.get(j+1) + dp[i][k-1] + dp[k+1][j];
                    max = Math.max(max, sum);
                }
                
                dp[i][j] = max;
            }
        }
        
        return dp[1][n];
    }
    
    private List<Integer> addListBoundary(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        
        arr.add(1);
        for(int num: nums) arr.add(num);
        arr.add(1);
        
        return arr;
    }
}
