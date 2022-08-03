// https://leetcode.com/problems/reverse-vowels-of-a-string/
class Solution {
    public String reverseVowels(String s) {        
        int left = 0, right = s.length() - 1;
        char[] str = s.toCharArray();
        
        while(left < right) {
            boolean leftVow = isVowel(str[left]);
            boolean rightVow = isVowel(str[right]);
            
            if(leftVow && rightVow) swap(left++, right--, str);
            
            if(!leftVow) left++;
            if(!rightVow) right--;
        }
        
        return new String(str);
    }
    
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
    
    private void swap(int i, int j, char[] str) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
