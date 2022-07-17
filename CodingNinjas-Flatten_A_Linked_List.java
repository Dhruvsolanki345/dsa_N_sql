// https://www.codingninjas.com/codestudio/problems/1112655?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
import java.util.* ;
import java.io.*; 
/****************************************************************

       Following is the class structure of the Node class:

       class Node {
	int data;
	Node next;
	Node child;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}

*****************************************************************/
public class Solution {
	public static Node flattenLinkedList(Node start) {
        return helper(start);
	}
    private static Node helper(Node start){
        if(start == null || start.next == null) return start;
        
        start.next = helper(start.next);
        
        return merge(start, start.next);
    }
    
    private static Node merge(Node l1,Node l2){
        Node head = new Node(0);
        Node curr = head;
        
        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                curr.child = l1;
                l1 = l1.child;
            } else {
                curr.child = l2;
                l2 = l2.child;
            }
            curr = curr.child;
        }
        
        if(l1 != null) curr.child = l1;        
        else curr.child = l2;
        
        return head.child;
    }
}

