// https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
import java.util.*;

public class Solution {

    public static void sortStack(Stack<Integer> stack) {
        if(stack.empty()) return;
        
        int top = stack.pop();
        sortStack(stack);
        sortInsert(stack, top);
    }

    private static void sortInsert(Stack<Integer> stack, int x){
        if(stack.empty() || x >= stack.peek()){
            stack.push(x);
            return;
        }
        
        int top = stack.pop();
        sortInsert(stack, x);
        stack.push(top);
    }
}
