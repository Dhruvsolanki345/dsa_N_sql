// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

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
    int[] inorder, postorder;
    
    public TreeNode buildTree(int[] _inorder, int[] _postorder) {
        map = new HashMap<>();
        inorder = _inorder;
        postorder=  _postorder;
        
        for(int i = 0; i < inorder.length; i++) 
            map.put(inorder[i], i);
        
        return construct(0, inorder.length-1, 0, postorder.length-1);
    }
    
    private TreeNode construct(int ins, int ine, int posts, int poste) {
        if(ins > ine || posts > poste) return null;
        
        int curr = postorder[poste], currid = map.get(curr), leftCount = currid-ins;
        TreeNode node = new TreeNode(curr);
        
        node.left = construct(ins, currid-1, posts, posts+leftCount-1);
        node.right = construct(currid+1, ine, posts+leftCount, poste-1);
        
        return node;
    }
}
