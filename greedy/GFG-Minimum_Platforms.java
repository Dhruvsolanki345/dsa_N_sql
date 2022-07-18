// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
class Solution {
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 1, j = 0, max = 1, count = 1;
        while(i < n && j < n) {
            if(arr[i] <= dep[j]){
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
    
}
