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

// Recursion
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

// iterative - stack
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> st = new Stack<>();
        
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
            
            if(!st.isEmpty()) node.right = st.peek();
            node.left = null;
        }
    }
}

//  Optimal - Morris pre order
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left;
                
                while(prev.right != null) prev = prev.right;
                
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
