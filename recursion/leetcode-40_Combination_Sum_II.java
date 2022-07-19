// https://leetcode.com/problems/combination-sum-ii/
class Solution {
    List<List<Integer>> res;
    int candidates[], N;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        this.res = new ArrayList<>();
        this.candidates = candidates;
        this.N = candidates.length;
        
        helper(new ArrayList<>(), target, 0);
        
        return res;
    }
    
    private void helper(List<Integer> sub, int target, int idx){
        if(target == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }
        
        for(int i = idx; i < N; i++){
            if(i != idx && candidates[i - 1] == candidates[i]) continue;
        
            if(candidates[i] > target) break;
            
            sub.add(candidates[i]);
            helper(sub, target - candidates[i], i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
