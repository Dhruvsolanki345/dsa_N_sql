// https://www.codingninjas.com/codestudio/problems/longest-bitonic-sequence_1062688?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class Solution {
    public static int longestBitonicSequence(int[] nums, int n) {
        int[] dpLeft = new int[n], dpRight = new int[n];
        
        for(int i = 0; i < n; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(nums[i] > nums[prev] && dpLeft[prev] + 1 > dpLeft[i])
                    dpLeft[i] = dpLeft[prev] + 1;
            }
        }
        
        for(int i = n-1; i > -1; i--) {
            for(int prev = n-1; prev > i; prev--) {
                if(nums[i] > nums[prev] && dpRight[prev] + 1 > dpRight[i])
                    dpRight[i] = dpRight[prev] + 1;
            }
        }
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dpLeft[i] + dpRight[i]);
        }
        
        // dp is generally initialize to 1 but here its 0
        // max = leftLis + rightLis - 1 ...  i.e. max = left+1 + right+1 - 1 = left + right + 1     
        return max + 1; 
    }
}
