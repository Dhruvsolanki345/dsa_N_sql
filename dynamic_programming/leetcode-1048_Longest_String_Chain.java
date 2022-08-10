// https://leetcode.com/problems/longest-string-chain/

class Solution {
    public int longestStrChain(String[] words) {
        int max = 1, n = words.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.sort(words, (String s1, String s2) -> s1.length() - s2.length());
        
        for(int i = 0; i < n; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(compare(words[i], words[prev]) && dp[prev] + 1 > dp[i])
                    dp[i] = dp[prev] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
    private boolean compare(String s1, String s2) {
        // if(s1.length() > s2.length()) return compare(s2, s1);
        
        if(s2.length() - s1.length() != 1) return false;
        
        int i = 0, j = 0, r1 = s1.length(), r2 = s2.length();
        while(i < r1 && j < r2) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++; j++;
            } else {
                j++;
            }
        }
        
        return i >= r1;
    }
}
