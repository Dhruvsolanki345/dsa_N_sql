// https://leetcode.com/problems/permutations/
class Solution {
    List<List<Integer>> res;
    int nums[], N;
    
    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;
        this.N = nums.length;
        
        List<Integer> perm = new ArrayList<Integer>();
        for(Integer num: nums) perm.add(num);
        
        helper(perm, 0);
        
        return res;
    }
    
    private void helper(List<Integer> perm, int idx){
        if (idx == N) {
            res.add(new ArrayList<>(perm));
            return;
        }
        
        for(int i = idx; i < N; i++){
            swap(perm, idx, i);
            helper(perm, idx + 1);
            swap(perm, i, idx);
        }
    }
    
    private void swap(List<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    } 
}
