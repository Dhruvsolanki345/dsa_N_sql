// https://leetcode.com/problems/rotate-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        int count = 0;
        ListNode curr = head, last = head;
        
        while(curr != null){
            last = curr;
            curr = curr.next;
            count++;
        }
        
        k = k % count;
        if(k == 0) return head;
        
        int counter = count - k - 1;
        curr = head;
        while(counter > 0 && curr != null){
            counter--;
            curr = curr.next;
        }
        
        ListNode newHead = curr.next;
        curr.next = null;
        last.next = head;
        
        return newHead;
    }
}
