// https://www.codingninjas.com/codestudio/problems/615?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
import java.util.* ;
import java.io.*; 
public class Solution {
    static long sorted[], count;
    
    public static long getInversions(long arr[], int n) {
        if(n == 1) return 0;
        
        count = 0;
        sorted = new long[n];
        
        mergeSort(arr, 0, n - 1);
        
        return count;
    }
    
    private static void mergeSort(long[] arr, int i, int j){
        if(i >= j) return;
        
        int mid = i + (j - i) / 2;
        
        mergeSort(arr, i, mid);
        mergeSort(arr, mid + 1, j);
        
        combine(arr, i, j, mid + 1);
    }
    
    private static void combine(long[] arr, int l, int r, int m){
        int i = l, j = m, k = l;
        
        while (i < m && j <= r) {
            if (arr[i] <= arr[j])
                sorted[k++] = arr[i++];
            else {
                sorted[k++] = arr[j++];
                count += m - i;
            }
        }
        while (i < m) 
            sorted[k++] = arr[i++];
        while (j <= r)
            sorted[k++] = arr[j++];
        for (i = l; i < k; i++) 
            arr[i] = sorted[i];
     }
}
