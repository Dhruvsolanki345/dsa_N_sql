// https://leetcode.com/problems/validate-binary-search-tree/
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
    public boolean isValidBST(TreeNode root) {
        return helper(root, -1l + Integer.MIN_VALUE, 1l + Integer.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long lb, long ub){
        if(node == null) return true;
        
        return (node.val < ub && node.val > lb) && 
            helper(node.left, lb, node.val) &&
            helper(node.right, node.val, ub);
    }
}
