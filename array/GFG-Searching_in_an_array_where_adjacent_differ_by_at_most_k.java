// https://practice.geeksforgeeks.org/problems/searching-in-an-array-where-adjacent-differ-by-at-most-k0456/1

// Optimized O(n)
class Complete{
    
    // Function for finding maximum and value pair
    public static int search (int arr[], int n, int x, int k) {
        if(arr.length == 0) return -1;
        
        int curr = 0;
        
        while(curr < arr.length) {
            if(arr[curr] == x) return curr;
            
            int diff = Math.abs(arr[curr] - x) / k;
            diff = Math.max(diff, 1);
            
            curr += diff;
        }
        
        return -1;
    }
}
