// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

// Memoization
class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> arr = toList(cuts);
        arr.add(0, 0);
        arr.add(n);
        
        Collections.sort(arr);
        
        int len = cuts.length;
        int[][] dp = new int[len+1][len+1];
        
        for(int i = 0; i < len+1; i++)
            for(int j = 0; j < len+1; j++)
                dp[i][j] = -1;
        
        return partition(1, len, arr, dp);
    }
    
    private int partition(int i, int j, List<Integer> cuts, int[][] dp) {
        if(i > j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        
        for(int k = i; k <= j; k++) {
            min = Math.min(min, partition(i, k-1, cuts, dp) + partition(k+1, j, cuts, dp));
        }
            
        return dp[i][j] = min + (cuts.get(j+1) - cuts.get(i-1));
    }
    
    private List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        
        for(int num: arr) list.add(num);
        return list;
    }
}

// Tabulation
class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> arr = toList(cuts);
        arr.add(0, 0);
        arr.add(n);
        
        Collections.sort(arr);
        
        int len = cuts.length;
        int[][] dp = new int[len+2][len+2];
        
        
        for(int i = len; i >= 1; i--) {
            for(int j = i; j <= len; j++) {
                int min = Integer.MAX_VALUE;
                
                for(int k = i; k <= j; k++) {
                    min = Math.min(min, dp[i][k-1] + dp[k+1][j]);
                }
                
                dp[i][j] = min + (arr.get(j+1) - arr.get(i-1));
            }
        }
        
        return dp[1][len];
    }
    
    private List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        
        for(int num: arr) list.add(num);
        return list;
    }
}
