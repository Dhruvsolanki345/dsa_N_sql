// https://leetcode.com/problems/recover-binary-search-tree/

// inorder: using recursion
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
    TreeNode first, second, prev;
    
    public void recoverTree(TreeNode root) {
        prev = null;
        first = null;
        second = null;
        
        recover(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void recover(TreeNode node) {
        if(node == null) return;
        
        recover(node.left);
        
        if(prev != null && node.val < prev.val) {
            if(first == null) {
                first = prev;
                second = node;
            } else {
                second = node;
            }
        }
        
        prev = node;
        
        recover(node.right);
    }
}

// inorder: using morris traversal: constant space
class Solution {
    TreeNode first, second, prev;
    
    public void recoverTree(TreeNode root) {
        prev = null;
        first = null;
        second = null;
        
        while(root != null) {
            if(root.left != null) {
                // connect threading for root
                TreeNode pre = root.left;
                
                while(pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                
                if(pre.right != null) {
                    // the threading already exists
                    pre.right = null;
                    build(root);
                    root = root.right;
                } else {
                    // construct the threading
                    pre.right = root;
                    root = root.left;
                }
            } else {
                build(root);
                root = root.right;
            }
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void build(TreeNode node) {
        if(prev != null && node.val < prev.val) {
            if(first == null) {
                first = prev;
                second = node;
            } else {
                second = node;
            }
        }
        
        prev = node;
    }
}
