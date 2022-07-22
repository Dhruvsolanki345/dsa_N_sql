// https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    public int maxPathSum(TreeNode root) {
        int[] maxS = new int[1];
        
        maxS[0] = Integer.MIN_VALUE;
        traverse(root, maxS);
        
        return maxS[0];
    }
    
    private int traverse(TreeNode node, int[] maxS){
        if(node == null) return 0;
        
        int left = traverse(node.left, maxS);
        int right = traverse(node.right, maxS);
        
        if(left < 0) left = 0; 
        if(right < 0) right = 0;
        
        maxS[0] = Math.max(maxS[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
