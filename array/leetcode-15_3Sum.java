// https://leetcode.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        
        Arrays.sort(nums);
        
        int i = 0;
        while(i < nums.length){
            int left = i + 1, right = nums.length - 1;
            int curr = nums[i];
            
            while(left < right){
                int sum = nums[left] + nums[right];
                
                if(sum == -curr){
                    List<Integer> triplet = new ArrayList();
                    triplet.add(curr);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    res.add(triplet);
                    
                    while(left < nums.length && nums[left] == triplet.get(1)) left++;
                    while(right >= 0 && nums[right] == triplet.get(2)) right--;
                    
                } else if(sum > -curr) right--;
                else left++;
            }
            
            while(i < nums.length && nums[i] == curr) i++;
        }
        
        return res;
    }
}
