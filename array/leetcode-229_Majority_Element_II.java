// https://leetcode.com/problems/majority-element-ii/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0, minC = nums.length/3;
        Integer curr1 = null, curr2 = null;
        
        for(int num: nums){
            if(curr1 != null && curr1 == num) {
                count1++;
            } else if(curr2 != null && curr2 == num) {
                count2++;
            } else if(count1 == 0) {
                curr1 = num;
                count1 = 1;
            } else if (count2 == 0){
                curr2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        List<Integer> res = new ArrayList();
        count1 = 0;
        count2 = 0;
        for(int num: nums){
            if(curr1 == num) count1++;  
            else if(curr2 == num) count2++;    
        }
        
        if(count1 > minC) res.add(curr1);
        if(count2 > minC) res.add(curr2);
        
        return res;
    }
}
