// https://leetcode.com/problems/decode-string/

class Solution {
    public String decodeString(String s) {
        if(s.length() <= 2) return s;
        
        Stack<Integer> counts = new Stack<>();
        Stack<String> words = new Stack<>();
        int count = 0, i = 0;
        StringBuilder word = new StringBuilder();
        
        while(i < s.length()) {
            char ch = s.charAt(i++);
            
            if(Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if(Character.isLetter(ch)) {
                word.append(ch);
            } else if(ch == '[') {
                counts.add(count);
                words.add(word.toString());
                count = 0;
                word = new StringBuilder();
            } else {
                int num = counts.pop();
                StringBuilder sb = new StringBuilder(words.pop());
                for(int k = 0; k < num; k++) sb.append(word);
                word = sb;
            }
        }
        
        return word.toString();
    }
}
