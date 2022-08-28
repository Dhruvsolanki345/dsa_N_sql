// https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {       
        
        int i = 0, j = 0;
        int[] res = new int[nums.length - k + 1];
        int p = 0;
        
        Deque<Integer> curr = new LinkedList<>();
        
        while(j < nums.length){
            
            while(!curr.isEmpty() && nums[j] > curr.peekLast()){
                curr.pollLast();
            }
            curr.offer(nums[j]);
            
            if(j - i + 1 == k){
                res[p++] = curr.peekFirst();
                if(nums[i] == curr.peekFirst()){
                    curr.pollFirst();
                }
                
                i++;
            }
            
            j++;
        }
        
        return res;
    }
}
