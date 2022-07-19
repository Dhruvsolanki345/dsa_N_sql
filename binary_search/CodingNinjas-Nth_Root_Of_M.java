// https://www.codingninjas.com/codestudio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class Solution {
    public static double findNthRootOfM(int n, long m) {
        double low = 1;
        double high = m + 1;
        double eps = 1e-8;
        
        while((high - low) > eps){
            double mid = (high + low) / 2.0;
            
            if(pow(mid, n) < (double) m) low = mid;
            else high = mid;
        }
        
        return low;
    }
    
    private static double pow(double x, int n){
        double pow = 1.0;
        for(int i = 0; i < n; i++) pow *= x;
        
        return pow;
    }
}
