// https://leetcode.com/problems/first-unique-character-in-a-string/
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < str.length; i++) {
            int count = 1;
            if(map.containsKey(str[i])) {
                count += map.get(str[i]);
            }
            
            map.put(str[i], count);
            min = Math.min(min, count);
        }
        
        if(min > 1) return -1;
        
        for(int i = 0; i < str.length; i++) {
            if(map.get(str[i]) == 1) return i;
        }
        
        return -1;
    }
}
