// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] id = new int[1];
        return helper(preorder, id, preorder.length - 1, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int[] id, int len, int ub) {
        if(id[0] > len || preorder[id[0]] >= ub) return null;
        
        TreeNode curr = new TreeNode(preorder[id[0]]);
        
        id[0] += 1;
        curr.left = helper(preorder, id, len, curr.val);
        curr.right = helper(preorder, id, len, ub);
        
        return curr;
    }
}
