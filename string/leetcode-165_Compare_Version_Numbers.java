// https://leetcode.com/problems/compare-version-numbers/

// Without using split
class Solution {
    public int compareVersion(String version1, String version2) {   
        int num1 = 0, num2 = 0, i = 0, j = 0;
        boolean revEnded1 = false, revEnded2 = false;
        
        while(i < version1.length() || j < version2.length()) {            
            if(i == version1.length()) revEnded1 = true;
            else if(i < version1.length() && !revEnded1) {
                char ch1 = version1.charAt(i++);
                
                if(ch1 == '.') revEnded1 = true;
                else num1 = num1*10 + (ch1 - '0');
            }
            
            if(j == version2.length()) revEnded2 = true;
            else if(j < version2.length() && !revEnded2) {
                char ch2 = version2.charAt(j++);
                
                if(ch2 == '.') revEnded2 = true;
                else num2 = num2*10 + (ch2 - '0');
            }
            
            if(revEnded1 && revEnded2) {
                if(num1 == num2) {
                    revEnded1 = revEnded2 = false;
                    num1 = num2 = 0;
                } else return (num1 < num2) ? -1 : 1;
            } 
        }
        
        if(num1 == num2) return 0;
        return num1 < num2 ? -1 : 1;
    }
}

// Using split
class Solution {
    public int compareVersion(String version1, String version2) {   
        String[] v1rev = version1.split("\\."), v2rev = version2.split("\\.");
        int i = 0, j = 0, m = v1rev.length, n = v2rev.length;
        
        while(i < m || j < n) {
            int num1 = (i < m) ? Integer.parseInt(v1rev[i++]) : 0;
            int num2 = (j < n) ? Integer.parseInt(v2rev[j++]) : 0;
            
            if(num1 != num2) return (num1 < num2) ? -1 : 1;
        }
        
        return 0;
    }
}
