// https://leetcode.com/problems/word-break/
// concept -> dp and trie

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        
        for(String word: wordDict) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                if(!curr.contains(word.charAt(i))) {
                    curr.put(word.charAt(i));
                }
                
                curr = curr.get(word.charAt(i));
            }
            curr.markEnd();
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true;
        for(int i = 0; i < s.length(); i++) {
            if(!dp[i]) continue;
            
            int j = i;
            TrieNode curr = root;
            while(j < s.length() && curr.contains(s.charAt(j))) {
                curr = curr.get(s.charAt(j++));
                
                if(curr.isEnd()) dp[j] = true;
            }
        }
        
        return dp[s.length()];
    }
}

class TrieNode {
    TrieNode[] links;
    boolean flag;
    
    TrieNode() {
        links = new TrieNode[26];
        flag = false;
    }
    
    public boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }
    
    public void put(char ch) {
        links[ch - 'a'] = new TrieNode();
    }
    
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    
    public boolean isEnd() {
        return flag;
    }
    
    public void markEnd() {
        flag = true;
    }
}
