// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

// recursion
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode res, target;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode _target) {
        target = _target;
        
        inorder(original, cloned);
        
        return res;
    }
    
    private boolean inorder(TreeNode o, TreeNode c) {
        if(o == null) return false;
        
        if(o == target) {
            res = c;
            return true;
        }
        
        return inorder(o.left, c.left) || inorder(o.right, c.right);
    }
}

// stack

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode res = null;
        Stack<TreeNode> sto = new Stack<>();
        Stack<TreeNode> stc = new Stack<>();
        sto.push(original);
        stc.push(cloned);
        
        while(!sto.isEmpty()) {
            TreeNode curro = sto.pop();
            TreeNode currc = stc.pop();
            
            if(curro == target) {
                res = currc;
                break;
            }
            
            if(curro.left != null) {
                sto.push(curro.left);
                stc.push(currc.left);
            }
            
            if(curro.right != null) {
                sto.push(curro.right);
                stc.push(currc.right);
            }
        }
        
        return res;
    }
}

// bfs: iterative traversal

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode res = null;
        Queue<TreeNode> qo = new LinkedList<>();
        Queue<TreeNode> qc = new LinkedList<>();
        qo.offer(original);
        qc.offer(cloned);
        
        while(!qo.isEmpty()) {
            TreeNode curro = qo.poll();
            TreeNode currc = qc.poll();
            
            if(curro == target) {
                res = currc;
                break;
            }
            
            if(curro.left != null) {
                qo.offer(curro.left);
                qc.offer(currc.left);
            }
            
            if(curro.right != null) {
                qo.offer(curro.right);
                qc.offer(currc.right);
            }
        }
        
        return res;
    }
}
