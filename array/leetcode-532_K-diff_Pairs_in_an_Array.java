// https://leetcode.com/problems/k-diff-pairs-in-an-array/

// Hashmap
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        
        for(Map.Entry<Integer, Integer> pair: map.entrySet()) {
            if((k == 0 && pair.getValue() > 1) || 
               (k > 0 && map.containsKey(pair.getKey() + k))) {
                count++;
            }
        }
        
        return count;
    }
}

// Sorting and Hashset
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        
        int n = nums.length;
        Set<Integer> pairs = new HashSet<>();
        
        for(int i = 0; i < n-1; i++) {
            if(Arrays.binarySearch(nums, i+1, n, nums[i] + k) > 0) {
                pairs.add(nums[i]);
            }
        }
        
        return pairs.size();
    }
}
