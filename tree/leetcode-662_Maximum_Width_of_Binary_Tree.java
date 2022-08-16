// https://leetcode.com/problems/maximum-width-of-binary-tree/

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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int max = 1;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()) {
            int size = q.size(), start = q.peek().getValue();
            
            while(size-- > 0) {
                Pair<TreeNode, Integer> curr = q.poll();
                TreeNode node = curr.getKey();
                
                // Reseting index to the first level as integer overflow can happen
                int i = curr.getValue() - start;
                
                max = Math.max(max, i+1);
                
                if(node.left != null) {
                    q.offer(new Pair(node.left, 2*i + 1));
                }
                
                if(node.right != null) {
                    q.offer(new Pair(node.right, 2*i + 2));
                }
            }
        }
        
        return max;
    }
}
