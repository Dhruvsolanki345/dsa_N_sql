// https://leetcode.com/problems/powx-n/
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        
        long pow = n;
        double res = 1;
        if (n < 0) pow *= -1;
        
        double prev = x;
        while(pow > 0){
            res *= pow % 2 == 0 ? 1 : prev;
            prev *= prev;
            pow /= 2;
        }
        
        if(n < 0) res = 1 / res;
        
        return res;
    }
}
