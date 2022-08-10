// https://leetcode.com/problems/wildcard-matching/

// Recursive
class Solution {
    String s, p;
    int n, m;
    
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        n = s.length();
        m = p.length();
        
        return dfs(0, 0);
    }
    
    private boolean dfs(int i, int j) {
        if(j == m) return i == n;
        
        if(i < n && s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dfs(i+1, j+1);
        } 
        
        if(p.charAt(j) == '*') {
            return (i < n && dfs(i+1, j)) || dfs(i, j+1);
        } 
        
        return false;
    }
}

// Tabulation
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[] next = new boolean[n+1], curr = new boolean[m+1];
        
        next[m] = true;
        for(int j = m-1; j > -1; j--) {
            if(p.charAt(j) == '*') next[j] = true;
            else break;
        }
        
        for(int i = n-1; i > -1; i--) {
            for(int j = m-1; j > -1; j--) {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') 
                    curr[j] = next[j+1];
                else if(p.charAt(j) == '*')
                    curr[j] = next[j] || curr[j+1];
                else 
                    curr[j] = false;
            }
            next = curr;
        }
        
        return next[0];
    }
}

// constant space
class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int m = s.length(), n = p.length();
        int last_match = -1, starj = -1;
        
        while (i < m){
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++; 
                j++;
            }
            else if (j < n && p.charAt(j) == '*'){
                starj = j++;
                last_match = i;
            }
            else if (starj != -1){
                j = starj + 1;
                i = ++last_match;
            }
            else return false;
        }
        while (j < n && p.charAt(j) == '*') j++;
        
        return j == n;
    }
}
