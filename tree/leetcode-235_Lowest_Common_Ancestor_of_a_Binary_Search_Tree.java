// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        
        while(curr != null) {
            if((p.val <= curr.val && curr.val <= q.val) || (q.val <= curr.val && curr.val <= p.val)) return curr;
            
            curr = (p.val < curr.val && q.val < curr.val) ? curr.left : curr.right;
        }
        
        return null;
    }
}
