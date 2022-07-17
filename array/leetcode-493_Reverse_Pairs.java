https://leetcode.com/problems/reverse-pairs/

class Solution {
    int count, arr[];
    
    public int reversePairs(int[] nums) {
        if(nums.length == 1) return 0;
        
        count = 0;
        arr = nums.clone();
        
        helper(0, nums.length - 1);
        
        return count;
    }
    
    private void helper(int s, int e){
        if (s >= e) return;
        
        int mid = s + (e - s) / 2;
        
        helper(s, mid);
        helper(mid + 1, e);
        merge(s, mid + 1, e);
    }
    
    private void merge(int s, int mid, int e){
        int i = s, j = mid;
        
        for(; i < mid; i++) {
            while(j<=e && arr[i] > (2 * (long) arr[j])) {
                j++;
            }
            count += j - mid;
        }
        
        combine(s, mid, e);
    }
    
    private void combine(int s, int mid, int e){
        int[] temp = new int[e - s + 1];
        int i = s, j = mid, k = 0;
        
        while (k < temp.length){
            if ((j > e) || (i < mid && arr[i] < arr[j])) temp[k] = arr[i++];
            else temp[k] = arr[j++];
            
            k++;
        }
        
        for (i = 0; i < temp.length; i++){
            arr[i + s] = temp[i];
        }
    }
}
