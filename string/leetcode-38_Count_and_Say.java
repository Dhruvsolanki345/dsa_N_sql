// https://leetcode.com/problems/count-and-say/

class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        
        StringBuilder say = new StringBuilder();
        String str = countAndSay(n-1);
        int count = 1;
        
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i-1) != str.charAt(i)) {
                say.append(count + "" + str.charAt(i-1));
                count = 0;
            }
            
            count += 1;
        }
        
        say.append(count + "" + str.charAt(str.length() - 1));
        
        return say.toString();
    }
}
