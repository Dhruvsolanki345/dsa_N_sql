// https://leetcode.com/problems/unique-binary-search-trees-ii/

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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        
        if(start > end) {
            // edge case - required below when iterating list: if outer list is empty then it will not consider inner list possibility to avoid that adding null.
            res.add(null); 
            return res;
        }
        if(start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        
        for(int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);
            
            for(TreeNode lRoot: left) {
                for(TreeNode rRoot: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lRoot;
                    root.right = rRoot;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}
