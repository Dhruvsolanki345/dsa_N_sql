// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode node){
        if(node == null || (node.left == null && node.right == null)) return node;
        
        TreeNode left = helper(node.left);
        TreeNode right = helper(node.right);
        
        if(left == null) return right;
        
        left.right = node.right;
        node.right = node.left;
        node.left = null;
        
        return (right == null) ? left : right;
    }
}
