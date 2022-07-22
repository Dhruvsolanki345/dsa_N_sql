// https://leetcode.com/problems/balanced-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return traverse(root) != -1;
    }
    
    private int traverse(TreeNode node){
        if(node == null) return 0;
        
        int left = traverse(node.left);
        if(left == -1) return -1;
        
        int right = traverse(node.right);
        if(right == -1) return -1;
        
        int diff = Math.abs(left - right);
        return (diff > 1) ? -1 : Math.max(left, right) + 1; 
    }
}
