// https://www.codingninjas.com/codestudio/problems/1115652?leftPanelTab=0
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        HashMap<Integer, Integer> map = new HashMap();
        int count = 0, xor = 0;
        
        for(int num: arr){
            xor ^= num;
            
            if(xor == x) count++;
            
            int inverse = xor ^ x;
            
            if(map.containsKey(inverse)) count += map.get(inverse);
            
            if (map.containsKey(xor)) map.put(xor, map.get(xor) + 1);
            else map.put(xor, 1);
        }
        
        return count;
    }
}
