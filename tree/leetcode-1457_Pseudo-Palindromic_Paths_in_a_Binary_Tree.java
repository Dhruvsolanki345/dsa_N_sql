// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

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
    int[] isOdd;
    int count, res;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        isOdd = new int[10];
        count = res = 0;
        
        dfs(root);
        
        return res;
    }
    
    private void dfs(TreeNode node) {
        if(node == null) return;
        
        if(isOdd[node.val] == 1) {
            isOdd[node.val] = 0;
            count--;
        } else {
            isOdd[node.val] = 1;
            count++;
        }
        
        if(node.left == null && node.right == null) {
            if(count <= 1) res++;
        }
        
        dfs(node.left);
        dfs(node.right);
        
        if(isOdd[node.val] == 1) {
            isOdd[node.val] = 0;
            count--;
        } else {
            isOdd[node.val] = 1;
            count++;
        }
    }
}
