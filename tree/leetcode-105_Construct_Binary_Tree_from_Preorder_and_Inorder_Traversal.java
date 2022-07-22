// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    Map<Integer, Integer> map;
    int[] preorder, inorder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        this.preorder = preorder;
        this.inorder = inorder;
        
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        
        return createTree(0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode createTree(int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode node = new TreeNode(preorder[preStart]);
        int inNode = map.get(node.val);
        int leftCount = inNode - inStart;
        
        node.left = createTree(preStart + 1, preStart + leftCount, inStart, inNode - 1);
        node.right = createTree(preStart + leftCount + 1, preEnd, inNode + 1, inEnd);
        
        return node;
    }
}
