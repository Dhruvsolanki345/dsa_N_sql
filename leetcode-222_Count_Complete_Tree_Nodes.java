// https://leetcode.com/problems/count-complete-tree-nodes/

// Reference: https://www.youtube.com/watch?v=IXOXGnTCEvM

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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int count = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            
            int height = 1;
            TreeNode left = curr.left, right = curr.right;
            while(left != null && right != null) {
                height++;
                left = left.left;
                right = right;
            }
            
            if(left == null && right == null) {
                count += Math.pow(2,height) - 1;
                continue;
            }
            
            count++;
            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);
        }
        
        return count;
    }
}
