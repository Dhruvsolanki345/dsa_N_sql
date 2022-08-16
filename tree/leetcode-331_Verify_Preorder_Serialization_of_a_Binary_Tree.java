// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

class Solution {
    public boolean isValidSerialization(String preorder) {
        int hashCount = 1;
        String[] vals = preorder.split(",");
        
        for(String val: vals) {
            char ch = val.charAt(0);
            
            hashCount--;
            if(hashCount < 0) return false;
            if(Character.isDigit(ch)) {
                hashCount += 2;
            }
        }
        
        return hashCount == 0;
    }
}
