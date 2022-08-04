// https://leetcode.com/problems/minimum-window-substring/

// Two pointer

class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int i = 0, j = 0, min = s.length();
        int left = 0, right = s.length() - 1, count = map.size();
        boolean found = false;
        
        while(j < s.length()) {
            char endCh = s.charAt(j++);
            
            if(map.containsKey(endCh)) {
                map.put(endCh, map.get(endCh) - 1);
                if(map.get(endCh) == 0) count--;
            }
            
            if(count > 0) continue;
            
            while(count == 0) {
                char startCh = s.charAt(i++);
                
                if(map.containsKey(startCh)) {
                    map.put(startCh, map.get(startCh) + 1);
                    if(map.get(startCh) > 0) count++;
                }
            }
            
            if((j - i) < min) {
                left = i;
                right = j;
                min = j - i;
                found = true;
            }
        }
        
        return !found ? "" : s.substring(left - 1, right);
    }
}
