// https://leetcode.com/problems/diameter-of-binary-tree/
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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxD = new int[1];
        
        traverse(root, maxD);
        
        return maxD[0];
    }
    
    private int traverse(TreeNode node, int[] maxD){
        if(node == null) return 0;
        
        int left = traverse(node.left, maxD);
        int right = traverse(node.right, maxD);
        
        maxD[0] = Math.max(maxD[0], left + right);
        return Math.max(left, right) + 1;
    }
}
