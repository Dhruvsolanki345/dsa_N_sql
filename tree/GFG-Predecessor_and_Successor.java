// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1

/* BST Node
class Node
{
	int key;
	Node left, right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class GfG {
    public static void findPreSuc(Node root, Res p, Res s, int key) {
       Node curr = root;
       
        while(curr != null) {
            if(key == curr.data){
                if(curr.left!=null){
                    Node temp =curr.left;
                    
                    while(temp.right!=null) {
                        temp =temp.right;
                    }
                    
                    p.pre=temp;
                }
                 
                if(curr.right!=null){
                    Node temp =curr.right;
                    
                    while(temp.left!=null){
                        temp=temp.left;
                    }
                    
                    s.succ=temp;
                }
                return;
            } 
            
            if(key < curr.data) {
                s.succ = curr;
                curr = curr.left;
            } else {
                p.pre = curr;
                curr = curr.right;
            }
        }
    }
}
