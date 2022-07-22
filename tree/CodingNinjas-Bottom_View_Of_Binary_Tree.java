https://www.codingninjas.com/codestudio/problems/893110?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
import java.util.*;

/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/

class BinaryTreeWrapper {
    int hd;
    BinaryTreeNode node;

    BinaryTreeWrapper(int hd, BinaryTreeNode node) {
        this.hd = hd;
        this.node = node;
    }
}


public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<BinaryTreeWrapper> q = new LinkedList<>();
        
        q.add(new BinaryTreeWrapper(0, root));
        while(!q.isEmpty()){
            BinaryTreeWrapper wrapper = q.remove();
            BinaryTreeNode node = wrapper.node;
            int hd = wrapper.hd;
            
            map.put(hd, node.val);
            
            if(node.left != null) q.add(new BinaryTreeWrapper(hd - 1, node.left));
            if(node.right != null) q.add(new BinaryTreeWrapper(hd + 1, node.right));
           
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        
        return res;
    }
}
