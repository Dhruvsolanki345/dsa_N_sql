// https://www.codingninjas.com/codestudio/problems/next-smaller-element_1112581?topList=striver-sde-sheet-problems&leftPanelTab=0
import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = arr.size() - 1; i >= 0; i--){
            int curr = arr.get(i);
            
            while(!stack.empty() && stack.peek() >= curr) stack.pop();
            
            res.add(0, stack.empty() ? -1 : stack.peek());
            stack.push(curr);
        }
        
        return res;
    }
}
