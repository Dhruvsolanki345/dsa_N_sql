// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        
        return preorder(root, k, set);
    }
    
    private boolean preorder(TreeNode node, int k, Set<Integer> set) {
        if(node == null) return false;
        
        if(set.contains(k-node.val)) return true;
        
        set.add(node.val);
        
        return preorder(node.left, k, set) || preorder(node.right, k, set);
    }
}
