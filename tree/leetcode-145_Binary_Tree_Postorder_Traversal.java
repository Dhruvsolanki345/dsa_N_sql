// https://leetcode.com/problems/binary-tree-postorder-traversal/
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
    List<Integer> post;
    
    public List<Integer> postorderTraversal(TreeNode root) {
        post = new ArrayList<>();
        
        postOrderTrav(root);
        
        return post;
    }
    
    private void postOrderTrav(TreeNode node){
        if(node == null) return;
        
        postOrderTrav(node.left);
        postOrderTrav(node.right);
        post.add(node.val);
    }
}
