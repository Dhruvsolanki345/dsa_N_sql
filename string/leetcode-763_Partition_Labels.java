// https://leetcode.com/problems/partition-labels/
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        
        for(int i = 0; i < str.length; i++) {
            map.put(str[i], i);
        }
        
        List<Integer> counts = new ArrayList<>();
        int lasti = 0, prev = -1;
        
        for(int i = 0; i < str.length; i++) {
            char c = str[i];
            
            lasti = Math.max(lasti, map.get(c));
            
            if(lasti == i) {
                counts.add(i - prev);
                prev = i;
            }
        }
        
        return counts;
    }
}
