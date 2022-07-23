// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null; 
        
        root.next = null;
        helper(root);
        
        return root;
    }
    
    private void helper(Node node){
        if(node.left == null && node.right == null) return;
        
        node.left.next = node.right;
        if(node.next != null) node.right.next = node.next.left;
        
        helper(node.left);
        helper(node.right);
    }
}
