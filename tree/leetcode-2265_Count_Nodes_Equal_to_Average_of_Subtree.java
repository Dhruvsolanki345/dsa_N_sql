// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/

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
    public int averageOfSubtree(TreeNode root) {
        int[] count = new int[1], childCount = new int[1];
        
        traverse(root, count, childCount);
        
        return count[0];
    }
    
    private int traverse(TreeNode node, int[] count, int[] childCount) {
        if(node == null) return 0;
        
        childCount[0] = 0;
        int left = traverse(node.left, count, childCount);
        int child = childCount[0];
        
        childCount[0] = 0;
        int right = traverse(node.right, count, childCount);
        childCount[0] += child;
        
        int sum = left + right + node.val;
        
        childCount[0]++;
        
        if(Math.round(sum / childCount[0]) == node.val) {
            count[0]++;
        }
        
        return sum;
    } 
}
