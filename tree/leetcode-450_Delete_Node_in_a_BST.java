// https://leetcode.com/problems/delete-node-in-a-bst/

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        TreeNode prev = null, curr = root;
        boolean isLeft = false;
        while(curr != null) {
            if(curr.val == key) break;
            else {            
                prev = curr;
                if(curr.val < key) {
                    curr = curr.right;
                    isLeft = false;
                } else {
                    curr = curr.left;
                    isLeft = true;
                }
            }
        }
        
        if(curr == null) return root;
        
        if(prev == null) {
            return delete(curr);
        } else if(isLeft) {
            prev.left = delete(curr);
        } else {
            prev.right = delete(curr);
        }
        
        return root;
    }
    
    private TreeNode delete(TreeNode node) {
        if(node.left == null) return node.right;
        if(node.right == null) return node.left;
        
        TreeNode succ = node.right;
        while(succ.left != null) succ = succ.left;
        
        succ.left = node.left;
        
        return node.right;
    }
}
