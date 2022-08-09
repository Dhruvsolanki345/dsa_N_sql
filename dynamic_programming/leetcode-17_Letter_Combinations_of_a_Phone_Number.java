// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// backtracking
class Solution {
    final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    String digits;
    int n;
    List<String> res;
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        
        this.digits = digits;
        n = digits.length();
        res = new ArrayList<>();
        
        helper(0, new StringBuilder());
        
        return res;
    }
    
    private void helper(int i, StringBuilder subStr) {
        if(i == n) {
            res.add(subStr.toString());
            return;
        }
        
        for(char ch: map[digits.charAt(i) - '0'].toCharArray()) {
            subStr.append(ch);
            helper(i+1, subStr);
            subStr.deleteCharAt(subStr.length() - 1);
        }
    }
}

// dp
class Solution {
    final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        
        List<String> prev = new ArrayList<>();
        prev.add("");
        
        for(int i = 0; i < digits.length(); i++) {
            List<String> curr = new ArrayList<>();
            
            for(String str: prev) {
                String mapStr = map[digits.charAt(i) - '0'];
                for(int j = 0; j < mapStr.length(); j++) {
                    curr.add(str + mapStr.charAt(j));
                }
            }
            
            prev = curr;
        }
        
        return prev;
    }
}
