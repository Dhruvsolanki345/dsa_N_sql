// https://leetcode.com/problems/intersection-of-two-linked-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {        
        ListNode curr1 = headA, curr2 = headB;
        
        while(true){
            if(curr1 == curr2) return curr1;
            if(curr1.next == null && curr2.next == null) return null;
            
            curr1 = (curr1.next == null) ? headB : curr1.next;
            curr2 = (curr2.next == null) ? headA : curr2.next;
        }
    }
}
