// https://leetcode.com/problems/sum-of-left-leaves/

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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            
            if(curr.left != null) {
                if(curr.left.left == null && curr.left.right == null) {
                    sum += curr.left.val;
                } else {
                    st.push(curr.left);
                }
            }
            
            if(curr.right != null) {
                st.push(curr.right);
            }
        }
        
        return sum;
    }
}
