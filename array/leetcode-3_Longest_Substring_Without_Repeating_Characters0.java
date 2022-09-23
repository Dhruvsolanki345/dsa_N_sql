// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Not optimize - map
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        
        int count = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0, j = 0; j < s.length(); j++){
            char chr = s.charAt(j);
            
            if(map.containsKey(chr)){
                map.put(chr, map.get(chr) + 1);
                count++;
            } else {
                map.put(chr, 1);
            }
            
            if(count == 0){
                max = Math.max(max, j - i + 1);
            } else {
                while(count != 0){
                    if(map.get(s.charAt(i)) == 1){
                        map.remove(s.charAt(i));
                    } else {
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                        
                        if(map.get(s.charAt(i)) == 1) count--;
                    }
                    i++;
                }
            }
        }
        
        return max;
    }
}

// Optimize - set
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
