// https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

class Solution {
    public int beautySum(String s) {
        if(s.length() <= 2) return 0;
        
        int n = s.length(), sum = 0;
        
        for(int i = 0; i < n-2; i++) {
            int[] map = new int[26];
            
            for(int j = i; j < n; j++) {
                int ind = s.charAt(j) - 'a';
                map[ind]++;
                
                if(j - i < 2) continue;
                
                int min = Integer.MAX_VALUE, max = 0;
                for(int k = 0; k < 26; k++) {
                    if(map[k] == 0) continue;
                    
                    min = Math.min(min, map[k]);
                    max = Math.max(max, map[k]);
                }
                
                sum += max - min;
            }
        }
        
        return sum;
    }
}
