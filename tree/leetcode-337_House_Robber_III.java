// https://leetcode.com/problems/house-robber-iii/

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
    public int rob(TreeNode root) {
        Pair p = dfs(root);
        
        return Math.max(p.r, p.wr);
    }
    
    private Pair dfs(TreeNode node) {
        if(node == null) return new Pair(0, 0);
        
        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        
        return new Pair(node.val + left.wr + right.wr, Math.max(left.r, left.wr) + Math.max(right.r, right.wr));
    }
}

class Pair {
    int r;  // with root
    int wr; // without root
    
    public Pair(int _r, int _wr) {
        r = _r;
        wr = _wr;
    }
}
