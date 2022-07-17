// https://leetcode.com/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer curr = null;
        
        for(int num: nums){
            if(count == 0) curr = num;
            
            count += (curr == num) ? 1 : -1;
        }
        
        return curr;
    }
}
