// https://leetcode.com/problems/convert-bst-to-greater-tree/

// recursive
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
    int sum;
    
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        
        reverseInorder(root);
        
        return root;
    }
    
    private void reverseInorder(TreeNode node) {
        if(node == null) return;
        
        reverseInorder(node.right);
        
        node.val = sum = sum + node.val;
        
        reverseInorder(node.left);
    }
}

// iterative - stack
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        
        while(true) {
            while(curr != null) {
                st.push(curr);
                curr = curr.right;
            }
            
            if(st.isEmpty()) break;
            
            curr = st.pop();
            curr.val = sum = sum + curr.val;
            
            curr = curr.left;
        }
        
        return root;
    }
}

// iterative - constant space - morris
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode curr = root;
        
        while(curr != null) {
            if(curr.right != null) {
                TreeNode succ = curr.right;
                
                while(succ.left != null && succ.left != curr) {
                    succ = succ.left;
                }
                
                if(succ.left != null) {
                    succ.left = null;
                    curr.val = sum = sum + curr.val;
                    curr = curr.left;
                } else {
                    succ.left = curr;
                    curr = curr.right;
                }
            } else {
                curr.val = sum = sum + curr.val;
                curr = curr.left;
            }
        }
        
        return root;
    }
}
