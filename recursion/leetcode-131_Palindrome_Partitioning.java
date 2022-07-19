// https://leetcode.com/problems/palindrome-partitioning/
class Solution {
    List<List<String>> res;
    String s;
    int N;
    
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        this.s = s;
        this.N = s.length();
        
        helper(new ArrayList<>(), 0);
        
        return res;
    }
    
    private void helper(List<String> sub, int idx){
        if(idx == N){
            res.add(new ArrayList<>(sub));
            return;
        }
        
        for(int i = idx; i < N; i++){
            if(isPalindrome(idx, i)){
                sub.add(s.substring(idx, i + 1));
                helper(sub, i + 1);
                sub.remove(sub.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
