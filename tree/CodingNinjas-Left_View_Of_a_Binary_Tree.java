// https://www.codingninjas.com/codestudio/problems/920519?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
        ArrayList<Integer> leftView = new ArrayList<>();
        
        traverseLeftView(leftView, 0, root);
        
        return leftView;
    }
    
    private static void traverseLeftView(ArrayList<Integer> leftView, int currDepth, TreeNode<Integer> node){
        if(node == null) return;
        
        if(currDepth == leftView.size()) leftView.add(node.data);
        
        traverseLeftView(leftView, currDepth + 1, node.left);
        traverseLeftView(leftView, currDepth + 1, node.right);
    }
}
