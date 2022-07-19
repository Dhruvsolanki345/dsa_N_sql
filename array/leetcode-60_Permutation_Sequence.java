// https://leetcode.com/problems/permutation-sequence/
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        String res = "";
        int fact = 1;
        
        for(int i = 1; i < n; i++){
            fact *= i;
            nums.add(i);
        }
        nums.add(n);
        
        k--;
        while(true){
            res += "" + nums.get(k / fact);
            nums.remove(k / fact);
            
            if(nums.size() == 0) break;
            
            k %= fact;
            fact /= nums.size();
        }
        
        return res;
    }
}
