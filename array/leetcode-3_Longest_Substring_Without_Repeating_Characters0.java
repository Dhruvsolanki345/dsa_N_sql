// https://leetcode.com/problems/longest-substring-without-repeating-characters/
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
