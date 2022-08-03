// https://leetcode.com/problems/reverse-integer/
class Solution {
    public int reverse(int x) {
        long res = 0;
        
        while(x != 0) {
            int rem = x % 10;
            
            res = res*10 + rem;
            if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        
        return (int) res;
    }
}
