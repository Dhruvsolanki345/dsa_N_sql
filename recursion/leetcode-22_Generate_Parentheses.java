// https://leetcode.com/problems/generate-parentheses/

class Solution {
    List<String> res;
    
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        
        helper(n-1, n, new StringBuilder("("));
        
        return res;
    }
    
    private void helper(int openi, int closei, StringBuilder subStr) {
        if(openi == 0 && closei == 0) {
            res.add(subStr.toString());
            return;
        }
        
        if(openi > 0) {
            subStr.append('(');
            helper(openi-1, closei, subStr);
            subStr.deleteCharAt(subStr.length() - 1);
        }
        
        if(closei > openi && closei > 0) {
            subStr.append(')');
            helper(openi, closei-1, subStr);
            subStr.deleteCharAt(subStr.length() - 1);
        }
    }
}
