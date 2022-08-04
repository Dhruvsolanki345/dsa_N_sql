// https://leetcode.com/problems/text-justification/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        
        int i = 0, n = words.length;
        
        while(i < n) {
            int j = i + 1;
            int lineWidth = words[i].length();
            
            while(j < n && (lineWidth + words[j].length() + (j-i-1)) < maxWidth) {
                lineWidth += words[j++].length();
            }
            
            int diff = maxWidth - lineWidth;
            int wordCount = j - i;
            
            if(wordCount == 1 || j >= n) res.add(leftJustify(i, j, diff, words));
            else res.add(centerJustify(i, j, diff, words));
            
            i = j;
        }
        
        return res;
    }
    
    private String leftJustify(int i, int j, int diff, String[] words) {
        int spacesRight = diff - (j-i-1);
        
        StringBuilder sb = new StringBuilder(words[i]);
        
        for(int k = i + 1; k < j; k++) {
            sb.append(" ");
            sb.append(words[k]);
        }
        
        sb.append(" ".repeat(spacesRight));
        
        return sb.toString();
    }
    
    private String centerJustify(int i, int j, int diff, String[] words) {
        int sections = j - i - 1;
        int spaces = diff / sections;
        int extraSpaces = diff % sections;
        
        StringBuilder sb = new StringBuilder(words[i]);
        
        for(int k = i + 1; k < j; k++) {
            int space = spaces + (extraSpaces-- > 0 ? 1 : 0);
            sb.append(" ".repeat(space));
            sb.append(words[k]);
        }
        
        return sb.toString();
    }
}
