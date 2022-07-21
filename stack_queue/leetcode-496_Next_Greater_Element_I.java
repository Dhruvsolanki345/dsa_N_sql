// https://leetcode.com/problems/next-greater-element-i/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = nums2.length - 1; i >= 0; i--){
            while(!stack.empty() && stack.peek() <= nums2[i]) stack.pop();
            
            map.put(nums2[i], stack.empty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        
        return res;
    }
}
