// https://leetcode.com/problems/longest-consecutive-sequence/solution/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int max = 0;
        
        for(int num: nums) set.add(num);
        
        for(int num: nums){
            if(set.contains(num - 1)) continue;
            
            int next = num, count = 1;
            while(set.contains(++next)) count++;
            if (count > max) max = count;
        }
        
        return max;
    }
}
