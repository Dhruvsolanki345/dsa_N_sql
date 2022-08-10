// https://leetcode.com/problems/group-anagrams/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s: strs) {
            char[] chCount = new char[26];
            
            for(int i = 0; i < s.length(); i++) chCount[s.charAt(i) - 'a']++;
            
            String key = new String(chCount);
            
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
