// https://leetcode.com/problems/copy-list-with-random-pointer/submissions/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node curr = head, newHead = new Node(0);
        Node newCurr = newHead, next = curr;      
        
        while(curr != null){
            next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }
        
        curr = head;
        while(curr != null && curr.next != null){
            if(curr.random != null) curr.next.random = curr.random.next;
            
            curr = curr.next.next;
        }
        
        curr = head;
        while(curr != null && curr.next != null){
            next = curr.next.next;
            newCurr.next = curr.next;
            newCurr = newCurr.next;
            curr.next = next;
            curr = next;
        }
        
        return newHead.next;
    }
}
