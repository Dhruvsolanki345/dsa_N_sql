// https://leetcode.com/problems/largest-divisible-subset/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int max = 1, lasti = 0, n = nums.length;
        int[] dp = new int[n], hash = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++) {
            hash[i] = i;
            for(int prev = 0; prev < i; prev++) {
                if(nums[i] % nums[prev] == 0 && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
            
            if(dp[i] > max) {
                max = dp[i];
                lasti = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        res.add(nums[lasti]);
        while(hash[lasti] != lasti) {
            lasti = hash[lasti];
            res.add(nums[lasti]);
        }
        
        Collections.reverse(res);
        
        return res;
    }
}
