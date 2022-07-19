// https://leetcode.com/problems/subsets-ii/
class Solution {
    int nums[], N;
    List<List<Integer>> res;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        this.nums = nums;
        this.N = nums.length;
        this.res = new ArrayList<>();
        
        helper(new ArrayList<Integer>(), 0);
        
        return res;
    }
    
    private void helper(List<Integer> subset, int j){
        res.add(new ArrayList<>(subset));
        
        for(int i = j; i < N; i++){
            if(i != j && nums[i] == nums[i-1]) continue;
            
            subset.add(nums[i]);
            helper(subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
