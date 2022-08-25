// https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length == 0) return 0;
        
        int low = 1, high = piles[0], res = 0;
        
        for(int pile: piles) high = Math.max(high, pile);
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int count = calCount(piles, mid);
                                 
            if(count <= h) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return res;
    }
    
    private int calCount(int[] piles, int k) {
        long count = 0;
        
        for(int pile: piles) {
            count += (long) Math.ceil(pile / (double) (k));
        }
        
        return (count > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) count;
    }
}
