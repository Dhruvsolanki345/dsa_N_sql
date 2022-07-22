// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        
        if(root == null) return res;
        
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> lvl = new ArrayList<>();
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                
                lvl.add(node.val);
                
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            
            if(flag == false) Collections.reverse(lvl);
            res.add(lvl);
            flag = !flag;
        }
        
        return res;
    }
}
