// https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

************************************************************/

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> traverseBoundary(TreeNode root){
        if(root == null) new ArrayList<>();
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if(isLeaf(root) == false) res.add(root.data);
        
        traverseLeft(res, root);
        traverseLeaf(res, root);
        traverseRight(res, root);
        
        return res;
    }
    
    private static boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    
    private static void traverseLeft(ArrayList<Integer> res, TreeNode root){
        TreeNode node = root.left;
        
        while(node != null){
            if(isLeaf(node)) break;
            
            res.add(node.data);
            node = (node.left != null) ? node.left : node.right;
        }
    }
    
    private static void traverseRight(ArrayList<Integer> res, TreeNode root){
        TreeNode node = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(node != null){
            if(isLeaf(node)) break;
            
            temp.add(node.data);
            node = (node.right != null) ? node.right : node.left;
        }
        
        for(int i = temp.size() - 1; i >= 0; i--) res.add(temp.get(i));
    }
    
    private static void traverseLeaf(ArrayList<Integer> res, TreeNode node){
        if(isLeaf(node)){
            res.add(node.data);
            return;
        }
        
        if(node.left != null) traverseLeaf(res, node.left);
        if(node.right != null) traverseLeaf(res, node.right);
    }
}
