// https://www.interviewbit.com/problems/path-to-given-node/
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    ArrayList<Integer> path;
    int B;
    
    public ArrayList<Integer> solve(TreeNode A, int B) {
        path = new ArrayList<>();
        this.B = B;
        
        traverse(A);
        
        return path;
    }
    
    private boolean traverse(TreeNode A){
        if(A == null) return false;
        
        path.add(A.val);
        if(A.val == B) return true;
        
        if(traverse(A.left) == true) return true;
        if(traverse(A.right) == true) return true;
        
        path.remove(path.size() - 1);
        return false;
    }
}
