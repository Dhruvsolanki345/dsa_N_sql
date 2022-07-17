
// https://leetcode.com/problems/find-the-duplicate-number/submissions/
class Solution {
    public int findDuplicate(int[] nums) {
        int i = 1, j = nums.length - 1, res = -1;
        
        while(i <= j){
            int curr = i + (j - i) / 2;
            
            int count = 0;
            for(int temp: nums) if(temp <= curr) count++;
            
            if(count > curr) {
                res = curr;
                j = curr - 1;
            }
            else i = curr + 1;
        }
        
        return res;
    }
}
