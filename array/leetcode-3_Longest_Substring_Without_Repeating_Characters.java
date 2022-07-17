// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int left = 0, right = 0, max = 0;
        
        for(; right < s.length(); right++){
            char curr = s.charAt(right);
            
            if (set.contains(curr)){
                while (set.contains(curr)) set.remove(s.charAt(left++));
            } else {
                max = Math.max(max, right - left + 1);
            }
            set.add(curr);
        }
        
        return max; 
    }
}
