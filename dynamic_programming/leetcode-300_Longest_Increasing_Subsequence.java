// https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int count = 0;
        
        for(int num: nums) {
            if(count == 0 || lis[count - 1] < num) {
                lis[count] = num;
                count++;
                continue;
            }
            
            int left = 0, right = count;
            boolean flag = false;
            
            while(left <= right) {
                int mid = (left + right) / 2;
                
                if(num == lis[mid]) {
                    flag = true;
                    break;
                }
                else if(num < lis[mid]) right = mid - 1;
                else left = mid + 1;
            }
            
            if(flag) continue;
            
            lis[left] = num;
        }
        
        return count;
    }
}
