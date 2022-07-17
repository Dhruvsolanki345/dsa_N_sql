// https://www.codingninjas.com/codestudio/problems/873366
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] res = new int[2];
        
        for(Integer curr: arr){
            int currAbs = Math.abs(curr);
            int temp = arr.get(currAbs - 1);
            
            if(temp < 0) res[1] = currAbs;
            
            arr.set(currAbs - 1, temp * -1);
        }
        
        for(int i = 0; i < arr.size(); i++){
            int curr = arr.get(i);
            if(curr > 0 && res[1] != i + 1) res[0] = i + 1;
        }
        
        return res;
    }
}
