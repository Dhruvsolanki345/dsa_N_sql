// https://leetcode.com/problems/combination-sum/
class Solution {
    List<List<Integer>> res;
    int candidates[], N;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.candidates = candidates;
        this.N = candidates.length;
        
        helper(new ArrayList<>(), target, 0);
        
        return res;
    }
    
    private void helper(List<Integer> sub, int target, int i){
        if(target == 0){
            res.add(new ArrayList<>(sub));
            return;
        }
        if(i == N || target < 0) return;
        
        sub.add(candidates[i]);
        helper(sub, target - candidates[i], i);
        sub.remove(sub.size() - 1);
        
        helper(sub, target, i + 1);
    }
}
