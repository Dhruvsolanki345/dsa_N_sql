// https://leetcode.com/problems/reverse-words-in-a-string/
class Solution {
    public String reverseWords(String s) {
        int i = 0, len = s.length() - 1;
        String res = "", word = "";
        char prev = ' ';
        
        while(i <= len){
            char curr = s.charAt(i);
            
            if(curr == ' ' && prev == curr) {}
            else if(curr != ' '){
                word += "" + curr;
            } else {
                res = word + (res == "" ? "" : " ") + res;
                word = "";
            }
            
            prev = curr;
            i++;
        }
        
        if(word != "") res = word + (res == "" ? "" : " ") + res;
        
        return res;
    }
}
