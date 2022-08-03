// https://leetcode.com/problems/reorder-data-in-log-files/
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (String s1, String s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            
            boolean d1 = Character.isDigit(split1[1].charAt(0));
            boolean d2 = Character.isDigit(split2[1].charAt(0));
            
            if(d1) {
                if(d2) return 0;
                else return 1;
            } 
            
            if(d2) return -1;
            
            int comp = split1[1].compareTo(split2[1]);
            if(comp == 0) return split1[0].compareTo(split2[0]);
            return comp;
        });
         
        return logs;
    }
}
